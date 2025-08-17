package com.jaehyeon2.be.beans.model;

import java.util.List;

public class BeModel {
	
	private CompanyModel company;
	private List<CompanyModel> companyList;
	private int companyCount;
	
	private boolean responseResult;
	private String responseMessage;
	
	private GptResponseModel gptResponse;
	
	public CompanyModel getCompany() {
		return company;
	}
	public void setCompany(CompanyModel company) {
		this.company = company;
	}
	public List<CompanyModel> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<CompanyModel> companyList) {
		this.companyList = companyList;
	}
	public int getCompanyCount() {
		return companyCount;
	}
	public void setCompanyCount(int companyCount) {
		this.companyCount = companyCount;
	}
	public boolean isResponseResult() {
		return responseResult;
	}
	public void setResponseResult(boolean responseResult) {
		this.responseResult = responseResult;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public GptResponseModel getGptResponse() {
		return gptResponse;
	}
	public void setGptResponse(GptResponseModel gptResponse) {
		this.gptResponse = gptResponse;
	}
}
