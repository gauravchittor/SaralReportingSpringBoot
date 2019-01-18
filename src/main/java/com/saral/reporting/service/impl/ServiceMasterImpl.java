package com.saral.reporting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saral.reporting.model.ServiceMaster;
import com.saral.reporting.repo.ServiceMasterRepository;
import com.saral.reporting.service.ServiceMasterService;

@Service
public class ServiceMasterImpl implements ServiceMasterService{
	
	@Autowired
	ServiceMasterRepository serviceMasterRepository;

	@Override
	public List<ServiceMaster> findByDeptCode(String deptCode) {
		
		
		List<ServiceMaster> values = serviceMasterRepository.findByDeptCode("727");
		return values;
	}
	
	

}
