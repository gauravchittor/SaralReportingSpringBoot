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
	private Long userLocId;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="location_id")
	private Long locationId;
	
	@Column(name="location_type_id")
	private Long locationTypeId;
	
	@Column(name="department_id")
	private Long departmentId;
	
	@Column(name="department_level_id")
	private Long departmentLevelId;
	
	@Column(name="department_level_name")
	private String departmentLevelName;

	public Long getUserLocId() {
		return userLocId;
	}

	public void setUserLocId(Long userLocId) {
		this.userLocId = userLocId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Long getLocationTypeId() {
		return locationTypeId;
	}

	public void setLocationTypeId(Long locationTypeId) {
		this.locationTypeId = locationTypeId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getDepartmentLevelId() {
		return departmentLevelId;
	}

	public void setDepartmentLevelId(Long departmentLevelId) {
		this.departmentLevelId = departmentLevelId;
	}

	public String getDepartmentLevelName() {
		return departmentLevelName;
	}

	public void setDepartmentLevelName(String departmentLevelName) {
		this.departmentLevelName = departmentLevelName;
	}
	
	
}