package com.jaehyeon2.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaehyeon2.be.beans.model.BeModel;
import com.jaehyeon2.be.beans.model.CompanyModel;
import com.jaehyeon2.be.beans.param.CompanyParam;
import com.jaehyeon2.be.service.CompanyService;

@Controller
@RequestMapping("/be/company")
public class CompanyController extends BasicController {

    @Autowired
    private CompanyService companyService;

    // 단건 조회
    @RequestMapping(value = {"/detail"}, method = RequestMethod.GET)
    public String detail(CompanyParam companyParam, ModelMap map) throws Exception {
    	
    	BeModel model = new BeModel();
    	
    	CompanyModel company = companyService.sltCompany(companyParam);
    	
    	model.setCompany(company);
    	
    	map.addAttribute(MODEL, model);
    	
        return "apps/company/detail";
    }

    // 목록 조회
    @RequestMapping(value = {"/index", "", "/"}, method = RequestMethod.GET)
    public String index(CompanyParam companyParam, ModelMap map) throws Exception {
    	
    	BeModel model = new BeModel();
    	
    	List<CompanyModel> companyList = companyService.sltCompanyList(companyParam);
    	
    	logger.info("companyList.size() = {}", companyList.size());
    	
    	model.setCompanyList(companyList);
    	
    	map.addAttribute(MODEL, model);
    	
        return "apps/company/index";
    }

    // 등록
    @PostMapping(value = {"/addCompany"})
    public @ResponseBody BeModel addCompany(@RequestBody CompanyParam companyParam, ModelMap map) throws Exception {
        
    	BeModel model = new BeModel();
    	
    	boolean responseResult = companyService.istCompany(companyParam);
    	
    	model.setResponseResult(responseResult);
    	
    	return model;
    }

    // 수정
    @RequestMapping("/updateCompany")
    public @ResponseBody BeModel updateCompany(@RequestBody CompanyParam companyParam, ModelMap map) throws Exception {
    	BeModel model = new BeModel();
    	
    	boolean responseResult = companyService.udtCompany(companyParam);
    	
    	model.setResponseResult(responseResult);
    	
    	return model;
    }

    // 삭제
    @RequestMapping("/deleteCompany")
    public @ResponseBody BeModel deleteCompany(@RequestBody CompanyParam companyParam, ModelMap map) throws Exception {
    	BeModel model = new BeModel();
    	
    	boolean responseResult = companyService.dltCompany(companyParam);
    	
    	model.setResponseResult(responseResult);
    	
    	return model;
    }
}
