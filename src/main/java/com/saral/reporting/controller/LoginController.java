package com.saral.reporting.controller;

import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

	@RequestMapping(value = {"/", "/login"})
	public String login(HttpServletRequest request, ModelMap model,@RequestParam(value = "error",required = false) String error,
			@RequestParam(value = "logout",	required = false) String logout) {
		 HttpSession session= request.getSession(false);
	        SecurityContextHolder.clearContext();
	        if(session != null) {
	            session.invalidate();
	        }
	        
	        
	        if (error != null) {
				model.put("error", "Invalid Credentials provided.");
			}

			if (logout != null) {
				model.put("message", "Logged out successfully.");
			}
		return "login";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String homePage(HttpServletRequest request,ModelMap model) {
		System.out.println(request.getAttribute("sign_no"));
		System.out.println(getPrincipal());
		String sign_no = getPrincipal();
		List<Object[]> values = loginDAO.getUserInfo(sign_no);
		loginDAO.testSelectJsonbEntity();

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

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}