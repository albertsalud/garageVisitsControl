package com.albertsalud.garage.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "gvc_users")
@Data
public class User {
	
	@Id
	@SequenceGenerator(name = "users_seq",
			allocationSize = 1)
	@GeneratedValue(generator = "users_seq",
		strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	private String password;
	private boolean active;

}
