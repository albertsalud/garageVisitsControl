package com.albertsalud.garage.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.albertsalud.garage.model.entities.Repair;
import com.albertsalud.garage.model.entities.User;

public interface RepairDAO extends JpaRepository<Repair, Long>{

	Repair getByIdAndVehicleOwner(Long id, User owner);
	
	List<Repair> findByVehicleOwner(User owner);

}
