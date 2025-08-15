package com.jaehyeon2.be.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jaehyeon2.be.beans.param.CompanyParam;

@Controller
@RequestMapping(value = {"/meet"})
public class MeetController {
	
	@RequestMapping(value = {"/", "", "/index"}, method = RequestMethod.GET)
	public String index(CompanyParam companyParam) throws Exception {
		
		
		
		return "/apps/company/index";
	}

}
