package com.jaehyeon2.be.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected String MODEL = "model";

}