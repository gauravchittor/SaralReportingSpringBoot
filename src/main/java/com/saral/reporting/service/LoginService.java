package com.saral.reporting.service;

import java.util.List;

import com.saral.reporting.model.LoginData;


public interface LoginService   {
	
	List<LoginData> findByUserNameAndPasswd(String username , String passwd);
	}
