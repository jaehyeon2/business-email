package com.jaehyeon2.be.service;

import com.jaehyeon2.be.beans.param.CompanyParam;

public interface GptApiService {
	public String getGPTResponse(CompanyParam companyParam) throws Exception;
}
