package com.albertsalud.garage.controllers;

import javax.validation.Valid;

import org.apache.logging.log4j.util.Strings;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.albertsalud.garage.controllers.dto.UserFormDTO;
import com.albertsalud.garage.model.entities.User;
import com.albertsalud.garage.model.services.UserServices;
import com.albertsalud.garage.security.UserPrincipal;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private String getUserForm(Model model, UserFormDTO userFormDTO) {
		model.addAttribute("userFormDTO", userFormDTO);
		return "userForm";
	}
	
	@PostMapping("/save")
	public String saveUser(@Valid @ModelAttribute UserFormDTO dto, 
			BindingResult bindingResult,
			@AuthenticationPrincipal UserPrincipal user,
			Model model) {
		
		if(bindingResult.hasErrors()) {
			return this.getUserForm(model, dto);
		}
		
		User userToSave = manageUser(user, dto);
		
		userToSave = userServices.save(userToSave, Strings.isNotBlank(dto.getPassword()));
		user.setUser(userToSave);
		
		return "redirect:/vehicles";
	}
	
	private User manageUser(UserPrincipal user, @Valid UserFormDTO dto) {
		User userToSave = modelMapper.map(dto, User.class);
		userToSave.setActive(true);
		userToSave.setId(user.getUser().getId());
		
		if(Strings.isBlank(dto.getPassword())) {
			userToSave.setPassword(user.getPassword());
		}
		
		return userToSave;
	}

	@GetMapping("/me")
	public String getUser(Model model,
			@AuthenticationPrincipal UserPrincipal user) {
		UserFormDTO dto = modelMapper.map(user.getUser(), UserFormDTO.class);
		dto.setPassword(null);
		return getUserForm(model, dto);
	}

}
