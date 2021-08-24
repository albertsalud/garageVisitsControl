package com.albertsalud.garage.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.albertsalud.garage.model.entities.Repair;

public interface RepairDAO extends JpaRepository<Repair, Long>{

}
