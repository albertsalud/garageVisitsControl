package com.albertsalud.garage.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="gvc_repairs")
@Data
public class Repair {
	
	@Id
	@SequenceGenerator(name = "repairs_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "repairs_seq")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date repairDate;
	
	@Column(nullable = false)
	private Float amount;
	
	@ManyToOne
	private Vehicle vehicle;
	
}
