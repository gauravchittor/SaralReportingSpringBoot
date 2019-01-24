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

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
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
/*
 * @SessionAttributes({ "sign_no", "user_id", "user_name", "hm",
 * "department_level_name", "department_id", "designation_id",
 * "designation_name" })
 */
public class ViewReportController {
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(LoginController.class);

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

	@RequestMapping(value = { "/viewSelectedReport" }, method = RequestMethod.GET)
	public String reportSelectedReport(ModelMap model, @RequestParam String sign_no, @RequestParam String reportId,
			@RequestParam String service_id, HttpServletRequest request)
			throws ServletException, IOException, ParseException {

		List<Map<String, Object>> listofMap = new ArrayList<>();
		JSONArray applInfoNode = new JSONArray();

		// Fetch Repost designer data on the basis of reportID
		Long repId = Long.parseLong(reportId);
		ReportBean listReport = reportBeanService.findByReportId(repId);
		System.out.println("My Selected Column list " + listReport.getReportSelectColumnList());

		/* model.put("reportHeader", listReport.getReportSelectColumnList()); */
		List<ReportSelectColumn> L1 = listReport.getReportSelectColumnList();
		StringBuilder initCol = new StringBuilder();
		StringBuilder servCol = new StringBuilder();
		L1.forEach((temp1) -> {
			System.out.println(temp1.getStatus());
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
		System.out.println(initColL);
		System.out.println(servColL);
		StringJoiner joiner = new StringJoiner(",");
		joiner.add(initColL).add(servColL);
		// Find data from Json tables on the basis of Service ID
		Long servID = Long.parseLong(service_id);
		List<ApplInfoJson> applInfoJson = applInfoJsonService.findByServiceId(servID);

		// Fetch applInfoNode from List

		applInfoJson.forEach((temp) -> {
			// map applinfo in map
			Map<String, Object> mapInit = JsonUtils.getMapFromString(temp.getApplInfo());
			System.out.println("My mapObjectinit is: " + mapInit);

			// map attributes in map
			Map<String, Object> mapAttr = JsonUtils.getMapFromString(temp.getApplicationFormAttributes());
			System.out.println("My mapObjectAttr is: " + mapAttr);

			// merging map
			Map<String, Object> mapFromString = new LinkedHashMap<>();
			mapFromString.putAll(mapInit);
			mapFromString.putAll(mapAttr);

			System.out.println("my merged map is :" + mapFromString);

			listofMap.add(mapFromString);

		});
		System.out.println("ApplInfo Node is: " + applInfoNode);

		ObjectMapper objectMapper = Squiggly.init(new ObjectMapper(), joiner.toString());
		String result = SquigglyUtils.stringify(objectMapper, listofMap);
		System.out.println(result);

		for (ReportSelectColumn s : L1) {

			result = result.replace(s.getReportSelectedColumnId(), s.getReportSelectedColumnName());
			}
		model.put("applInfoJson", result);
		return "showReport";
	}

}
