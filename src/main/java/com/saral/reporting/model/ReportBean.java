package com.saral.reporting.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Entity
@Table(name = "tbl_reportdesigner")
public class ReportBean {
	@Id
	@GeneratedValue(generator = "reportdesigner_generator")
	@SequenceGenerator(name = "reportdesigner_generator", sequenceName = "reportdesigner_sequence", initialValue = 1)
	@Column(name = "report_id")
	private Long reportId;

	@Column(name = "service_id")
	private Long serviceId;

	@Column(name = "department_id")
	private Long departmentId;

	@Column(name = "version_no")
	private Long versionNo;

	@Column(name = "filter_cls")
	private String filterCls;

	@Column(name = "having_cls")
	private String havingCls;

	@Column(name = "background")
	private String backgroundText;

	@Column(name = "table_format")
	private String tableFormat;

	@Column(name = "table_color")
	private String tableColor;

	@Column(name = "tooltip")
	private String tooltip;
	@Column(name = "report_header")
	private String report_header;

	@Column(name = "report_footer")
	private String report_footer;

	/*
	 * @Column(name = "header_image_id") private String headerImageId;
	 * 
	 * @Column(name = "footer_image_id") private String footerImageId;
	 */

	@Column(name = "user_id")
	private String userId;

	@Column(name = "designation_id")
	private Long designationId;

	@Column(name = "grouping_cls")
	private String grouping;

	@Column(name = "where_condition")
	private String whereCondition;

	@Column(name = "sub_query")
	private String subQuery;

	@Column(name = "final_query")
	private String finalQuery;

	@Column(name = "report_name")
	private String reportName;
	/* private String report_id; */

	@Column(name = "sign_no")
	private String signNo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "reportBean12")
	private List<ReportSelectColumn> reportSelectColumnList;

	public String getSignNo() {
		return signNo;
	}

	public void setSignNo(String signNo) {
		this.signNo = signNo;
	}

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public List<ReportSelectColumn> getReportSelectColumnList() {
		return reportSelectColumnList;
	}

	public void setReportSelectColumnList(List<ReportSelectColumn> reportSelectColumnList) {

		this.reportSelectColumnList = reportSelectColumnList;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Long versionNo) {
		this.versionNo = versionNo;
	}

	public String getFilterCls() {
		return filterCls;
	}

	public void setFilterCls(String filterCls) {
		this.filterCls = filterCls;
	}

	public String getHavingCls() {
		return havingCls;
	}

	public void setHavingCls(String havingCls) {
		this.havingCls = havingCls;
	}

	public String getBackgroundText() {
		return backgroundText;
	}

	public void setBackgroundText(String backgroundText) {
		this.backgroundText = backgroundText;
	}

	public String getTableFormat() {
		return tableFormat;
	}

	public void setTableFormat(String tableFormat) {
		this.tableFormat = tableFormat;
	}

	public String getTableColor() {
		return tableColor;
	}

	public void setTableColor(String tableColor) {
		this.tableColor = tableColor;
	}

	public String getTooltip() {
		return tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public String getReport_header() {
		return report_header;
	}

	public void setReport_header(String report_header) {
		this.report_header = report_header;
	}

	public String getReport_footer() {
		return report_footer;
	}

	public void setReport_footer(String report_footer) {
		this.report_footer = report_footer;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public String getGrouping() {
		return grouping;
	}

	public void setGrouping(String grouping) {
		this.grouping = grouping;
	}

	public String getWhereCondition() {
		return whereCondition;
	}

	public void setWhereCondition(String whereCondition) {
		this.whereCondition = whereCondition;
	}

	public String getSubQuery() {
		return subQuery;
	}

	public void setSubQuery(String subQuery) {
		this.subQuery = subQuery;
	}

	public String getFinalQuery() {
		return finalQuery;
	}

	public void setFinalQuery(String finalQuery) {
		this.finalQuery = finalQuery;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	@Override
	public String toString() {
		return "ReportBean [reportId=" + reportId + ", serviceId=" + serviceId + ", departmentId=" + departmentId
				+ ", versionNo=" + versionNo + ", filterCls=" + filterCls + ", havingCls=" + havingCls
				+ ", backgroundText=" + backgroundText + ", tableFormat=" + tableFormat + ", tableColor=" + tableColor
				+ ", tooltip=" + tooltip + ", report_header=" + report_header + ", report_footer=" + report_footer
				+ ", userId=" + userId + ", designationId=" + designationId + ", grouping=" + grouping
				+ ", whereCondition=" + whereCondition + ", subQuery=" + subQuery + ", finalQuery=" + finalQuery
				+ ", reportName=" + reportName + ", signNo=" + signNo + ", reportSelectColumnList="
				+ reportSelectColumnList + "]";
	}

	public void addReportSelectColumn(ReportSelectColumn reportSelectColumn) {
		if (reportSelectColumn != null) {
			if (reportSelectColumnList == null) {
				reportSelectColumnList = new ArrayList<ReportSelectColumn>();
			}
			reportSelectColumnList.add(reportSelectColumn);
			reportSelectColumn.setReportBean(this);
		}
	}

	@SuppressWarnings("unchecked")
	public JSONArray jsonManipulateHaving(String result) throws ParseException {
		JSONParser parser12 = new JSONParser();
		JSONObject json = (JSONObject) parser12.parse(result);

		System.out.println(json);

		JSONArray objarray = (JSONArray) json.get("Having");

		System.out.println(objarray);
		final JSONArray jsonArray = new JSONArray();
		for (Object j : objarray) {
			JSONObject mainObj = new JSONObject();
			JSONObject info_json = (JSONObject) j;
			mainObj.put(info_json.get("ColumnId"), info_json.get("Column"));
			mainObj.put(info_json.get("Value"), info_json.get("Condition"));

			System.out.println(j);
			jsonArray.add(mainObj);
		}
		System.out.println(jsonArray);

		return jsonArray;

	}

	@SuppressWarnings("unchecked")
	public JSONArray jsonManipulateWhere(String result) throws ParseException {
		JSONParser parser12 = new JSONParser();
		JSONObject json = (JSONObject) parser12.parse(result);

		System.out.println(json);

		JSONArray objarray = (JSONArray) json.get("Where");

		System.out.println(objarray);
		final JSONArray jsonArray = new JSONArray();
		for (Object j : objarray) {
			JSONObject mainObj = new JSONObject();
			JSONObject info_json = (JSONObject) j;
			mainObj.put(info_json.get("ColumnId"), info_json.get("Column"));
			mainObj.put(info_json.get("Value"), info_json.get("Condition"));

			System.out.println(j);
			jsonArray.add(mainObj);
		}
		System.out.println(jsonArray);

		return jsonArray;

	}

}