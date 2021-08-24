package com.albertsalud.garage.controllers.dto;

import java.util.Date;
import java.util.List;

import com.albertsalud.garage.model.entities.Vehicle;

import lombok.Data;

@Data
public class RepairFormDTO {
	private Long id;
	private Date repairDate;
	private Float amount;
	private Vehicle vehicle;
	private List<Vehicle> vehicles;

}
