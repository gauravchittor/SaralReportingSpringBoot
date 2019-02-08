package com.saral.reporting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="hr_org_units",schema="lgd",catalog="lgd")
public class HrOrgUnits {

	@Id
	@Column(name="org_unit_code")
	private Long orgUnitCode;
	
	@Column(name="org_located_level_code")
	private Long orgLocatedLevelCode;
	
	@Column(name="org_unit_name")
	private String orgUnitName;

	@Column(name="entity_lc")
	private Long entityLc;

	@Column(name="entity_type")
	private Long entityType;

	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="address3")
	private String address3;
	
	@Column(name="localaddress1")
	private String localaddress1;
	
	@Column(name="localaddress2")
	private String localaddress2;
	
	@Column(name="localaddress3")
	private String localaddress3;
	
	@Column(name="phoneno")
	private String phoneno;
	
	@Column(name="email")
	private String email;
	
	@Column(name="isactive")
	private Boolean isactive;

	@Column(name="parent_org_unit_code")
	private Long parentOrgUnitCode;
	
	@Column(name="org_spec_code")
	private String orgSpecCode;
	
	@Column(name="pin_code")
	private Long pinCode;
	
	@Column(name="level")
	private char level;
	
	@Column(name="code")
	private Long code;
	
	@Column(name="headoffice")
	private char headoffice;
	
	@Column(name="org_unit_version")
	private Long orgUnitVersion;
	
	@Column(name="org_located_level_version")
	private Long org_located_level_version;

	public Long getOrgUnitCode() {
		return orgUnitCode;
	}

	public void setOrgUnitCode(Long orgUnitCode) {
		this.orgUnitCode = orgUnitCode;
	}

	public Long getOrgLocatedLevelCode() {
		return orgLocatedLevelCode;
	}

	public void setOrgLocatedLevelCode(Long orgLocatedLevelCode) {
		this.orgLocatedLevelCode = orgLocatedLevelCode;
	}

	public String getOrgUnitName() {
		return orgUnitName;
	}

	public void setOrgUnitName(String orgUnitName) {
		this.orgUnitName = orgUnitName;
	}

	public Long getEntityLc() {
		return entityLc;
	}

	public void setEntityLc(Long entityLc) {
		this.entityLc = entityLc;
	}

	public Long getEntityType() {
		return entityType;
	}

	public void setEntityType(Long entityType) {
		this.entityType = entityType;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getLocaladdress1() {
		return localaddress1;
	}

	public void setLocaladdress1(String localaddress1) {
		this.localaddress1 = localaddress1;
	}

	public String getLocaladdress2() {
		return localaddress2;
	}

	public void setLocaladdress2(String localaddress2) {
		this.localaddress2 = localaddress2;
	}

	public String getLocaladdress3() {
		return localaddress3;
	}

	public void setLocaladdress3(String localaddress3) {
		this.localaddress3 = localaddress3;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public Long getParentOrgUnitCode() {
		return parentOrgUnitCode;
	}

	public void setParentOrgUnitCode(Long parentOrgUnitCode) {
		this.parentOrgUnitCode = parentOrgUnitCode;
	}

	public String getOrgSpecCode() {
		return orgSpecCode;
	}

	public void setOrgSpecCode(String orgSpecCode) {
		this.orgSpecCode = orgSpecCode;
	}

	public Long getPinCode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}

	public char getLevel() {
		return level;
	}

	public void setLevel(char level) {
		this.level = level;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public char getHeadoffice() {
		return headoffice;
	}

	public void setHeadoffice(char headoffice) {
		this.headoffice = headoffice;
	}

	public Long getOrgUnitVersion() {
		return orgUnitVersion;
	}

	public void setOrgUnitVersion(Long orgUnitVersion) {
		this.orgUnitVersion = orgUnitVersion;
	}

	public Long getOrg_located_level_version() {
		return org_located_level_version;
	}

	public void setOrg_located_level_version(Long org_located_level_version) {
		this.org_located_level_version = org_located_level_version;
	}

	@Override
	public String toString() {
		return "HrOrgUnits [orgUnitCode=" + orgUnitCode + ", orgLocatedLevelCode=" + orgLocatedLevelCode
				+ ", orgUnitName=" + orgUnitName + ", entityLc=" + entityLc + ", entityType=" + entityType
				+ ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + ", localaddress1="
				+ localaddress1 + ", localaddress2=" + localaddress2 + ", localaddress3=" + localaddress3 + ", phoneno="
				+ phoneno + ", email=" + email + ", isactive=" + isactive + ", parentOrgUnitCode=" + parentOrgUnitCode
				+ ", orgSpecCode=" + orgSpecCode + ", pinCode=" + pinCode + ", level=" + level + ", code=" + code
				+ ", headoffice=" + headoffice + ", orgUnitVersion=" + orgUnitVersion + ", org_located_level_version="
				+ org_located_level_version + "]";
	}
	
	
}
