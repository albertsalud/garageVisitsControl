package com.albertsalud.garage.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.garage.model.dao.VehicleDAO;
import com.albertsalud.garage.model.entities.User;
import com.albertsalud.garage.model.entities.Vehicle;

@Service
public class VehicleServices {
	
	@Autowired
	private VehicleDAO vehicleDao;
	
	@Autowired
	private RepairServices repairServices;
	
	public Vehicle save(Vehicle vehicle) {
		return vehicleDao.save(vehicle);
	}

	public List<Vehicle> getVehicles(User user) {
		return vehicleDao.findByOwner(user);
	}

	public Vehicle getVehicle(User user, Long vehicleId) {
		return vehicleDao.findByOwnerAndId(user, vehicleId).orElse(null);
	}

	public void deleteVehicle(Vehicle requestedVehicle) {
		vehicleDao.delete(requestedVehicle);
		
		requestedVehicle.getRepairs().forEach(repair -> {
			repairServices.deleteRepairBill(repair);
		});
	}

}
