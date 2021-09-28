package com.albertsalud.garage.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.albertsalud.garage.controllers.dto.RepairFormDTO;
import com.albertsalud.garage.model.entities.Repair;
import com.albertsalud.garage.model.entities.Vehicle;
import com.albertsalud.garage.model.services.RepairServices;
import com.albertsalud.garage.model.services.VehicleServices;
import com.albertsalud.garage.security.UserPrincipal;
import com.albertsalud.garage.utils.FileUploadService;

@Controller
@RequestMapping("/repairs")
public class RepairController {
	
	private static final String UPLOADED_IMAGES_FOLDER = "/uploaded/images"; 
	
	@Autowired
	private VehicleServices vehicleServices;
	
	@Autowired
	private RepairServices repairServices;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@GetMapping(value = {"", "/"})
	public String getRepairs(Model model,
			@AuthenticationPrincipal UserPrincipal user) {
		
		List<Repair> repairs = repairServices.findByVehicleOwner(user.getUser());
		model.addAttribute("repairs", repairs);
		
		return "repairList";
	}
	
	@GetMapping("/new")
	public String getNewRepair(Model model,
			@AuthenticationPrincipal UserPrincipal user,
			@RequestParam(name = "vehicle", required = false) Long vehicle) {
		RepairFormDTO dto = new RepairFormDTO();
		if(vehicle != null) {
			Vehicle requestedVehicle = vehicleServices.getVehicle(user.getUser(), vehicle);
			if(requestedVehicle != null) dto.setVehicle(requestedVehicle);
		}
		
		return getRepairForm(model, user, dto);
	}

	
	private String getRepairForm(Model model, 
			UserPrincipal user,
			RepairFormDTO repairFormDTO) {
		
		repairFormDTO.setVehicles(vehicleServices.getVehicles(user.getUser()));
		model.addAttribute("repairFormDTO", repairFormDTO);
		
		return "repairForm";
	}
	
	@PostMapping("/save")
	public String saveRepair(@ModelAttribute RepairFormDTO dto, 
			@AuthenticationPrincipal UserPrincipal user,
			Model model) {
		
		
		
		if(!vehicleServices.getVehicles(user.getUser()).contains(dto.getVehicle())) {
			model.addAttribute("message", "Invalid vehicle!");
			return this.getRepairForm(model, user, dto);
		}
		
		if(dto.getId() != null && 
				repairServices.getRepair(dto.getId(), user.getUser()) ==  null) {
			model.addAttribute("message", "Unauthorized action!");
			return this.getRepairForm(model, user, dto);
		}
		
		Repair repairToSave = getRepairFromDTO(dto, user); 
		repairServices.saveRepair(repairToSave);
		
		return getRepairs(model, user);
	}
	
	private Repair getRepairFromDTO(RepairFormDTO dto, UserPrincipal user) {
		Repair repairToSave = modelMapper.map(dto, Repair.class);
		Repair storedRepair = repairServices.getRepair(dto.getId(), user.getUser());
		
		if(Strings.isNotEmpty(dto.getBill().getOriginalFilename())) {
			String managedFileName = manageUploadedFileName(dto.getBill().getOriginalFilename());
			repairToSave.setBillFileName(managedFileName);
			
			if(storedRepair != null) fileUploadService.deleteFile(UPLOADED_IMAGES_FOLDER, storedRepair.getBillFileName());
			fileUploadService.saveFile(UPLOADED_IMAGES_FOLDER, managedFileName, dto.getBill());
		
		} else {
			repairToSave.setBillFileName("");
			
			if(storedRepair != null) {
				repairToSave.setBillFileName(storedRepair.getBillFileName());
			}
		}
		
		return repairToSave;
	}

	private String manageUploadedFileName(String originalFilename) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhmm_");
		return sdf.format(new Date()) + originalFilename;
	}

	@GetMapping("{repairId}")
	public String getVehicle(Model model,
			@AuthenticationPrincipal UserPrincipal user,
			@PathVariable Long repairId) {
		Repair requestedRepair = repairServices.getRepair(repairId, user.getUser());
		RepairFormDTO dto = new RepairFormDTO();
		
		if(requestedRepair == null) {
			model.addAttribute("message", "Unauthorized action!");
		} else {
			dto = modelMapper.map(requestedRepair, RepairFormDTO.class);
		}
		
		return getRepairForm(model, user, dto);
	}

}
