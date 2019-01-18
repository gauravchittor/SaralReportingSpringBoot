package com.saral.reporting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saral.reporting.model.AttributeMasterData;
import com.saral.reporting.repo.AttributeMasterDataRepository;
import com.saral.reporting.service.AttributeMasterDataService;



@Service
public class AttributeMasterDataServiceImpl implements AttributeMasterDataService {

	@Autowired
	AttributeMasterDataRepository attributeMasterDataRepository;

	@Override
	public List<AttributeMasterData> findByTaskid(String taskid) {
		
		 List<AttributeMasterData> list = attributeMasterDataRepository.findByTaskid(taskid);
		return list;
	}
	

}
