package com.saral.reporting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saral.reporting.model.ApplInfoJson;
import com.saral.reporting.repo.ApplInfoJsonRepository;
import com.saral.reporting.service.ApplInfoJsonService;

@Service
public class ApplInfoJsonServiceImpl implements ApplInfoJsonService{

	@Autowired
	ApplInfoJsonRepository applInfoJsonRepository;
	
	@Override
	public List<ApplInfoJson> findByServiceId(Long serviceId) {
		
		return applInfoJsonRepository.findByServiceId(serviceId);
	}

	
}
