package com.albertsalud.garage.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.garage.model.dao.RepairDAO;
import com.albertsalud.garage.model.entities.Repair;
import com.albertsalud.garage.model.entities.User;

@Service
public class RepairServices {
	
	@Autowired
	private RepairDAO repairDao;
	
	public Repair saveRepair(Repair repair) {
		return repairDao.save(repair);
	}

	public Repair getRepair(Long id, User user) {
		return repairDao.getByIdAndVehicleOwner(id, user);
	}

	public List<Repair> findByVehicleOwner(User user) {
		return repairDao.findByVehicleOwner(user);
	}

}
