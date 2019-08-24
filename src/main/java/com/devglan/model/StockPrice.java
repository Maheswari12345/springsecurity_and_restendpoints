package com.devglan.model;
import java.sql.Time;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name="stock_price")
public class StockPrice {
	
	    @Id
	    @Column(name="stock_code")
	    private int stockCode;
	    @Column(name="company_code")
		private int companyCode;
	    @Column(name="stock_exchange")
		private String stockExchange;
	    @Column(name="current_price")
		private double currentPrice;
	    @Column(name="date")
	    private Date date;
	    @Column(name="periodicity")
		private int periodicity;
		public int getCompanyCode() {
			return companyCode;
		}
		public void setCompanyCode(int companyCode) {
			this.companyCode = companyCode;
		}
		public String getStockExchange() {
			return stockExchange;
		}
		public void setStockExchange(String stockEx) {
			this.stockExchange = stockEx;
		}
		public double getCurrentPrice() {
			return currentPrice;
		}
		public void setCurrentPrice(double price) {
			this.currentPrice = price;
		}
		public int getStockCode() {
			return stockCode;
		}
		public void setStockCode(int stockCode) {
			this.stockCode = stockCode;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public int getPeriodicity() {
			return periodicity;
		}
		public void setPeriodicity(int periodicity) {
			this.periodicity = periodicity;
		}
		
		
		

	}


