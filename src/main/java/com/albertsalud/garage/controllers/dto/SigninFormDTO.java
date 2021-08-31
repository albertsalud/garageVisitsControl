package com.albertsalud.garage.controllers.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.albertsalud.garage.controllers.dto.validators.PasswordDoubleCheck;

import lombok.Data;


@Data
@PasswordDoubleCheck(password = "password", repeatedPassword = "repeatPassword")
public class SigninFormDTO {
	
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String surname;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(min = 6, max = 10, message = "Password must contain between 6 and 10 characters.")
	private String password;
	private String repeatPassword;
	
}
