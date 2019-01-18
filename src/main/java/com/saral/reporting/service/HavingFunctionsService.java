package com.saral.reporting.service;

import java.util.List;

import com.saral.reporting.model.HavingFunctions;

public interface HavingFunctionsService {
	
	List<HavingFunctions> findAll();
	
	 public List<HavingFunctions> getAllHavingFunctions();
	 
	 public HavingFunctions getHavingFunctionsById(long id);
	 
	 public void saveOrUpdate(HavingFunctions havingFunctions);
	 
	 public void deleteHavingFunctions(long id);

	 HavingFunctions save(HavingFunctions havingFunctions);
}
