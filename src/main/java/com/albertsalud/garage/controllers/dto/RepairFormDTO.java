package com.albertsalud.garage.controllers.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.albertsalud.garage.model.entities.Vehicle;

import lombok.Data;

@Data
public class RepairFormDTO {
	private Long id;
	
	@NotBlank
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date repairDate;
	
	@NotEmpty
	private Float amount;
	
	@NotEmpty
	private Vehicle vehicle;
	
	private List<Vehicle> vehicles;
	
	@NotBlank
	private String garage;
	
	private Long vehicleKMs;
	
	private  MultipartFile bill;
	
	private String tags;
}
