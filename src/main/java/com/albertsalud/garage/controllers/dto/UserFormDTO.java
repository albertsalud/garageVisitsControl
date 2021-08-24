package com.albertsalud.garage.controllers.dto;

import lombok.Data;

@Data
public class UserFormDTO {
	
	private Long id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String repeatPassword;

}
