package com.saral.reporting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_assignment")
public class RoleAssignment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "roleId" , nullable = false)
	private Long roleId; // integer NOT NULL,
	@Column(name = "user_role_id",  nullable = false)
	private Long useRoleId; // bigint NOT NULL,
	@Column(name = "user_loc_id")
	private Long userLocId; // bigint,
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getUseRoleId() {
		return useRoleId;
	}
	public void setUseRoleId(Long useRoleId) {
		this.useRoleId = useRoleId;
	}
	public Long getUserLocId() {
		return userLocId;
	}
	public void setUserLocId(Long userLocId) {
		this.userLocId = userLocId;
	}
	@Override
	public String toString() {
		return "RoleAssignment [userId=" + userId + ", roleId=" + roleId + ", useRoleId=" + useRoleId + ", userLocId="
				+ userLocId + "]";
	}



}
