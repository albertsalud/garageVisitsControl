package com.albertsalud.garage.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.garage.model.dao.VehicleDAO;
import com.albertsalud.garage.model.entities.Vehicle;

@Service
public class VehicleServices {
	
	@Autowired
	private VehicleDAO vehicleDao;
	
	public Vehicle save(Vehicle vehicle) {
		return vehicleDao.save(vehicle);
	}

	public List<Vehicle> getVehicles() {
		return vehicleDao.findAll();
	}

}
