package com.jaehyeon2.be.beans.param;

import com.jaehyeon2.be.beans.enums.APIType;

public class CompanyParam {
	
	private String companyNo;
	private String companyName;
	private String companyInfo;
	private String companyMeet;
	private String companySummary;
	private String companyEmail;
	private String companyStatus;
	
	private APIType APIType;
	
	public String getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}
	public String getCompanyMeet() {
		return companyMeet;
	}
	public void setCompanyMeet(String companyMeet) {
		this.companyMeet = companyMeet;
	}
	public String getCompanySummary() {
		return companySummary;
	}
	public void setCompanySummary(String companySummary) {
		this.companySummary = companySummary;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getCompanyStatus() {
		return companyStatus;
	}
	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
	}
	public APIType getAPIType() {
		return APIType;
	}
	public void setAPIType(APIType aPIType) {
		APIType = aPIType;
	}

}
