package com.saral.reporting.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "attribute_master_data")
public class AttributeMasterData {

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "spdi_service_id")
	private String spdiServiceId;
	
	@Column(name = "spdv_service_name")
	private String spdvServiceName;
	
	@Column(name = "taskid")
	private String taskid;
	
	@Column(name = "taskname")
	private String taskname;
	
	@Column(name = "templ_id")
	private String templId;
	
	@Column(name = "templ_name")
	private String templName;
	
	@Column(name = "temp_type")
	private String tempType;
	
	@Column(name = "attribute_id")
	private String attributeId;
	
	@Column(name = "attribute_label")
	private String attributeLabel;
	
	@Column(name = "attribute_input_type")
	private String attributeInputType;
	
	@Column(name = "entrytime")
	private Date entrytime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSpdiServiceId() {
		return spdiServiceId;
	}

	public void setSpdiServiceId(String spdiServiceId) {
		this.spdiServiceId = spdiServiceId;
	}

	public String getSpdvServiceName() {
		return spdvServiceName;
	}

	public void setSpdvServiceName(String spdvServiceName) {
		this.spdvServiceName = spdvServiceName;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTemplId() {
		return templId;
	}

	public void setTemplId(String templId) {
		this.templId = templId;
	}

	public String getTemplName() {
		return templName;
	}

	public void setTemplName(String templName) {
		this.templName = templName;
	}

	public String getTempType() {
		return tempType;
	}

	public void setTempType(String tempType) {
		this.tempType = tempType;
	}

	public String getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeLabel() {
		return attributeLabel;
	}

	public void setAttributeLabel(String attributeLabel) {
		this.attributeLabel = attributeLabel;
	}

	public String getAttributeInputType() {
		return attributeInputType;
	}

	public void setAttributeInputType(String attributeInputType) {
		this.attributeInputType = attributeInputType;
	}

	public Date getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(Date entrytime) {
		this.entrytime = entrytime;
	}

	@Override
	public String toString() {
		return "AttributeMasterData [id=" + id + ", spdiServiceId=" + spdiServiceId + ", spdvServiceName="
				+ spdvServiceName + ", taskid=" + taskid + ", taskname=" + taskname + ", templId=" + templId
				+ ", templName=" + templName + ", tempType=" + tempType + ", attributeId=" + attributeId
				+ ", attributeLabel=" + attributeLabel + ", attributeInputType=" + attributeInputType + ", entrytime="
				+ entrytime + "]";
	}

	

}
