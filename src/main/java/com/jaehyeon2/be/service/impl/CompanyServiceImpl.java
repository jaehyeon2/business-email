package com.jaehyeon2.be.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jaehyeon2.be.beans.model.CompanyModel;
import com.jaehyeon2.be.beans.param.CompanyParam;
import com.jaehyeon2.be.dao.master.MCompanyDao;
import com.jaehyeon2.be.dao.slave.SCompanyDao;
import com.jaehyeon2.be.service.BasicService;
import com.jaehyeon2.be.service.CompanyService;

@Repository
public class CompanyServiceImpl extends BasicService implements CompanyService {

	@Override
	public boolean istCompany(CompanyParam companyParam) throws Exception {
		int intResult = 0;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("companyName", companyParam.getCompanyName());
			map.put("companyInfo", companyParam.getCompanyInfo());
			map.put("companyMeet", companyParam.getCompanyMeet());
			map.put("companyEmailContent", companyParam.getCompanyEmailContent());
			map.put("companyStatus", companyParam.getCompanyStatus());

			intResult = mDbDao.getMapper(MCompanyDao.class).istCompany(map);

			if (intResult < 1) {
				logger.error("CompanyServiceImpl::istCompany::insert fail. "
						+ "companyName={}", companyParam.getCompanyName());
				return false;
			}
		} catch (Exception e) {
			logger.error("CompanyServiceImpl::istCompany::Exception", e);
			throw e;
		}
		return true;
	}

	@Override
	public boolean udtCompany(CompanyParam companyParam) throws Exception {
		int intResult = 0;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("companyNo", companyParam.getCompanyNo());
			map.put("companyName", companyParam.getCompanyName());
			map.put("companyInfo", companyParam.getCompanyInfo());
			map.put("companyMeet", companyParam.getCompanyMeet());
			map.put("companyEmailContent", companyParam.getCompanyEmailContent());
			map.put("companyStatus", companyParam.getCompanyStatus());

			intResult = mDbDao.getMapper(MCompanyDao.class).udtCompany(map);

			if (intResult < 1) {
				logger.error("CompanyServiceImpl::udtCompany::update fail. "
						+ "companyNo={}", companyParam.getCompanyNo());
				return false;
			}
		} catch (Exception e) {
			logger.error("CompanyServiceImpl::udtCompany::Exception", e);
			throw e;
		}
		return true;
	}

	@Override
	public boolean dltCompany(CompanyParam companyParam) throws Exception {
		int intResult = 0;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("companyNo", companyParam.getCompanyNo());

			intResult = mDbDao.getMapper(MCompanyDao.class).dltCompany(map);

			if (intResult < 1) {
				logger.error("CompanyServiceImpl::dltCompany::delete fail. "
						+ "companyNo={}", companyParam.getCompanyNo());
				return false;
			}
		} catch (Exception e) {
			logger.error("CompanyServiceImpl::dltCompany::Exception", e);
			throw e;
		}
		return true;
	}

	@Override
	public CompanyModel sltCompany(CompanyParam companyParam) throws Exception {
		CompanyModel company = null;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("companyNo", companyParam.getCompanyNo());

			company = sDbDao.getMapper(SCompanyDao.class).sltCompany(map);

			if (company == null) {
				logger.warn("CompanyServiceImpl::sltCompany::company not exist. "
						+ "companyNo={}", companyParam.getCompanyNo());
			}
		} catch (Exception e) {
			logger.error("CompanyServiceImpl::sltCompany::Exception", e);
			throw e;
		}
		return company;
	}

	@Override
	public List<CompanyModel> sltCompanyList(CompanyParam companyParam) throws Exception {
		List<CompanyModel> companyList = null;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("companyName", companyParam.getCompanyName());

			companyList = sDbDao.getMapper(SCompanyDao.class).sltCompanyList(map);
			
			if (companyList == null || companyList.isEmpty()) {
				logger.warn("CompanyServiceImpl::sltCopmanyList::company list not exist. "
						+ "companyName = {}", companyParam.getCompanyName());
			}
			
		} catch (Exception e) {
			logger.error("CompanyServiceImpl::sltCompanyList::Exception", e);
			throw e;
		}
		return companyList;
	}

	@Override
	public int sltCompanyCount(CompanyParam companyParam) throws Exception {
		int intResult = 0;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("companyName", companyParam.getCompanyName());

			intResult = sDbDao.getMapper(SCompanyDao.class).sltCompanyCount(map);
		} catch (Exception e) {
			logger.error("CompanyServiceImpl::sltCompanyCount::Exception", e);
			throw e;
		}
		return intResult;
	}
}
