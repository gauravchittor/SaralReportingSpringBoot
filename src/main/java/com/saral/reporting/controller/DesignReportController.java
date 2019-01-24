package com.saral.reporting.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.google.gson.Gson;
import com.saral.reporting.model.ApplInfo;
import com.saral.reporting.model.AttributeMasterDataSql;
import com.saral.reporting.model.HavingFunctions;
import com.saral.reporting.model.ReportBean;
import com.saral.reporting.model.ReportSelectColumn;
import com.saral.reporting.model.ServiceMaster;
import com.saral.reporting.model.WhereFunctions;
import com.saral.reporting.service.AttributeMasterDataSqlService;
import com.saral.reporting.service.HavingFunctionsService;
import com.saral.reporting.service.ReportBeanService;
import com.saral.reporting.service.ServiceMasterService;
import com.saral.reporting.service.WhereFunctionsService;

@Transactional
@Controller
/*@SessionAttributes({ "sign_no", "user_id", "user_name", "hm", "department_level_name", "department_id",
		"designation_id", "designation_name" })*/
public class DesignReportController {
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private ServiceMasterService serviceMasterService;

	@Autowired
	private AttributeMasterDataSqlService attributeMasterDataSqlService;
	
	@Autowired
	private ReportBeanService reportBeanService;
	
	@Autowired
	private WhereFunctionsService whereMasterService;

	@Autowired
	private HavingFunctionsService havingFunctionsService;
	

	
	@RequestMapping(value = { "/DesignReptPage" }, method = RequestMethod.GET)
	public String showDesignReport(ModelMap model) {

		return "designPage";
	}

	@RequestMapping(value = "/DesignReport", method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> showDesignReport(ModelMap model, @RequestParam String deptid, @RequestParam String action,
			HttpServletRequest request) throws ServletException, IOException {
		String action1 = action;

		System.out.println(action1);
		if (action.equals("fetchService")) {
			System.out.println("In side fetch service");
			List<ServiceMaster> serviceList = serviceMasterService.findByDeptCode(deptid);

			Map<String, String> mapList = new HashMap<String, String>();
			for (ServiceMaster i : serviceList)
				mapList.put(i.getServiceCode(), i.getServiceName());

			model.put("serviceList", mapList);
			String json = new Gson().toJson(mapList);
			return ResponseEntity.ok(json);
		}
		return (ResponseEntity<?>) ResponseEntity.ok();
	}

	@RequestMapping(value = "/DesignReportCol", method = { RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> showDesignReportCol(ModelMap model, @RequestParam String deptid,
			@RequestParam String action, @RequestParam Long serviceid, HttpServletRequest request)
			throws ServletException, IOException {
		String action1 = action;

		System.out.println(action1);
		if (action.equals("fetchColumns")) {
			System.out.println("In side fetch columns");
			/*List<AttributeMasterData> list = attributeMasterDataService.findByTaskid(serviceid);
			Map<String, String> mapColList = new HashMap<String, String>();
			for (AttributeMasterData i : list)
				mapColList.put(i.getAttributeId(), i.getAttributeLabel());*/
			
			List<AttributeMasterDataSql> list = attributeMasterDataSqlService.findByBaseServiceID(serviceid);
			Map<Long, String> mapColList = new HashMap<Long, String>();
			for (AttributeMasterDataSql i : list)
				mapColList.put(i.getAttributeID(), i.getAttributeLabel());

			model.put("serviceList", mapColList);
			String jsonCol = new Gson().toJson(mapColList);
			return ResponseEntity.ok(jsonCol);

		}
		return (ResponseEntity<?>) ResponseEntity.ok();
	}
	
	//To fetch ApplInfo Column Name
	@RequestMapping(value = "/fetchApplInfoCol", method = { RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> showApplInfoCol(ModelMap model, HttpServletRequest request)
			throws ServletException, IOException {
				System.out.println("In side Appl Info column List");
				ApplInfo applInfo = new ApplInfo();
				Map<String, String> listApplInfoCol =  applInfo.getColumnNames();
				System.out.println("This is fetched list ApplInfo Col:" + listApplInfoCol);
				//model.put("listApplInfoCol", listApplInfoCol);
				String jsonAppInfLst = new Gson().toJson(listApplInfoCol);
				return ResponseEntity.ok(jsonAppInfLst);
	}
	
	//To fetch where conditions from database
	@RequestMapping(value = "/fetchWhereConditions", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> showWhereConditions(ModelMap model, HttpServletRequest request)
			throws ServletException, IOException {
		
			System.out.println("In side WhereConditionList");		
			List<WhereFunctions> list = whereMasterService.findAll();
			Map<String, String> mapWhereList = new HashMap<String, String>();
			for (WhereFunctions i : list)
				mapWhereList.put(i.getFunction(), i.getExpression());
			System.out.println("This is fetched list :" + mapWhereList);
			model.put("WhereConditionList", mapWhereList);
			String jsonWhrLst = new Gson().toJson(mapWhereList);
			return ResponseEntity.ok(jsonWhrLst);
	}
	
	//To fetch Filter Having conditions from database
	@RequestMapping(value = "/fetchHavingConditions", method = { RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> showHavingConditions(ModelMap model, HttpServletRequest request)
			throws ServletException, IOException {
		
			System.out.println("In side Having Condition List");		
			List<HavingFunctions> list = havingFunctionsService.findAll();
			Map<String, String> mapHavingList = new HashMap<String, String>();
			for (HavingFunctions i : list)
				mapHavingList.put(i.getName(), i.getFormula());
			System.out.println("This is fetched list :" + mapHavingList);
			model.put("WhereConditionList", mapHavingList);
			String jsonHavLst = new Gson().toJson(mapHavingList);
			return ResponseEntity.ok(jsonHavLst);
	}
	
	


	@RequestMapping(value = { "/SaveReport" }, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> saveDesignerReport(HttpServletRequest request) throws ParseException {
		ReportBean reportBean = new ReportBean();
		String res ="";
		
		Long departmentID = Long.parseLong(request.getParameter("departmentID"));
		Long serviceID = Long.parseLong(request.getParameter("serviceID"));
		System.out.println("service ID is :" + serviceID);
		System.out.println("dep ID is :" + departmentID);

		reportBean.setReportName(request.getParameter("rpName"));
		reportBean.setTableColor(request.getParameter("rpColor"));
		reportBean.setDepartmentId(departmentID);
		reportBean.setServiceId(serviceID);
		reportBean.setUserId(request.getParameter("userID"));
		reportBean.setSignNo(request.getParameter("sign_no"));
		reportBean.setVersionNo(0L); // need to get front end
		reportBean.setDesignationId(111L); // need to get front end
		reportBean.setTooltip(request.getParameter("tooltip"));
		org.json.simple.JSONArray whrclsJSON =reportBean.jsonManipulateWhere(request.getParameter("whrclsJSON"));
		reportBean.setWhereCondition(whrclsJSON.toString());
		/* report.setGrouping(request.getParameter("rpGrpBy")); */
		String grpby = request.getParameter("grpIdName");
		if (grpby.equals("0")||(grpby==null)) {
			reportBean.setGrouping("");
		} else {
			reportBean.setGrouping(grpby);
		}

		/* report.setGrouping(request.getParameter("grpIdName")); */
		System.out.println("Group by :" + reportBean.getGrouping());
		reportBean.setBackgroundText(request.getParameter("bgtext"));
		reportBean.setFilterCls(""); // need to discuss
		org.json.simple.JSONArray hvngclsJSON =reportBean.jsonManipulateHaving(request.getParameter("hvngclsJSON"));
		reportBean.setHavingCls(hvngclsJSON.toString());
		reportBean.setTableFormat(""); // need to discuss
		// reportBean.setFooter_image_id(""); // need to discuss
		// reportBean.setFooter_image_id(""); // need to discuss
		System.out.println("Report Header is" + request.getParameter("rpHeader"));
		reportBean.setReport_header(request.getParameter("rpHeader"));
		reportBean.setReport_footer(request.getParameter("rpFooter"));

		String selectedColList = request.getParameter("selectedColList");
		System.out.println("Selected selectedColList list : " + selectedColList);
		
		if((selectedColList.isEmpty()) || selectedColList == "" || selectedColList==null){
			res = "Please select atleast one column to save report format";
			 String jsonresp  = new Gson().toJson(res);
			 System.out.println("jsonresp = "  + jsonresp );
			 return ResponseEntity.ok(jsonresp);
		}
		
		
		JSONArray jsonArrObject = new JSONArray(selectedColList);
		System.out.println("jsonob " + jsonArrObject);
		List<ReportSelectColumn> reportSelectColumnlist = new ArrayList<ReportSelectColumn>();
		int len = jsonArrObject.length();

		for (int i = 0; i < len; i++) {
			ReportSelectColumn col = new ReportSelectColumn();
			JSONObject objc = jsonArrObject.getJSONObject(i);
			if(objc.getString("Value").equals(objc.getString("key"))){
				col.setStatus('I');
			}else{
				col.setStatus('A');
			}
				
			col.setReportSelectedColumnId(objc.getString("Value"));
			col.setReportSelectedColumnName(objc.getString("key"));
			reportSelectColumnlist.add(col);
			reportBean.addReportSelectColumn(col);
			System.out.println(col);

		}
		reportBean.setReportSelectColumnList(reportSelectColumnlist);
		
		
	ReportBean bean = 	reportBeanService.save(reportBean);
	System.out.println(bean.getReportId());
	
	
	if(bean.getReportId()!=null){
		 res = "Report has been saved";
		 String jsonresp  = new Gson().toJson(res);
		 System.out.println("jsonresp = "  + jsonresp );
		 return ResponseEntity.ok(jsonresp);
	}else{
		res = "Issue occured while saving report. Please try again by filling all records";
		 String jsonresp  = new Gson().toJson(res);
		 System.out.println("jsonresp = "  + jsonresp );
		 return ResponseEntity.ok(jsonresp);
	}

	}

}