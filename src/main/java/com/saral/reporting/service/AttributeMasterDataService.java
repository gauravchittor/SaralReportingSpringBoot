package com.saral.reporting.service;

import java.util.List;

import com.saral.reporting.model.AttributeMasterData;



public interface AttributeMasterDataService {
	List<AttributeMasterData> findByTaskid(String taskid);
 }
