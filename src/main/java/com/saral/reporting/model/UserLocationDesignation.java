package com.saral.reporting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_location_designation")
public class UserLocationDesignation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_loc_desig_id")
	private Integer userLocDesigId;
	
	@Column(name="designation_id")
	private Integer designationId;
	
	@Column(name="designation_name")
	private String designationName;
	
	@Column(name="user_loc_id")
	private Integer userLocId;

	public Integer getUserLocDesigId() {
		return userLocDesigId;
	}

	public void setUserLocDesigId(Integer userLocDesigId) {
		this.userLocDesigId = userLocDesigId;
	}

	public Integer getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public Integer getUserLocId() {
		return userLocId;
	}

	public void setUserLocId(Integer userLocId) {
		this.userLocId = userLocId;
	}

	
}
