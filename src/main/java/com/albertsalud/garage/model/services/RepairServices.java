package com.albertsalud.garage.model.services;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albertsalud.garage.model.dao.RepairDAO;
import com.albertsalud.garage.model.entities.Repair;
import com.albertsalud.garage.model.entities.User;
import com.albertsalud.garage.utils.FTPServices;

@Service
public class RepairServices {
	
	private static final String UPLOADED_IMAGES_FOLDER = "/uploaded/images"; 
	
	@Autowired
	private FTPServices ftpServices;
	
	@Autowired
	private RepairDAO repairDao;
	
	public Repair saveRepair(Repair repair) {
		return repairDao.save(repair);
	}

	public Repair getRepair(Long id, User user) {
		return repairDao.getByIdAndVehicleOwner(id, user);
	}

	public List<Repair> findByVehicleOwner(User user) {
		return repairDao.findByVehicleOwnerOrderByRepairDateDesc(user);
	}

	public void deleteRepair(Repair requestedRepair) {
		repairDao.delete(requestedRepair);
		this.deleteRepairBill(requestedRepair);
		
	}
	
	public void deleteRepairBill(Repair requestedRepair) {
		if(Strings.isNotEmpty(requestedRepair.getBillFileName())) {
			ftpServices.deleteFile(UPLOADED_IMAGES_FOLDER, requestedRepair.getBillFileName());
		}
	}

}
