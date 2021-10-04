package com.albertsalud.garage.controllers;

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

import com.albertsalud.garage.controllers.dto.VehicleFormDTO;
import com.albertsalud.garage.model.entities.Vehicle;
import com.albertsalud.garage.model.services.VehicleServices;
import com.albertsalud.garage.security.UserPrincipal;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleServices vehicleServices;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/new")
	public String getNewVehicle(Model model) {
		return getVehicleForm(model, new VehicleFormDTO());
		
	}

	private String getVehicleForm(Model model, VehicleFormDTO dto) {
		model.addAttribute("vehicleFormDTO", dto);
		return "vehicleForm";
	}
	
	@PostMapping("/save")
	public String saveVehicle(@ModelAttribute VehicleFormDTO dto, 
			@AuthenticationPrincipal UserPrincipal user,
			Model model) {
		
		Vehicle vehicle = modelMapper.map(dto, Vehicle.class);
		vehicle.setOwner(user.getUser());
		
		if(isAuthorizedOperation(vehicle)) {
			vehicleServices.save(vehicle);
		}
		return getVehicles(model, user);
	}
	
	private boolean isAuthorizedOperation(Vehicle vehicle) {
		return vehicle.getId() == null || 
				vehicleServices.getVehicle(vehicle.getOwner(), vehicle.getId()) != null;
		
	}

	@GetMapping(value = {"", "/"})
	public String getVehicles(Model model,
			@AuthenticationPrincipal UserPrincipal user) {
		model.addAttribute("vehicles", vehicleServices.getVehicles(user.getUser()));
		return "vehicleList";
	}
	
	@GetMapping("{vehicleId}")
	public String getVehicle(Model model,
			@AuthenticationPrincipal UserPrincipal user,
			@PathVariable Long vehicleId) {
		Vehicle requestedVehicle = vehicleServices.getVehicle(user.getUser(), vehicleId);
		if(requestedVehicle == null) {
			model.addAttribute("message", "Vehicle ID not found!");
			return this.getNewVehicle(model);
		}
		
		VehicleFormDTO dto = modelMapper.map(requestedVehicle, VehicleFormDTO.class);
		
		return getVehicleForm(model, dto);
	}
	
	@GetMapping("/delete")
	public String deleteVehicle(Model model,
			@AuthenticationPrincipal UserPrincipal user,
			@RequestParam(name = "vehicle", required = true) Long vehicleId) {
		
		Vehicle requestedVehicle = vehicleServices.getVehicle(user.getUser(), vehicleId);
		if(requestedVehicle == null) {
			model.addAttribute("message", "Unauthorized action!");
		} else {
			vehicleServices.deleteVehicle(requestedVehicle);
		}
		return this.getVehicles(model, user);
	}

}
