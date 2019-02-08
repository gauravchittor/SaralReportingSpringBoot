package com.saral.reporting.service;

import java.util.List;

import com.saral.reporting.model.HrOrgUnits;;

public interface HrOrgUnitsService {

	List<HrOrgUnits> findByOrgUnitCode(Long locationId); 
	
	List<HrOrgUnits> findByParentOrgUnitCode(Long locationId); 
	
}
