package com.albertsalud.garage.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.albertsalud.garage.controllers.dto.SigninFormDTO;
import com.albertsalud.garage.controllers.dto.UserFormDTO;
import com.albertsalud.garage.model.entities.User;
import com.albertsalud.garage.model.services.UserServices;

@Controller
public class LoginController {
	
	private static final boolean ENCODE_PASSWORD = true;

	@Autowired
	private UserServices userServices;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = {"", "/"})
	public String getLoginForm(Model model) {
		return goToLoginForm(model, new SigninFormDTO());
	}

	private String goToLoginForm(Model model, SigninFormDTO dto) {
		model.addAttribute("signinFormDTO", dto);
		return "index";
	}
	
	@PostMapping("/signin")
	public String signInProcess(@Valid @ModelAttribute SigninFormDTO dto,
			BindingResult bindingResult,
			Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("visibleForm", "signin");
			return this.goToLoginForm(model, dto);
		}
		
		try {
			userServices.loadUserByUsername(dto.getEmail());
		
			model.addAttribute("visibleForm", "signin");
			model.addAttribute("message", "User exists in database!");
			return goToLoginForm(model, dto);
		
		} catch (UsernameNotFoundException e) {
			User newUser = modelMapper.map(dto, User.class);
			userServices.save(newUser, ENCODE_PASSWORD);
			
			return "registrationConfirmed";
		}
		
	}
}
