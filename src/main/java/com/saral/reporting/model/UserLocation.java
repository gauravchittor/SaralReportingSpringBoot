package com.saral.reporting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_location")
public class UserLocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_loc_id")
	private Integer userLocId;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="location_id")
	private Integer locationId;
	
	@Column(name="location_type_id")
	private Integer locationTypeId;
	
	@Column(name="department_id")
	private Integer departmentId;
	
	@Column(name="department_level_id")
	private Integer departmentLevelId;
	
	@Column(name="department_level_name")
	private String departmentLevelName;

	public Integer getUserLocId() {
		return userLocId;
	}

	public void setUserLocId(Integer userLocId) {
		this.userLocId = userLocId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Integer getLocationTypeId() {
		return locationTypeId;
	}

	public void setLocationTypeId(Integer locationTypeId) {
		this.locationTypeId = locationTypeId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getDepartmentLevelId() {
		return departmentLevelId;
	}

	public void setDepartmentLevelId(Integer departmentLevelId) {
		this.departmentLevelId = departmentLevelId;
	}

	public String getDepartmentLevelName() {
		return departmentLevelName;
	}

	public void setDepartmentLevelName(String departmentLevelName) {
		this.departmentLevelName = departmentLevelName;
	}
	
	
}