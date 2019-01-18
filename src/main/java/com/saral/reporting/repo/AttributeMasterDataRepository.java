package com.saral.reporting.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saral.reporting.model.AttributeMasterData;



public interface AttributeMasterDataRepository extends JpaRepository<AttributeMasterData, Integer> {

	List<AttributeMasterData> findByTaskid(String taskid);
	
	

}
