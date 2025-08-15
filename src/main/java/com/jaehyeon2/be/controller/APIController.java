package com.jaehyeon2.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaehyeon2.be.beans.enums.APIType;
import com.jaehyeon2.be.beans.param.CompanyParam;
import com.jaehyeon2.be.service.GptApiService;

@Controller
@RequestMapping("/api")
public class APIController extends BasicController{
	
	@Autowired
	private GptApiService gptApiService;
	
	@RequestMapping("/info")
	public String info(CompanyParam companyParam) throws Exception{
		
		companyParam.setAPIType(APIType.INFO);
		
		String response = gptApiService.getGPTResponse(companyParam);
		
		return response;
	}
	
	@RequestMapping("/email")
	public String email(CompanyParam companyParam) throws Exception{
		
		companyParam.setAPIType(APIType.EMAIL);
		
		String response = gptApiService.getGPTResponse(companyParam);
		
		return response;
		
	}
	

}
