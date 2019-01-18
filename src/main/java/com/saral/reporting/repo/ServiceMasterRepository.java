package com.saral.reporting.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saral.reporting.model.ServiceMaster;

public interface ServiceMasterRepository  extends JpaRepository<ServiceMaster, Integer>{
	
	List<ServiceMaster> findByDeptCode(String deptCode);

}
