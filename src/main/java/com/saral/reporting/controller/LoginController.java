package com.saral.reporting.controller;

import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.saral.reporting.DAO.LoginDAO;

@Transactional
@Controller
@SessionAttributes({ "sign_no", "user_id", "user_name", "hm", "department_level_name", "department_id",
		"designation_id", "designation_name" })
public class LoginController {
	
//	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@PersistenceContext
	private EntityManager manager;


	
	@Autowired
	private LoginDAO loginDAO;

	@RequestMapping(value = { "/login", "/" }, method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {

		return "login";
	}
	
	@RequestMapping(value = { "/login", "/" }, method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String sign_no, @RequestParam String password) {
		
		
		if (sign_no.equals(null) || sign_no == "") {
			System.out.println("here123");
			model.put("nameErrorMessage", "UserName cannnot be empty");
			return "login";
		}

		else if ((password.equals(null) || password == "")) {
			System.out.println("here123");
			model.put("passwordErrorMessage", "Password cannnot be empty");
			return "login";
		}
		List<Object[]> values = loginDAO.validateUser(sign_no, password);
		loginDAO.testSelectJsonbEntity();
		if(values.isEmpty()){
			model.put("passwordErrorMessage", "Either UserName or password is incorrect");
			return "login";
		}
		
		Object[] l1 = values.get(0);

		String sign_no1 = (String) l1[0];
		Integer user_id = (Integer) l1[1];
		String user_name = (String) l1[2];
		String department_level_name = (String) l1[5];
		Integer department_id = (Integer) l1[6];
		Integer designation_id = (Integer) l1[7];
		String designation_name = (String) l1[8];
		HashMap<Integer, String> hm = new HashMap<>();

		for (Object[] result : values) {
			Integer role_id = (Integer) result[3];
			String role_name = (String) result[4];
			hm.put(role_id, role_name);
		}

		String json = new Gson().toJson(hm);

		System.out.println("ss");
		model.put("sign_no", sign_no1);
		model.put("user_id", user_id);
		model.put("user_name", user_name);
		model.put("department_level_name", department_level_name);
		model.put("department_id", department_id);
		model.put("designation_id", designation_id);
		model.put("designation_name", designation_name);
		model.put("hm", json);

		return "welcome";
	}

}