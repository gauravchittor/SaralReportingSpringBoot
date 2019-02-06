package com.saral.reporting.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;
import com.itextpdf.text.DocumentException;
import com.saral.reporting.model.ApplInfoJson;
import com.saral.reporting.model.ReportBean;
import com.saral.reporting.model.ReportSelectColumn;
import com.saral.reporting.service.ApplInfoJsonService;
import com.saral.reporting.service.ReportBeanService;
import com.saral.reporting.utils.JsonUtils;
import com.saral.reporting.utils.StringConstants;
import com.saral.reporting.view.CsvView;
import com.saral.reporting.view.ExcelViewReport;
import com.saral.reporting.view.PdfView;

@Controller
@RequestMapping(value="/")
public class ReportController {
	
	@Autowired
	ApplInfoJsonService applInfoJsonService;
	
	@Autowired
	ReportBeanService reportBeanService;
	
	@Autowired
	FileDownloadController fileDownloadController;
	
/*	Code to export complete table
 * 
 * @RequestMapping(value="/reportExport", method=RequestMethod.GET)
	public ModelAndView mainListReport(HttpServletRequest res, HttpServletResponse rep){
		
		Long repId = (Long) res.getSession().getAttribute("reportId");
		Long servID = (Long) res.getSession().getAttribute("service_id");
		List<ApplInfoJson> applInfoJson = applInfoJsonService.findByServiceIdForExcel(servID);
		System.out.println("Service id and report id is:" + servID + " And " + repId );
		return new ModelAndView(new ExcelViewReport(), "applInfoJsonForExcel", applInfoJson);
		
	}*/
	
	
	//code for export to excel
	@RequestMapping(value="/reportExport", method=RequestMethod.GET)
	public ModelAndView mainListReportExcel(HttpServletRequest res, HttpServletResponse rep){
		
		Long repId = (Long) res.getSession().getAttribute("reportId");
		Long servID = (Long) res.getSession().getAttribute("service_id");
		List<ApplInfoJson> applInfoJson = applInfoJsonService.findByServiceIdForExcel(servID);
		List<Map<String, Object>> listofMap = new ArrayList<>();
		ReportBean listReport = reportBeanService.findByReportId(repId);
		List<ReportSelectColumn> L1 = listReport.getReportSelectColumnList();
		StringBuilder initCol = new StringBuilder();
		StringBuilder servCol = new StringBuilder();
		
		L1.forEach((temp1) -> {
			if (temp1.getStatus().equals('I')) {
				initCol.append(temp1.getReportSelectedColumnName());
				initCol.append(",");
			} else {
				servCol.append(temp1.getReportSelectedColumnId());
				servCol.append(",");
			}
		});
		
		String initColL = initCol.substring(0, initCol.length() - 1);
		String servColL = servCol.substring(0, servCol.length() - 1);
		StringJoiner joiner = new StringJoiner(",");
		joiner.add(initColL).add(servColL);
		
		System.out.println("I am at 2nd asdasdsd level");
		
		for(ApplInfoJson temp : applInfoJson){
			Map<String, Object> mapInit = JsonUtils.getMapFromString(temp.getApplInfo());
			// map attributes in map
			Map<String, Object> mapAttr = JsonUtils.getMapFromString(temp.getApplicationFormAttributes());
			// merging map
			Map<String, Object> mapFromString = new LinkedHashMap<>();
			mapFromString.putAll(mapInit);
			mapFromString.putAll(mapAttr);
			listofMap.add(mapFromString);
		}
		
		System.out.println("I am at 3rd level");
		ObjectMapper objectMapper = Squiggly.init(new ObjectMapper(), joiner.toString());
		String result = SquigglyUtils.stringify(objectMapper, listofMap);
		System.out.println("I am at 4th level squiggly");
		
		for (ReportSelectColumn s : L1) {
			result = result.replace(s.getReportSelectedColumnId(), s.getReportSelectedColumnName());
		}
		
		System.out.println("I am at 5th level updated record");
		JSONArray output;
		output = new JSONArray(result);
        System.out.println("sdfksbf");
		
		return new ModelAndView(new ExcelViewReport(), "applInfoJsonForExcel", output);
		
	}
	
	//code for export to pdf
	@RequestMapping(value="/reportExportPDF", method=RequestMethod.GET)
	public ModelAndView mainListReportPDF(HttpServletRequest res, HttpServletResponse rep){
		
		Long repId = (Long) res.getSession().getAttribute("reportId");
		Long servID = (Long) res.getSession().getAttribute("service_id");
		List<ApplInfoJson> applInfoJson = applInfoJsonService.findByServiceIdForExcel(servID);
		List<Map<String, Object>> listofMap = new ArrayList<>();
		ReportBean listReport = reportBeanService.findByReportId(repId);
		List<ReportSelectColumn> L1 = listReport.getReportSelectColumnList();
		StringBuilder initCol = new StringBuilder();
		StringBuilder servCol = new StringBuilder();
		
		L1.forEach((temp1) -> {
			if (temp1.getStatus().equals('I')) {
				initCol.append(temp1.getReportSelectedColumnName());
				initCol.append(",");
			} else {
				servCol.append(temp1.getReportSelectedColumnId());
				servCol.append(",");
			}
		});
		
		String initColL = initCol.substring(0, initCol.length() - 1);
		String servColL = servCol.substring(0, servCol.length() - 1);
		StringJoiner joiner = new StringJoiner(",");
		joiner.add(initColL).add(servColL);
		
		System.out.println("I am at 2nd asdasdsd level");
		
		for(ApplInfoJson temp : applInfoJson){
			Map<String, Object> mapInit = JsonUtils.getMapFromString(temp.getApplInfo());
			// map attributes in map
			Map<String, Object> mapAttr = JsonUtils.getMapFromString(temp.getApplicationFormAttributes());
			// merging map
			Map<String, Object> mapFromString = new LinkedHashMap<>();
			mapFromString.putAll(mapInit);
			mapFromString.putAll(mapAttr);
			listofMap.add(mapFromString);
		}
		
		System.out.println("I am at 3rd level");
		ObjectMapper objectMapper = Squiggly.init(new ObjectMapper(), joiner.toString());
		String result = SquigglyUtils.stringify(objectMapper, listofMap);
		System.out.println("I am at 4th level squiggly");
		
		for (ReportSelectColumn s : L1) {
			result = result.replace(s.getReportSelectedColumnId(), s.getReportSelectedColumnName());
		}
		
		System.out.println("I am at 5th level updated record");
		JSONArray output;
		output = new JSONArray(result);
        System.out.println("sdfksbf");
		
		return new ModelAndView(new PdfView(), "applInfoJsonForPDF", output);
	}
	
	//code for export to csv
	@RequestMapping(value="/reportExportCSV", method=RequestMethod.GET)
	public ModelAndView mainListReportCSV(HttpServletRequest res, HttpServletResponse rep){
		
		Long repId = (Long) res.getSession().getAttribute("reportId");
		Long servID = (Long) res.getSession().getAttribute("service_id");
		List<ApplInfoJson> applInfoJson = applInfoJsonService.findByServiceIdForExcel(servID);
		List<Map<String, Object>> listofMap = new ArrayList<>();
		ReportBean listReport = reportBeanService.findByReportId(repId);
		List<ReportSelectColumn> L1 = listReport.getReportSelectColumnList();
		StringBuilder initCol = new StringBuilder();
		StringBuilder servCol = new StringBuilder();
		
		L1.forEach((temp1) -> {
			if (temp1.getStatus().equals('I')) {
				initCol.append(temp1.getReportSelectedColumnName());
				initCol.append(",");
			} else {
				servCol.append(temp1.getReportSelectedColumnId());
				servCol.append(",");
			}
		});
		
		String initColL = initCol.substring(0, initCol.length() - 1);
		String servColL = servCol.substring(0, servCol.length() - 1);
		StringJoiner joiner = new StringJoiner(",");
		joiner.add(initColL).add(servColL);
		
		System.out.println("I am at 2nd asdasdsd level");
		
		for(ApplInfoJson temp : applInfoJson){
			Map<String, Object> mapInit = JsonUtils.getMapFromString(temp.getApplInfo());
			// map attributes in map
			Map<String, Object> mapAttr = JsonUtils.getMapFromString(temp.getApplicationFormAttributes());
			// merging map
			Map<String, Object> mapFromString = new LinkedHashMap<>();
			mapFromString.putAll(mapInit);
			mapFromString.putAll(mapAttr);
			listofMap.add(mapFromString);
		}
		
		System.out.println("I am at 3rd level");
		ObjectMapper objectMapper = Squiggly.init(new ObjectMapper(), joiner.toString());
		String result = SquigglyUtils.stringify(objectMapper, listofMap);
		System.out.println("I am at 4th level squiggly");
		
		for (ReportSelectColumn s : L1) {
			result = result.replace(s.getReportSelectedColumnId(), s.getReportSelectedColumnName());
		}
		
		System.out.println("I am at 5th level updated record");
		JSONArray output;
		output = new JSONArray(result);
        System.out.println("sdfksbf");
		
		return new ModelAndView(new CsvView(), "applInfoJsonForCSV", output);
	}
	
	
	//code for saving file to local and then send to client
	@RequestMapping(value="/reportExportLocal", method=RequestMethod.GET)
	public void mainListReportLocal(ModelMap model, HttpServletRequest res, HttpServletResponse rep) throws IOException, DocumentException{
		
		Long repId = (Long) res.getSession().getAttribute("reportId");
		Long servID = (Long) res.getSession().getAttribute("service_id");
		String sign_no = (String) res.getSession().getAttribute("sign_no");
		List<ApplInfoJson> applInfoJson = applInfoJsonService.findByServiceIdForExcel(servID);
		System.out.println("Service id and report id is:" + servID + " And " + repId );
		//return new ModelAndView(new ExcelViewReport(), "applInfoJsonForExcel", applInfoJson);
		
		List<Map<String, Object>> listofMap = new ArrayList<>();
		
		ReportBean listReport = reportBeanService.findByReportId(repId);

		List<ReportSelectColumn> L1 = listReport.getReportSelectColumnList();
		StringBuilder initCol = new StringBuilder();
		StringBuilder servCol = new StringBuilder();
		L1.forEach((temp1) -> {

			if (temp1.getStatus().equals('I')) {
				initCol.append(temp1.getReportSelectedColumnName());
				initCol.append(",");
			} else {
				servCol.append(temp1.getReportSelectedColumnId());
				servCol.append(",");
			}
		});
		String initColL = initCol.substring(0, initCol.length() - 1);
		String servColL = servCol.substring(0, servCol.length() - 1);

		StringJoiner joiner = new StringJoiner(",");
		joiner.add(initColL).add(servColL);
		//System.out.println("I am at 1st level" + applInfoJson);

		System.out.println("I am at 2nd asdasdsd level");
		for(ApplInfoJson temp : applInfoJson){
			
			Map<String, Object> mapInit = JsonUtils.getMapFromString(temp.getApplInfo());
			
			// map attributes in map
			Map<String, Object> mapAttr = JsonUtils.getMapFromString(temp.getApplicationFormAttributes());

			// merging map
			Map<String, Object> mapFromString = new LinkedHashMap<>();
			mapFromString.putAll(mapInit);
			mapFromString.putAll(mapAttr);

			listofMap.add(mapFromString);
			
			
		}
		System.out.println("I am at 3rd level");
		ObjectMapper objectMapper = Squiggly.init(new ObjectMapper(), joiner.toString());
		String result = SquigglyUtils.stringify(objectMapper, listofMap);

		System.out.println("I am at 4th level squiggly");
		
		for (ReportSelectColumn s : L1) {

			result = result.replace(s.getReportSelectedColumnId(), s.getReportSelectedColumnName());
		}
		
		System.out.println("I am at 5th level updated record");
		
		JSONArray output;
		output = new JSONArray(result);
		
        System.out.println("sdfksbf");
        String file_name = sign_no + "_" + JsonUtils.FileNameDate()+".csv";
        File file=new File(StringConstants.FILE_PATH_DOWNLOAD_LOCAL + file_name);
        System.out.println("jasvdjvsdkv");
        String csv = CDL.toString(output);
        FileUtils.writeStringToFile(file, csv);

		System.out.println("Inside second loop where records are greater than 6000 ==== FINAL");
		
		fileDownloadController.downloadPDFResource(res, rep, file_name);

	}
}
