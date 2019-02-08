package com.saral.reporting.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.saral.reporting.model.ReportBean;
import com.saral.reporting.service.ReportBeanService;

@Transactional
@Controller
/*@SessionAttributes({ "sign_no", "user_id", "user_name", "hm", "department_level_name", "department_id",
		"designation_id", "designation_name" })*/
@SessionAttributes({ "sign_no" })
public class UpdateDesignController {
	
	@Autowired
	ReportBeanService reportBeanService;
	
	@RequestMapping(value = "/fetchReportsName", method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")
	public String fetchReportName(ModelMap model, HttpServletRequest request) throws ServletException, IOException {
	
		String sign_no = (String) request.getSession().getAttribute("sign_no");
		List<ReportBean> listReport = reportBeanService.findBySignNo(sign_no);
		
		PagedListHolder<ReportBean> pagedListHolder = new PagedListHolder<ReportBean>(listReport);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(3);
		model.put("pagedListHolder", pagedListHolder);
		model.put("sign_no", sign_no);
		model.put("l2",listReport);
		return "updateReportDesign";			
	}
	
	
	@RequestMapping(value = "/deleteSelectedReport", method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")
	public String deleteSelectedReport(ModelMap model, @RequestParam String reportId, HttpServletRequest request) throws ServletException, IOException {
	 
		System.out.println("Inside delete block");
		Long repId = Long.parseLong(reportId);
		System.out.println("SSSSS" + repId);
		reportBeanService.deleteReportBean(repId);
		return "redirect:/fetchReportsName";				
	}
	
}
	
