package com.devglan.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devglan.dao.SectorsDao;
import com.devglan.dao.UserDao;
import com.devglan.model.Sectors;
import com.devglan.model.User;
import com.devglan.service.SectorService;
@Service(value="SectorService")
public class SectorImpl implements UserDetailsService,SectorService{

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	@Autowired
	UserDao userDao;
	@Autowired
	SectorsDao sectordao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	@Override
	public Sectors findBysectorName(String sectorName) {
	
		return sectordao.findBysectorName(sectorName);
	}

}
