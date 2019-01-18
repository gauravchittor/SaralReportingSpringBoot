package com.saral.reporting.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Transactional
@Controller
/*@SessionAttributes({ "sign_no", "user_id", "user_name", "hm", "department_level_name", "department_id",
	"designation_id", "designation_name" })*/
public class ViewReportController {
	//private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@PersistenceContext
	private EntityManager manager;

	@RequestMapping(value = { "/fetchReportList" }, method = RequestMethod.GET)
	public String reportViewPage(ModelMap model) {

		return "reportViewerPage";
	}

}
