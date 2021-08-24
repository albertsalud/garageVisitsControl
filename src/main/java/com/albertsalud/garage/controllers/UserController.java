package com.albertsalud.garage.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.albertsalud.garage.controllers.dto.UserFormDTO;
import com.albertsalud.garage.model.entities.User;
import com.albertsalud.garage.model.services.UserServices;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/new")
	public String getNewUser(Model model) {
		return getUserForm(model, new UserFormDTO());
	}

	private String getUserForm(Model model, UserFormDTO userFormDTO) {
		model.addAttribute("userFormDTO", userFormDTO);
		return "userForm";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute UserFormDTO dto, 
			Model model) {
		User user = modelMapper.map(dto, User.class);
		userServices.save(user);
		return "registrationConfirmed";
	}

}
