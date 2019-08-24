package com.devglan.dao;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devglan.model.*;

public interface stockpriceDao extends JpaRepository <StockPrice , Integer> {
	
	@Query("Select s.currentPrice from StockPrice s where s.companyCode= :companyCode and s.date between :from_date and :to_date")
	public List<Integer> getStockPrice(@Param("companyCode") int companyCode,@Param("from_date") Date from_date,@Param("to_date") Date to_date);

	
	/*@Query("Select SUM(s.currentPrice) from StockPrice s where s.companyCode= :companyCode and s.date between :from_date and :to_date")
	public int getStockPrice1(@Param("companyCode") int companyCode,@Param("from_date") Date from_date,@Param("to_date") Date to_date);*/

}
