package com.saral.reporting.model;

public class DesignReport {
	
	private String deptId; 
	private String action;
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@Override
	public String toString() {
		return "DesignReport [deptId=" + deptId + ", action=" + action + "]";
	}
	public DesignReport(String deptId, String action) {
		super();
		this.deptId = deptId;
		this.action = action;
	}
	public DesignReport() {
		super();
	}

	
	
}
