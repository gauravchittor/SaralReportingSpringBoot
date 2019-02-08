
package com.saral.reporting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_master")
public class RoleMaster {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private Long roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="sign_role")
	private String signRole;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getSignRole() {
		return signRole;
	}

	public void setSignRole(String signRole) {
		this.signRole = signRole;
	}

	@Override
	public String toString() {
		return "RoleMaster [role_id=" + roleId + ", roleName=" + roleName + ", signRole=" + signRole + "]";
	}


	
	
}
