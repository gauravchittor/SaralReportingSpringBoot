package com.saral.reporting.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;
import com.saral.reporting.model.ApplInfoJson;
import com.saral.reporting.model.HrOrgUnits;
import com.saral.reporting.model.ReportBean;
import com.saral.reporting.model.ReportSelectColumn;
import com.saral.reporting.service.ApplInfoJsonService;
import com.saral.reporting.service.HrOrgUnitsService;
import com.saral.reporting.service.ReportBeanService;
import com.saral.reporting.utils.JsonUtils;

@Transactional
@Controller

@SessionAttributes({ "sign_no", "reportId", "service_id", "hm", "department_level_name", "department_id",
	"designation_id", "designation_name" })
public class ViewReportController {

	@Autowired
	ReportBeanService reportBeanService;

	@Autowired
	ApplInfoJsonService applInfoJsonService;

	@Autowired
	HrOrgUnitsService hrOrgUnitsService;
	
	@PersistenceContext
	private EntityManager manager;

	@RequestMapping(value = { "/fetchReportList" }, method = RequestMethod.GET)
	public String reportViewPage(ModelMap model, HttpServletRequest request)
			throws ServletException, IOException {
		String sign_no = (String) request.getSession().getAttribute("sign_no");
		Long department_id = (Long) request.getSession().getAttribute("department_id");
		
		//this is to find list on the basis of sign_no
		//List<ReportBean> listReport = reportBeanService.findBySignNo(sign_no);  
		
		//this is to find list on the basis of department_id
		List<ReportBean> listReport = reportBeanService.findByDepartmentId(department_id); 
		
		PagedListHolder<ReportBean> pagedListHolder = new PagedListHolder<ReportBean>(listReport);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(3);
		model.put("pagedListHolder", pagedListHolder);
		model.put("sign_no", sign_no);
		model.put("l2", listReport);
		return "reportViewerPage";
	}

	@RequestMapping(value = { "/viewSelectedReport" }, method = RequestMethod.GET)
	public String reportSelectedReport(ModelMap model, Pageable pageable, @RequestParam String reportId,
			@RequestParam String service_id, HttpServletRequest request)
			throws ServletException, IOException, ParseException {

		
		
		Long repId = Long.parseLong(reportId);
		Long servID = Long.parseLong(service_id);
		Long totalRecords = applInfoJsonService.countByServiceId(servID);
		
		if(totalRecords==0){
			model.put("ErrorReport", "No Record found for this Report");
			return "list";
		}
		else{
			int totalPages = (int) (totalRecords / 150);
			int resultTP = (int) (totalRecords % 150);
			if(resultTP == 0){
		        }else{
			        totalPages = totalPages + 1;
		        }
			model.put("totalPages", totalPages);
			model.put("reportId", repId);
			model.put("service_id", servID);
			return "showReportNew";
		}
	}

	
	@RequestMapping(value = { "/viewSelectedReportData" }, method = RequestMethod.GET)
	public String reportSelectedReportShow(ModelMap model, Pageable pageable, HttpServletRequest request)
			throws ServletException, IOException, ParseException {
		System.out.println();
		Long repId = (Long) request.getSession().getAttribute("reportId");
		Long servID = (Long) request.getSession().getAttribute("service_id");
		Long locationId = (Long) request.getSession().getAttribute("location_Id");
		
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

		// Find data from Json tables on the basis of Service ID
		Long totalRecords = applInfoJsonService.countByServiceId(servID);
		int totalPages = (int) (totalRecords / 150);
		int resultTP = (int) (totalRecords % 150);
		if(resultTP == 0){
	        }else{
		        totalPages = totalPages + 1;
	        }
		model.put("totalPages", totalPages);

			Page<ApplInfoJson> applInfoJson = applInfoJsonService.findByServiceId(servID, pageable);
			System.out.println(applInfoJson);

			// Fetch applInfoNode from List
			applInfoJson.forEach((temp) -> {
				// map applinfo in map
				Map<String, Object> mapInit = JsonUtils.getMapFromString(temp.getApplInfo());

				// map attributes in map
				Map<String, Object> mapAttr = JsonUtils.getMapFromString(temp.getApplicationFormAttributes());

				// merging map
				Map<String, Object> mapFromString = new LinkedHashMap<>();
				mapFromString.putAll(mapInit);
				mapFromString.putAll(mapAttr);

				listofMap.add(mapFromString);

			});

			ObjectMapper objectMapper = Squiggly.init(new ObjectMapper(), joiner.toString());
			String result = SquigglyUtils.stringify(objectMapper, listofMap);

			for (ReportSelectColumn s : L1) {

				result = result.replace(s.getReportSelectedColumnId(), s.getReportSelectedColumnName());
			}
			model.put("applInfoJson", result);
			model.put("reportId", repId);
			model.put("service_id", servID);
			System.out.println("Inside second loop where records are greater than 6000 ==== FINAL");
			
			model.addAttribute("addresses", result);
			JsonUtils.pageModel(model, applInfoJson);
			long pNumber = ((pageable.getPageNumber() -1)*150);
			long size = ((pageable.getPageNumber())*150);
			model.put("number", pNumber);
			model.put("size", size);
			System.out.println("number" + pNumber);
			System.out.println("size" + size);
			
			/*
			 * Code for fetching org_unit_code on the basis of location_id
			 *And finding the org_unit_code for child of location_id
			 */
			//uncomment this line to add both list. do it before launch
			//l1.addAll(l2);
			List<HrOrgUnits> l1 = hrOrgUnitsService.findByOrgUnitCode(locationId);
			List<HrOrgUnits> l2 = hrOrgUnitsService.findByParentOrgUnitCode(locationId);
			System.out.println("list l1" + l1);
			System.out.println("Size of l1" + l1.size());
			System.out.println("list l2" + l2);
			System.out.println("Size l2" + l2.size());
			List<Long> field1List = l1.stream().map(urEntity -> urEntity.getOrgUnitCode()).collect(Collectors.toList());
			System.out.println("Converted List is :" + field1List);
			return "showReportNew";
		
	}

}
