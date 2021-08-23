package com.albertsalud.garage.model.entities;

import lombok.Getter;

@Getter
public enum VehicleType {
	
	CAR(1L, "Car"), 
	MOTORCYCLE(2L, "Motorcycle");
	
	private Long id;
	private String description;
	
	private VehicleType(Long id, String description) {
		this.id = id;
		this.description = description;
		
	}

}
