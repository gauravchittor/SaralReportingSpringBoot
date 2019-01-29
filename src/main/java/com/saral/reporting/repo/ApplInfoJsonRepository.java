package com.saral.reporting.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saral.reporting.model.ApplInfoJson;

public interface ApplInfoJsonRepository extends JpaRepository<ApplInfoJson, Long>{

	/*List<ApplInfoJson> findByServiceId(Long serviceId, Pageable pageable);*/
	
	Page<ApplInfoJson> findByServiceId(Long serviceId, Pageable pageable);
	
	Long countByServiceId(Long serviceId);
	
}
