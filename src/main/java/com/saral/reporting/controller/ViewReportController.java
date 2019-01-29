package com.saral.reporting.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;
import com.saral.reporting.model.ApplInfoJson;
import com.saral.reporting.model.ReportBean;
import com.saral.reporting.model.ReportSelectColumn;
import com.saral.reporting.service.ApplInfoJsonService;
import com.saral.reporting.service.ReportBeanService;
import com.saral.reporting.utils.JsonUtils;

@Transactional
@Controller

public class ViewReportController {

	@Autowired
	ReportBeanService reportBeanService;

	@Autowired
	ApplInfoJsonService applInfoJsonService;

	@PersistenceContext
	private EntityManager manager;

	@RequestMapping(value = { "/fetchReportList" }, method = RequestMethod.GET)
	public String reportViewPage(ModelMap model, @RequestParam String sign_no, HttpServletRequest request)
			throws ServletException, IOException {

		List<ReportBean> listReport = reportBeanService.findBySignNo(sign_no);
		PagedListHolder<ReportBean> pagedListHolder = new PagedListHolder<ReportBean>(listReport);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(3);
		model.put("pagedListHolder", pagedListHolder);
		model.put("sign_no", sign_no);
		model.put("l2", listReport);
		return "reportViewerPage";
	}

	//@RequestMapping(value = { "/viewSelectedReport" }, method = RequestMethod.GET)
	@GetMapping("/viewSelectedReport")
	public String reportSelectedReport(ModelMap model, Pageable pageable, @RequestParam String sign_no, @RequestParam String reportId,
			@RequestParam String service_id, HttpServletRequest request)
			throws ServletException, IOException, ParseException {

		List<Map<String, Object>> listofMap = new ArrayList<>();
		//JSONArray applInfoNode = new JSONArray();

		// Fetch Repost designer data on the basis of reportID
		Long repId = Long.parseLong(reportId);
		ReportBean listReport = reportBeanService.findByReportId(repId);

		/* model.put("reportHeader", listReport.getReportSelectColumnList()); */
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
		Long servID = Long.parseLong(service_id);
		Long totalRecords = applInfoJsonService.countByServiceId(servID);
		int totalPages = (int) (totalRecords / 150);
		int resultTP = (int) (totalRecords % 150);
		if(resultTP == 0){
	        }else{
		        totalPages = totalPages + 1;
	        }
		model.put("totalPages", totalPages);

		if (totalRecords <= 6000L) {
			//Sort sort = new Sort(new Sort.Order(Direction.ASC, "aid"));
			//pageable = new PageRequest(0, 6000, sort);
			Page<ApplInfoJson> applInfoJson = applInfoJsonService.findByServiceId(servID, pageable);

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
				System.out.println("Program is in first loop where records are less than 6000");
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
			model.put("service_id", servID);
			
			model.addAttribute("addresses", result);
			JsonUtils.pageModel(model, applInfoJson);
			
			return "list";
		} else {

		/*	int offsetup = 0;
			if (offset == "" || offset == "0") {
				offsetup = 0;
			} else {
				offsetup = (150 * (Integer.parseInt(offset) - 1));
			}
			int limit = 150;
			Sort sort = new Sort(new Sort.Order(Direction.ASC, "aid"));*/
			//Pageable pageable2 = new OffsetBasedPageRequest(offsetup, limit, sort);
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
			return "list";

		}
	}


}
