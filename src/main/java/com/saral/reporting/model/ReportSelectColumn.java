package com.saral.reporting.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_report_selectedcolumn")

public class ReportSelectColumn {

	@Id
	@GeneratedValue(generator = "report_selectedcolumn_generator")
	@SequenceGenerator(name = "report_selectedcolumn_generator", sequenceName = "report_selectedcolumn_sequence", initialValue = 1)
	@Column(name = "report_selectedcolumnid")
	private Long reportSelectedcolumnid;

	@Column(name = "report_selected_column_id" ,length = 5000)

	private String reportSelectedColumnId;

	@Column(name = "report_selected_column_name", length = 5000)
	private String reportSelectedColumnName;
	
	@Column(name = "status")
	private Character status;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "report_id", insertable = true, updatable = false, nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ReportBean reportBean12;

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public ReportBean getReportBean() {
		return reportBean12;
	}

	public void setReportBean(ReportBean reportBean) {
		this.reportBean12 = reportBean;
	}

	public Long getReportSelectedcolumnid() {
		return reportSelectedcolumnid;
	}

	public void setReportSelectedcolumnid(Long reportSelectedcolumnid) {
		this.reportSelectedcolumnid = reportSelectedcolumnid;
	}

	public String getReportSelectedColumnId() {
		return reportSelectedColumnId;
	}

	public void setReportSelectedColumnId(String reportSelectedColumnId) {
		this.reportSelectedColumnId = reportSelectedColumnId;
	}

	public String getReportSelectedColumnName() {
		return reportSelectedColumnName;
	}

	public void setReportSelectedColumnName(String reportSelectedColumnName) {
		this.reportSelectedColumnName = reportSelectedColumnName;
	}

	@Override
	public String toString() {
		return "ReportSelectColumn [reportSelectedcolumnid=" + reportSelectedcolumnid + ", reportSelectedColumnId="
				+ reportSelectedColumnId + ", reportSelectedColumnName=" + reportSelectedColumnName + ", status="
				+ status + "]";
	}

}
