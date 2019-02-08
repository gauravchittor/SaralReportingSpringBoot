package com.saral.reporting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saral.reporting.model.HrOrgUnits;
import com.saral.reporting.repo.HrOrgUnitsRepository;
import com.saral.reporting.service.HrOrgUnitsService;

@Service
public class HrOrgUnitsServiceImpl implements HrOrgUnitsService{

	@Autowired
	HrOrgUnitsRepository hrOrgUnitsRepository;
	
	@Override
	public List<HrOrgUnits> findByOrgUnitCode(Long locationId) {

		return hrOrgUnitsRepository.findByOrgUnitCode(locationId);
	}

	@Override
	public List<HrOrgUnits> findByParentOrgUnitCode(Long locationId) {
		
		return hrOrgUnitsRepository.findByParentOrgUnitCode(locationId);
	}

	
}
