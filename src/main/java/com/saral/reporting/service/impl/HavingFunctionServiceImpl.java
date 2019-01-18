package com.saral.reporting.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saral.reporting.model.HavingFunctions;
import com.saral.reporting.repo.HavingFunctionsRepository;
import com.saral.reporting.service.HavingFunctionsService;

@Service
@Transactional
public class HavingFunctionServiceImpl implements HavingFunctionsService{

	@Autowired
	HavingFunctionsRepository havingFunctionsRepository; 
	@Override
	public List<HavingFunctions> findAll() {
		
		List<HavingFunctions> list = havingFunctionsRepository.findAll();
		return list;
	}
	@Override
	public List<HavingFunctions> getAllHavingFunctions() {
		// TODO Auto-generated method stub
		return (List<HavingFunctions>) havingFunctionsRepository.findAll();
	}
	@Override
	public HavingFunctions getHavingFunctionsById(long id) {
		// TODO Auto-generated method stub
		
	 return (HavingFunctions) havingFunctionsRepository.findByFuncId(id);
	}
	@Override
	public void saveOrUpdate(HavingFunctions havingFunctions) {
		// TODO Auto-generated method stub
		havingFunctionsRepository.save(havingFunctions);
	}
	@Override
	public void deleteHavingFunctions(long id) {
		// TODO Auto-generated method stub
		havingFunctionsRepository.deleteByFuncId(id);
	}
	@Override
	public HavingFunctions save(HavingFunctions havingFunctions) {
		// TODO Auto-generated method stub
		return havingFunctionsRepository.save(havingFunctions);
	}

}
