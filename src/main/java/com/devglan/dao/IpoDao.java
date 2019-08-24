package com.devglan.dao;
import com.devglan.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IpoDao extends JpaRepository<Ipo_planned , Integer> {

	public List<Ipo_planned> findBycompanyCode(int companyCode);
}
