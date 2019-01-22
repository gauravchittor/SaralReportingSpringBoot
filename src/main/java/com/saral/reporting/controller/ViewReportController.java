package com.saral.reporting.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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

@Transactional
@Controller
/*@SessionAttributes({ "sign_no", "user_id", "user_name", "hm", "department_level_name", "department_id",
	"designation_id", "designation_name" })*/
public class ViewReportController {
	//private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	ReportBeanService reportBeanService;
	
	@Autowired
	ApplInfoJsonService applInfoJsonService;
	
	@PersistenceContext
	private EntityManager manager;

	@RequestMapping(value = { "/fetchReportList" }, method = RequestMethod.GET)
	public String reportViewPage(ModelMap model, @RequestParam String sign_no, HttpServletRequest request) throws ServletException, IOException {
		
		List<ReportBean> listReport = reportBeanService.findBySignNo(sign_no);
		PagedListHolder pagedListHolder = new PagedListHolder(listReport);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(3);
		model.put("pagedListHolder", pagedListHolder);
		model.put("sign_no", sign_no);
		model.put("l2",listReport);			
		return "reportViewerPage";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/viewSelectedReport" }, method = RequestMethod.GET)
	public String reportSelectedReport(ModelMap model, @RequestParam String sign_no, @RequestParam String reportId, @RequestParam String service_id, HttpServletRequest request) throws ServletException, IOException, ParseException {
		
		//Fetch Repost designer data on the basis of reportID
		Long repId = Long.parseLong(reportId);
		ReportBean listReport = reportBeanService.findByReportId(repId);
		System.out.println("My Selected Column list "+listReport.getReportSelectColumnList());
		
		/*model.put("reportHeader", listReport.getReportSelectColumnList());*/
		List<ReportSelectColumn> L1 = listReport.getReportSelectColumnList();
		StringBuilder initCol = new StringBuilder();
		StringBuilder servCol = new StringBuilder();
		L1.forEach((temp1) -> {
			System.out.println(temp1.getStatus());
			if(temp1.getStatus().equals('I')){
				initCol.append(temp1.getReportSelectedColumnName());
				initCol.append(",");
			}else{
				servCol.append(temp1.getReportSelectedColumnId());
				servCol.append(",");
			}
		});
		String initColL = initCol.substring(0, initCol.length() - 1);
		String servColL = servCol.substring(0, servCol.length() - 1);
		System.out.println(initColL);
		System.out.println(servColL);
		
		//Find data from Json tables on the basis of Service ID
		Long servID = Long.parseLong(service_id);
		List<ApplInfoJson> applInfoJson = applInfoJsonService.findByServiceId(servID);
		
		//Fetch applInfoNode from List
		JSONArray applInfoNode = new JSONArray();
		JSONParser parser = new JSONParser(); 
		applInfoJson.forEach((temp) -> {
			JSONObject json = null;
			try {
				json = (JSONObject) parser.parse(temp.getApplInfo());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			applInfoNode.add(json);
		});
		System.out.println("ApplInfo Node is: " + applInfoNode);
		ObjectMapper objectMapper = Squiggly.init(new ObjectMapper(), initColL);
		String result = SquigglyUtils.stringify(objectMapper, applInfoNode);
		System.out.println(result);
		
		System.out.println("Your Application Info Json is :" + applInfoJson);
		applInfoJson.forEach(Item -> System.out.println(Item.getApplInfo()));
	
		model.put("applInfoJson", result);		
		return "showReport";
	}
	

}
