package com.jaehyeon2.be.dao.master;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface MCompanyDao {
	
	public int istCompany(Map<String, Object> map) throws SQLException;
	public int udtCompany(Map<String, Object> map) throws SQLException;
	public int dltCompany(Map<String, Object> map) throws SQLException;
	
}
