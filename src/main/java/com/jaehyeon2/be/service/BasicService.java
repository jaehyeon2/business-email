package com.jaehyeon2.be.service;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class BasicService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected SqlSession mDbDao;
	
	@Autowired
	protected SqlSession sDbDao;
}
