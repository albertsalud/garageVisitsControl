package com.albertsalud.garage.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.garage.model.dao.RepairDAO;
import com.albertsalud.garage.model.entities.Repair;

@Service
public class RepairServices {
	
	@Autowired
	private RepairDAO repairDao;
	
	public Repair saveRepair(Repair repair) {
		return repairDao.save(repair);
	}

}
