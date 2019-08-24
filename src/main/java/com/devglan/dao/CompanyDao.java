package com.devglan.dao;

import java.util.Arrays;
import java.util.List;

import com.devglan.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface CompanyDao extends JpaRepository<Company, Integer>{
	

	
	public List<Company> findBysectorId(int sectorId);
	public Company findBycompanyName(String companyName);
	@Query("Select c From Company c where c.companyName LIKE  %:name% ")
	public List<Company> findBycompanyName1(@Param("name") String name);
	  
}