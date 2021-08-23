package com.albertsalud.garage.controllers.dto;

import java.util.Arrays;
import java.util.List;

import com.albertsalud.garage.model.entities.VehicleType;

import lombok.Data;

@Data
public class VehicleFormDTO {
	
	private Long id;
	private VehicleType type;
	private String identificationNumber;
	
	private List<VehicleType> types = Arrays.asList(VehicleType.values());
	
}
