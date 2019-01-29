package com.saral.reporting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.saral.reporting.model.ApplInfoJson;
import com.saral.reporting.repo.ApplInfoJsonRepository;
import com.saral.reporting.service.ApplInfoJsonService;

@Service
public class ApplInfoJsonServiceImpl implements ApplInfoJsonService{

	@Autowired
	ApplInfoJsonRepository applInfoJsonRepository;
	
	/*@Override
	public List<ApplInfoJson> findByServiceId(Long serviceId, Pageable pageable) {
		
		return applInfoJsonRepository.findByServiceId(serviceId, pageable);
	}*/
	
	@Override
	public Page<ApplInfoJson> findByServiceId(Long serviceId, Pageable pageable) {
		
		return applInfoJsonRepository.findByServiceId(serviceId, new PageRequest(pageable.getPageNumber()-1, 150));
	}


	@Override
	public Long countByServiceId(Long serviceId) {
	// TODO Auto-generated method stub
	return applInfoJsonRepository.countByServiceId(serviceId);
	}
	
}
