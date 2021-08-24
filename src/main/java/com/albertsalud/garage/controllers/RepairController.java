package com.albertsalud.garage.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.albertsalud.garage.controllers.dto.RepairFormDTO;
import com.albertsalud.garage.model.entities.Repair;
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
	
	@GetMapping("/new")
	public String getNewRepair(Model model,
			@AuthenticationPrincipal UserPrincipal user) {
		return getRepairForm(model, user, new RepairFormDTO());
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
			Model model) {
		
		Repair repairToSave = modelMapper.map(dto, Repair.class);
		repairServices.saveRepair(repairToSave);
		
		return "repairList";
	}

}
