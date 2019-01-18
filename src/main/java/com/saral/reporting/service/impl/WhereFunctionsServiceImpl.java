package com.saral.reporting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saral.reporting.model.WhereFunctions;
import com.saral.reporting.repo.WhereFunctionRepository;
import com.saral.reporting.service.WhereFunctionsService;

@Service
public class WhereFunctionsServiceImpl implements WhereFunctionsService {

	@Autowired
	WhereFunctionRepository whereFunctionRepository;

	@Override
	public List<WhereFunctions> findAll() {
		List<WhereFunctions> listwherefunctions = (List<WhereFunctions>) whereFunctionRepository.findAll();
		return listwherefunctions;
	}
	
	
}
