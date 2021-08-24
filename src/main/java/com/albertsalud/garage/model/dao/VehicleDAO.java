package com.albertsalud.garage.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.albertsalud.garage.model.entities.User;
import com.albertsalud.garage.model.entities.Vehicle;

public interface VehicleDAO extends JpaRepository<Vehicle, Long> {

	public List<Vehicle> findByOwner(User user);

	public Optional<Vehicle> findByOwnerAndId(User user, Long vehicleId);

}
