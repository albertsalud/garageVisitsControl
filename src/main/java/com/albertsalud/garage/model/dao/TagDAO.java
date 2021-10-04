package com.albertsalud.garage.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.albertsalud.garage.model.entities.Tag;
import com.albertsalud.garage.model.entities.User;

public interface TagDAO extends JpaRepository<Tag, Long> {

	public List<Tag> findByUser(User user);
}
