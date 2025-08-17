package com.jaehyeon2.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaehyeon2.be.beans.enums.APIType;
import com.jaehyeon2.be.beans.model.BeModel;
import com.jaehyeon2.be.beans.model.GptResponseModel;
import com.jaehyeon2.be.beans.param.CompanyParam;
import com.jaehyeon2.be.service.GptApiService;

@Controller
@RequestMapping("/api")
public class APIController extends BasicController{
	
	@Autowired
	private GptApiService gptApiService;
	
	@PostMapping(value = {"/info"})
	public @ResponseBody BeModel info(@RequestBody CompanyParam companyParam) throws Exception{
		
		BeModel model = new BeModel();
		
		logger.info("info, companyName = {}", companyParam.getCompanyName());
		
		companyParam.setAPIType(APIType.INFO);
		
		GptResponseModel gptResponse = gptApiService.getGPTResponse(companyParam);
		
		model.setGptResponse(gptResponse);
		
		return model;
	}
	
	@RequestMapping("/email")
	public @ResponseBody BeModel email(@RequestBody CompanyParam companyParam) throws Exception{
		
		BeModel model = new BeModel();
		
		companyParam.setAPIType(APIType.EMAIL);
		
		GptResponseModel gptResponse = gptApiService.getGPTResponse(companyParam);
		
		model.setGptResponse(gptResponse);
		
		return model;
		
	}
	

}
