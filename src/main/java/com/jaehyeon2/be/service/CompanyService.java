package com.jaehyeon2.be.service;

import java.util.List;

import com.jaehyeon2.be.beans.model.CompanyModel;
import com.jaehyeon2.be.beans.param.CompanyParam;

public interface CompanyService {
	
	public boolean istCompany(CompanyParam companyParam) throws Exception;
	public boolean udtCompany(CompanyParam companyParam) throws Exception;
	public boolean dltCompany(CompanyParam companyParam) throws Exception;
	
	public CompanyModel sltCompany(CompanyParam companyParam) throws Exception;
	public List<CompanyModel> sltCompanyList(CompanyParam companyParam) throws Exception;
	public int sltCompanyCount(CompanyParam companyParam) throws Exception;

}
