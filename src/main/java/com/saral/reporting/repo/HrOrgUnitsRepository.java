package com.saral.reporting.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saral.reporting.model.HrOrgUnits;

public interface HrOrgUnitsRepository extends JpaRepository<HrOrgUnits,Long>{


	List<HrOrgUnits> findByParentOrgUnitCode(Long locationId);

	List<HrOrgUnits> findByOrgUnitCode(Long locationId);

	
}
