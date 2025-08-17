package com.jaehyeon2.be.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jaehyeon2.be.beans.param.CompanyParam;

@Controller
@RequestMapping("/")
public class IndexController extends BasicController {

    @RequestMapping(value = {"/index", "", "/"}, method = RequestMethod.GET)
    public String index(CompanyParam companyParam, ModelMap map) throws Exception {
    	
        return "apps/index";
    }
}
