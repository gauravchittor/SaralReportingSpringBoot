package com.saral.reporting.service;

import java.util.List;

import com.saral.reporting.model.ServiceMaster;

public interface ServiceMasterService {
	
	List<ServiceMaster> findByDeptCode(String deptCode);


}
