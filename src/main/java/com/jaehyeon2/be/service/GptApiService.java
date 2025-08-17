package com.jaehyeon2.be.service;

import com.jaehyeon2.be.beans.model.GptResponseModel;
import com.jaehyeon2.be.beans.param.CompanyParam;

public interface GptApiService {
	public GptResponseModel getGPTResponse(CompanyParam companyParam) throws Exception;
}
