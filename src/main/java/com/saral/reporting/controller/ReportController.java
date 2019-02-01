package com.saral.reporting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saral.reporting.model.ApplInfoJson;
import com.saral.reporting.service.ApplInfoJsonService;
import com.saral.reporting.view.ExcelViewReport;

@Controller
@RequestMapping(value="/")
public class ReportController {
	
	@Autowired
	ApplInfoJsonService applInfoJsonService;
	
	@RequestMapping(value="/reportExport", method=RequestMethod.GET)
	public ModelAndView mainListReport(HttpServletRequest res, HttpServletResponse rep){
		
		Long repId = (Long) res.getSession().getAttribute("reportId");
		Long servID = (Long) res.getSession().getAttribute("service_id");
		List<ApplInfoJson> applInfoJson = applInfoJsonService.findByServiceIdForExcel(servID);
		System.out.println("Service id and report id is:" + servID + " And " + repId );
		return new ModelAndView(new ExcelViewReport(), "applInfoJsonForExcel", applInfoJson);
		
	}
}
