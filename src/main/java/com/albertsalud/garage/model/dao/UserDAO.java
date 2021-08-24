package com.albertsalud.garage.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.albertsalud.garage.model.entities.User;

public interface UserDAO extends JpaRepository<User, Long>{

	public User getByEmail(String username);

}
