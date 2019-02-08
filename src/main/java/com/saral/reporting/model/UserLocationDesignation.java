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
	private Long userLocDesigId;
	
	@Column(name="designation_id")
	private Long designationId;
	
	@Column(name="designation_name")
	private String designationName;
	
	@Column(name="user_loc_id")
	private Long userLocId;

	public Long getUserLocDesigId() {
		return userLocDesigId;
	}

	public void setUserLocDesigId(Long userLocDesigId) {
		this.userLocDesigId = userLocDesigId;
	}

	public Long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public Long getUserLocId() {
		return userLocId;
	}

	public void setUserLocId(Long userLocId) {
		this.userLocId = userLocId;
	}

	
}
