package com.saral.reporting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "r_app_json")

public class ApplInfoJson {

	@Id
	@Column(name = "aid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aid;

	@Column(name = "id")
	private Long id;

	@JsonProperty("appl_info")
	@Column(name = "appl_info")
	private String applInfo;


	@Column(name = "application_form_attributes")
	private String applicationFormAttributes;

	@Column(name = "enclosure_data")
	private String enclosureData;
	
	@Column(name = "service_id")
	private Long serviceId;

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApplInfo() {
		return applInfo;
	}

	public void setApplInfo(String applInfo) {
		this.applInfo = applInfo;
	}

	public String getApplicationFormAttributes() {
		return applicationFormAttributes;
	}

	public void setApplicationFormAttributes(String applicationFormAttributes) {
		this.applicationFormAttributes = applicationFormAttributes;
	}

	public String getEnclosureData() {
		return enclosureData;
	}

	public void setEnclosureData(String enclosureData) {
		this.enclosureData = enclosureData;
	}

	@Override
	public String toString() {
		return "ApplInfoJson [aid=" + aid + ", id=" + id + ", applInfo=" + applInfo + ", applicationFormAttributes="
				+ applicationFormAttributes + ", enclosureData=" + enclosureData + "]";
	}

}
