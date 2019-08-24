package com.devglan.controller;

import com.devglan.dao.CompanyDao;
import com.devglan.dao.IpoDao;
import com.devglan.dao.SectorsDao;
import com.devglan.dao.stockpriceDao;
import com.devglan.model.ApiResponse;
import com.devglan.model.Company;
import com.devglan.model.Ipo_planned;
import com.devglan.model.Sectors;
import com.devglan.model.User;
import com.devglan.model.UserDto;
import com.devglan.service.CompanyService;
import com.devglan.service.IpoService;
import com.devglan.service.SectorService;
import com.devglan.service.StockPriceService;
import com.devglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    CompanyDao companydao;
    @Autowired
    SectorsDao sectorsDao;
    @Autowired
    IpoDao ipodao;
    @Autowired
    stockpriceDao stockpricedao;
    @Autowired
    private CompanyService cservice;
    @Autowired
    SectorService sectorservice;
    @Autowired
    StockPriceService spservice;
    @Autowired
    IpoService iposervice;

    
   
    @GetMapping("/sectors/price/{name}/{from_date}/{to_date}")
    public ApiResponse getsectorpriceList(@PathVariable("name") String name,@PathVariable("from_date") Date from_date,@PathVariable("to_date") Date to_date)
    {
    	System.out.println("hii");
    	Sectors sectors=sectorservice.findBysectorName(name);
    	List<Integer> stockprice=new ArrayList<Integer>();
    	List<Company> companies =new ArrayList<>(); 
        cservice.findBysectorId(sectors.getId()).forEach(companies::add);
    	int[] companyCode=new int[10];
    	int total=0;
    	for(int i=0,k=0;i<companies.size();i++,k++)
    	{
    	 companyCode[k]=companies.get(i).getCompanyCode();
    	  spservice.getStockPrice(companyCode[k], from_date, to_date).forEach(stockprice::add);
    	}
    	for(int j=0;j<stockprice.size();j++)
    	{
    		total=total+stockprice.get(j);
    	}
    	System.out.println(stockprice);
    	//return stockprice;
    	return new ApiResponse<>(HttpStatus.OK.value(), "PRICE FETCHED SUCCESSFULLY.",total);
    	
    }
    @GetMapping("/company/price/{name}/{from_date}/{to_date}")
    public ApiResponse<List<Integer>> getStockPriceList(@PathVariable("name") String name,@PathVariable("from_date") Date from_date,@PathVariable("to_date") Date to_date)
    {
    	Company companies=cservice.findBycompanyName(name);

    	return new ApiResponse<>(HttpStatus.OK.value(), "price list fetched successfully",spservice.getStockPrice(companies.getCompanyCode(), from_date, to_date));
    	
    }
   

   
    @GetMapping("/sector/company/{name}")
    public ApiResponse<List<Company>> getCompanyList(@PathVariable("name") String name)
    {
    	Sectors sectors= sectorservice.findBysectorName(name);
    	System.out.print(sectors.getId());
    	return new ApiResponse<>(HttpStatus.OK.value(), "Company_names fetched using sector name successfully.",cservice.findBysectorId(sectors.getId()));
    }

 
    @GetMapping("/company/{name}")
    public ApiResponse<List<Ipo_planned>> getIpoList1(@PathVariable("name") String name)
    {
    	Company companies=cservice.findBycompanyName(name);
    	System.out.println(companies.getCompanyCode());
    	return new ApiResponse<>(HttpStatus.OK.value(), "Company IPO_details fetched using company name successfully.",iposervice.findBycompanyCode(companies.getCompanyCode()));
    }
    
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        userService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }
    @GetMapping("/company/pattern/{name}")
    public ApiResponse<List<Company>> getCompanyNamematching(@PathVariable("name") String name)
    {
    	return new ApiResponse<>(HttpStatus.OK.value(), "Companies matching pattern",cservice.findBycompanyName1(name));
    }



}
