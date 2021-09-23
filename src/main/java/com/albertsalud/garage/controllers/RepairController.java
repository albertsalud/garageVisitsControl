package com.albertsalud.garage.controllers;

import java.util.List;

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

@Controller
@RequestMapping("/repairs")
public class RepairController {
	
	@Autowired
	private VehicleServices vehicleServices;
	
	@Autowired
	private RepairServices repairServices;
	
	@Autowired
	private ModelMapper modelMapper;
	
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
		
		Repair repairToSave = modelMapper.map(dto, Repair.class);
		
		if(!vehicleServices.getVehicles(user.getUser()).contains(repairToSave.getVehicle())) {
			model.addAttribute("message", "Invalid vehicle!");
			return this.getRepairForm(model, user, dto);
		}
		
		if(repairToSave.getId() != null && 
				repairServices.getRepair(repairToSave.getId(), user.getUser()) ==  null) {
			model.addAttribute("message", "Unauthorized action!");
			return this.getRepairForm(model, user, dto);
		}
		
		repairServices.saveRepair(repairToSave);
		
		return getRepairs(model, user);
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
