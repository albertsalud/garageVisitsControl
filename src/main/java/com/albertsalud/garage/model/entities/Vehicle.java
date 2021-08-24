package com.albertsalud.garage.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "gvc_vehicles")
@Data
public class Vehicle {
	
	@Id
	@SequenceGenerator(name = "vehicle_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_seq")
	private Long id;
	
	@ManyToOne
	private User owner;
	private VehicleType type;
	private String identificationNumber;

}
