package com.saral.reporting.service;

import java.util.List;

import com.saral.reporting.model.AttributeMasterDataSql;



public interface AttributeMasterDataSqlService {
	List<AttributeMasterDataSql> findByBaseServiceID(Long baseServiceId);
 }