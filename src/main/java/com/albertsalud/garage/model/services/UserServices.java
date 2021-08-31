package com.albertsalud.garage.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.albertsalud.garage.model.dao.UserDAO;
import com.albertsalud.garage.model.entities.User;
import com.albertsalud.garage.security.UserPrincipal;

@Service
public class UserServices implements UserDetailsService{
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getByEmail(username);
		if(user == null) throw new UsernameNotFoundException("User not found!");
		
		return new UserPrincipal(user);
	}
	
	public User save(User user, boolean managePassword) {
		if(managePassword) this.managePassword(user);
		return userDao.save(user);
	}

	public User save(User user) {
		return this.save(user, false);
	}

	private void managePassword(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	}

}
