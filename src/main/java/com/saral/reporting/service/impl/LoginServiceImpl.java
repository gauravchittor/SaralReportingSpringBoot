package com.saral.reporting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saral.reporting.model.LoginData;
import com.saral.reporting.repo.LoginRepository;
import com.saral.reporting.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService  {
	
	@Autowired
	LoginRepository repository;

	@Override
	public List<LoginData> findByUserNameAndPasswd(String username, String passwd) {
		List<LoginData> list = repository.findAll();
		return list;
	}
	
	
}
