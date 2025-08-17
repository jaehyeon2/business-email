package com.jaehyeon2.be.beans.model;

public class CompanyModel extends BasicModel{
	
	private String companyNo;
	private String companyName;
	private String companyInfo;
	private String companyMeet;
	private String companyEmailContent;
	
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
	public String getCompanyEmailContent() {
		return companyEmailContent;
	}
	public void setCompanyEmailContent(String companyEmailContent) {
		this.companyEmailContent = companyEmailContent;
	}

}
