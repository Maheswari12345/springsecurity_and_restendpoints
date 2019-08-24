package com.devglan.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
public class Company {
	
	@Id
	@Column(name="company_code")
	private int companyCode;
	public int getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	@Max(value=400,message="please enter valid name")
	@Column(name="company_Name")
	private String companyName;
	
	@NotNull
	@Column(name="turnover")
	private BigDecimal turnOver;
	@Column(name="ceo")
	private String ceoName;
	@Column(name="boardofdirectors")
	private String directorsName;
	
	
	@Column(name="sector_id")

	private int sectorId;

	
	public int getSectorId() {
		return sectorId;
	}
	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}
	@Column(name="breifwriteup")
	private String briefWriteUp;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public BigDecimal getTurnOver() {
		return turnOver;
	}
	public void setTurnOver(BigDecimal turnOver) {
		this.turnOver = turnOver;
	}
	public String getCeoName() {
		return ceoName;
	}
	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}
	public String getDirectorsName() {
		return directorsName;
	}
	public void setDirectorsName(String directorsName) {
		this.directorsName = directorsName;
	}
	
	public String getBriefWriteUp() {
		return briefWriteUp;
	}
	public void setBriefWriteUp(String briefWriteUp) {
		this.briefWriteUp = briefWriteUp;
	}
	

	@Override
	public String toString() {
		return "Company [companyCode=" + companyCode + ", companyName=" + companyName + ", turnOver=" + turnOver
				+ ", ceoName=" + ceoName + ", directorsName=" + directorsName + ", sectorId=" 
				+ ", briefWriteUp=" + briefWriteUp + ", stockCode=" +  ", stockexchange_id=" + "]";
	}
	
}
