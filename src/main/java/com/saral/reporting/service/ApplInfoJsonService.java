package com.saral.reporting.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.saral.reporting.model.ApplInfoJson;

public interface ApplInfoJsonService {

	/*List<ApplInfoJson> findByServiceId(Long serviceId, Pageable pageable);*/
	
	Page<ApplInfoJson> findByServiceId(Long serviceId, Pageable pageable);
	
	Long countByServiceId(Long serviceId);
}
