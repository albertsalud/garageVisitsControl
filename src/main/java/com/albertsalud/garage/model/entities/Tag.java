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
@Table(name="gvc_tags")
@Data
public class Tag {
	@Id
	@SequenceGenerator(name = "tags_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "tags_seq")
	private Long id;
	
	@ManyToOne
	private User user;
	private String value;
	
	public Tag() {};
	
	public Tag(User user, String value) {
		this.user = user;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "\"" + this.value + "\"";
	}
}
