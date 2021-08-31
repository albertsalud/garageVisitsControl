package com.albertsalud.garage.controllers.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.albertsalud.garage.controllers.dto.validators.PasswordDoubleCheck;

import lombok.Data;


@Data
@PasswordDoubleCheck(password = "password", repeatedPassword = "repeatPassword")
public class UserFormDTO {
	
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String surname;
	
	@NotBlank
	@Email
	private String email;
	
	private String password;
	private String repeatPassword;
	
}
