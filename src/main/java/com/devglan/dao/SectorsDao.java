package com.devglan.dao;
import com.devglan.model.*;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SectorsDao extends JpaRepository<Sectors, Integer>{

	public Sectors findBysectorName(String sectorName);

}
