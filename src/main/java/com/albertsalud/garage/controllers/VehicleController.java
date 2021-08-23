package com.albertsalud.garage.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.albertsalud.garage.controllers.dto.VehicleFormDTO;
import com.albertsalud.garage.model.entities.Vehicle;
import com.albertsalud.garage.model.services.VehicleServices;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleServices vehicleServices;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/new")
	public String getVehicle(Model model) {
		return getVehicleForm(model, new VehicleFormDTO());
		
	}

	private String getVehicleForm(Model model, VehicleFormDTO dto) {
		model.addAttribute("vehicleFormDTO", dto);
		return "vehicleForm";
	}
	
	@PostMapping("/save")
	public String saveVehicle(@ModelAttribute VehicleFormDTO dto, 
			Model model) {
		Vehicle vehicle = modelMapper.map(dto, Vehicle.class);
		vehicleServices.save(vehicle);
		return getVehicles(model);
	}
	
	@GetMapping(value = {"", "/"})
	public String getVehicles(Model model) {
		model.addAttribute("vehicles", vehicleServices.getVehicles());
		return "vehicleList";
	}

}
