package com.devglan.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

public interface StockPriceService {
	public List<Integer> getStockPrice(@Param("companyCode") int companyCode,@Param("from_date") Date from_date,@Param("to_date") Date to_date);

}
