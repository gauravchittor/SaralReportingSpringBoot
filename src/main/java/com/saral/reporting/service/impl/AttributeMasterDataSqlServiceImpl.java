package com.saral.reporting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saral.reporting.model.AttributeMasterDataSql;
import com.saral.reporting.repo.AttributeMasterDataSqlRepository;
import com.saral.reporting.service.AttributeMasterDataSqlService;

@Service
public class AttributeMasterDataSqlServiceImpl implements AttributeMasterDataSqlService{

	@Autowired
	AttributeMasterDataSqlRepository attributeMasterDataSqlRepository;
	
	@Override
	public List<AttributeMasterDataSql> findByBaseServiceID(Long baseServiceId) {
		
		 List<AttributeMasterDataSql> list = attributeMasterDataSqlRepository.findByBaseServiceID(baseServiceId);
		return list;
		
	}
}


