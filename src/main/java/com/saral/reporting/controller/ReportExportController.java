package com.saral.reporting.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.simple.parser.ParseException;
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
import com.jayway.jsonpath.JsonPath;
import com.saral.reporting.model.ApplInfoJson;
import com.saral.reporting.model.HrOrgUnits;
import com.saral.reporting.model.ReportBean;
import com.saral.reporting.model.ReportSelectColumn;
import com.saral.reporting.service.ApplInfoJsonService;
import com.saral.reporting.service.HrOrgUnitsService;
import com.saral.reporting.service.ReportBeanService;
import com.saral.reporting.utils.JsonUtils;
import com.saral.reporting.utils.StringConstants;
import com.saral.reporting.view.CsvView;
import com.saral.reporting.view.ExcelViewReport;
import com.saral.reporting.view.PdfView;

@Controller
@RequestMapping(value="/")
public class ReportExportController {
	
	@Autowired
	ApplInfoJsonService applInfoJsonService;
	
	@Autowired
	ReportBeanService reportBeanService;
	
	@Autowired
	FileDownloadController fileDownloadController;
	
	@Autowired
	HrOrgUnitsService hrOrgUnitsService;
	
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
	public ModelAndView mainListReportExcel(HttpServletRequest res, HttpServletResponse rep) throws ParseException{
		
		JSONArray output = CommonFunctionForExport(res,rep);
		
		return new ModelAndView(new ExcelViewReport(), "applInfoJsonForExcel", output);
		
	}
	
	//code for export to pdf
	@RequestMapping(value="/reportExportPDF", method=RequestMethod.GET)
	public ModelAndView mainListReportPDF(HttpServletRequest res, HttpServletResponse rep) throws ParseException{
		
		JSONArray output = CommonFunctionForExport(res,rep);
		
		return new ModelAndView(new PdfView(), "applInfoJsonForPDF", output);
	}
	
	//code for export to csv
	@RequestMapping(value="/reportExportCSV", method=RequestMethod.GET)
	public ModelAndView mainListReportCSV(HttpServletRequest res, HttpServletResponse rep) throws ParseException{
		
		JSONArray output = CommonFunctionForExport(res,rep);
		
		return new ModelAndView(new CsvView(), "applInfoJsonForCSV", output);
	}
	
	
	//code for saving file to local and then send to client
	@RequestMapping(value="/reportExportLocal", method=RequestMethod.GET)
	public void mainListReportLocal(ModelMap model, HttpServletRequest res, HttpServletResponse rep) throws IOException, DocumentException, ParseException{
		
		String sign_no = (String) res.getSession().getAttribute("sign_no");
	
		JSONArray output = CommonFunctionForExport(res,rep);
		
        String file_name = sign_no + "_" + JsonUtils.FileNameDate()+".csv";
        File file=new File(StringConstants.FILE_PATH_DOWNLOAD_LOCAL + file_name);
        String csv = CDL.toString(output);
        FileUtils.writeStringToFile(file, csv);
		fileDownloadController.downloadPDFResource(res, rep, file_name);

	}
	
	public JSONArray CommonFunctionForExport( HttpServletRequest res, HttpServletResponse rep) throws ParseException{
		
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
		
		// result needs to filter based on location code
		String mapString = listofMap.toString();
		Long locationId = (Long) res.getSession().getAttribute("location_Id");
		List<Long> locationids = getLocationList(locationId);


		org.json.simple.JSONArray jsonArray = new org.json.simple.JSONArray();
		jsonArray.addAll(listofMap);

		List<Map<String, Object>>  values = new ArrayList<>();
		 locationids.forEach((temp) ->{
		 
		 System.out.println(temp); 
		 List<Map<String, Object>> author0 =
		 JsonPath.parse(jsonArray).read( "$.[?(@.location_value == "+temp+")]");
		 values.addAll(author0);
		 System.out.println("sssssssssssssssssssss"+author0);
		 
		 }) ;
		System.out.println("values of map"+ values );
		
		System.out.println("I am at 3rd level");
		ObjectMapper objectMapper = Squiggly.init(new ObjectMapper(), joiner.toString());
		String result = SquigglyUtils.stringify(objectMapper, values);
		System.out.println("I am at 4th level squiggly");
		
		String getWhere = JsonUtils.getWhereJoiner(listReport.getWhereCondition());

		System.out.println("$."+ getWhere);
//			JSONArray obj = JsonUtils.stringToJson(result);

		List<Map<String, Object>>  listofwheredata = JsonPath.parse(result).read( "$."+getWhere);
		System.out.println("my life "+ listofwheredata);
		objectMapper = Squiggly.init(new ObjectMapper(), "*");
		String result1 = SquigglyUtils.stringify(objectMapper, listofwheredata);
		
		for (ReportSelectColumn s : L1) {
			result1 = result1.replace(s.getReportSelectedColumnId(), s.getReportSelectedColumnName());
		}
		
		System.out.println("I am at 5th level updated record");
		JSONArray output;
		output = new JSONArray(result1);
		return output;
	}
	
	public List<Long> getLocationList(Long locationId) {

		/*
		* Code for fetching org_unit_code on the basis of location_id
		*And finding the org_unit_code for child of location_id
		*/
		//uncomment this line to add both list. do it before launch
		//l1.addAll(l2);
		List<HrOrgUnits> l1 = hrOrgUnitsService.findByOrgUnitCode(locationId);
		List<HrOrgUnits> l2 = hrOrgUnitsService.findByParentOrgUnitCode(locationId);
		//System.out.println("list l1" + l1);
		//System.out.println("Size of l1" + l1.size());
		//System.out.println("list l2" + l2);
		//System.out.println("Size l2" + l2.size());
		List<Long> field1List = l1.stream().map(urEntity -> urEntity.getOrgUnitCode()).collect(Collectors.toList());
		System.out.println("Converted List is :" + field1List);
		return field1List;

		}
}
