package com.albertsalud.garage.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.albertsalud.garage.model.entities.Vehicle;

public interface VehicleDAO extends JpaRepository<Vehicle, Long> {

}
