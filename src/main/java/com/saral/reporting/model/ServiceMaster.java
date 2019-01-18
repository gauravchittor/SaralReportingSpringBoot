package com.saral.reporting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="service_master")
public class ServiceMaster {
	
	
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name="dept_code")
	private String deptCode;
	
	@Column(name="service_code")
	private String serviceCode;
	
	@Column(name="service_name")
	private String serviceName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	
	
	@Override
	public String toString() {
		return "ServiceMaster [id=" + id + ", deptCode=" + deptCode + ", serviceCode=" + serviceCode + ", serviceName="
				+ serviceName + "]";
	}

}
