package com.devglan.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.devglan.dao.*;
import com.devglan.service.*;
import com.devglan.dao.*;
import com.devglan.model.*;


@RestController
public class AllRestController {


@Autowired
CompanyDao companydao;
@Autowired
SectorsDao sectorsDao;
@Autowired
IpoDao ipodao;
@Autowired
stockpriceDao stockpricedao;




@GetMapping("/sector/{name}")
public List<Company> getCompanyList(@PathVariable("name") String name)
{
	Sectors sectors=sectorsDao.findBysectorName(name);
	System.out.print(sectors.getId());
	return  companydao.findBysectorId(sectors.getId());
}

@GetMapping("/company/{name}")
public List<Ipo_planned> getIpoList1(@PathVariable("name") String name)
{
	Company companies=companydao.findBycompanyName(name);
	System.out.println(companies.getCompanyCode());
	return ipodao.findBycompanyCode(companies.getCompanyCode());
}

@GetMapping("/company/pattern/{name}")
public List<Company> getCompanyNamematching(@PathVariable("name") String name)
{
	return companydao.findBycompanyName1(name);
}

@GetMapping("/company/price/{name}/{from_date}/{to_date}")
public List<Integer> getStockPriceList(@PathVariable("name") String name,@PathVariable("from_date") Date from_date,@PathVariable("to_date") Date to_date)
{
	Company companies=companydao.findBycompanyName(name);

	return stockpricedao.getStockPrice(companies.getCompanyCode(), from_date, to_date);
	
}
@GetMapping("/sectors/price/{name}/{from_date}/{to_date}")
public int getsectorpriceList(@PathVariable("name") String name,@PathVariable("from_date") Date from_date,@PathVariable("to_date") Date to_date)
{
	System.out.println("hii");
	Sectors sectors=sectorsDao.findBysectorName(name);
	List<Integer> stockprice=new ArrayList<Integer>();
	List<Company> companies =new ArrayList<>(); 
    companydao.findBysectorId(sectors.getId()).forEach(companies::add);
	int[] companyCode=new int[10];
	int total=0;
	for(int i=0,k=0;i<companies.size();i++,k++)
	{
	 companyCode[k]=companies.get(i).getCompanyCode();
	  stockpricedao.getStockPrice(companyCode[k], from_date, to_date).forEach(stockprice::add);
	}
	for(int j=0;j<stockprice.size();j++)
	{
		total=total+stockprice.get(j);
	}
	//System.out.println(stockprice);
	//return stockprice;
	return total;
}





}
