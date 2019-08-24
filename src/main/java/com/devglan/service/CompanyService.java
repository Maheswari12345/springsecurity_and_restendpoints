package com.devglan.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devglan.model.Company;

public interface CompanyService{
	public List<Company> findBysectorId(int sectorId);
	public Company findBycompanyName(String companyName);
	@Query("Select c From Company c where c.companyName LIKE  %:name% ")
	public List<Company> findBycompanyName1(@Param("name") String name);
}
