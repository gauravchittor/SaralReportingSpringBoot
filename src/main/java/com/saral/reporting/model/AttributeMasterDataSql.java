package com.saral.reporting.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "attribute_master_data_sql")
public class AttributeMasterDataSql {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "p_id")
	private Long pId;
	
	@Column(name = "base_service_id")
	private Long baseServiceID;
	
	@Column(name="service_name",length = 5100)
	private String serviceName;
	
	@Column(name="service_id")
	private Long serviceId;
	
	@Column(name="task_name",length = 5100)
	private String taskName;
	
	@Column(name=	"template_id") 
	private Long templateID;
	
	@Column(name=	"template_name",length = 5100)
	private String templateName;
	
	@Column(name=	"form_flag",length = 5100 )
	private String formFlag;
	
	@Column(name=	"attribute_id")
	private Long attributeID;
	
	@Column(name=	"attribute_label",length = 2000)
	private String attributeLabel;
	
	@Column(name=	"attribute_input_type",length = 5100) 
	private String attributeInputType;
	
	@Column(name=	"default_value_type",length = 5100)
	private String defaultValuetype;
	
	@Column(name=	"attribute_pre_defined_Value",length = 5100) 
	private String attributepredefinedValue;
	
	@Column(name="attribute_lgd_location_type",length = 5100)
	private String attributeLGDLocationType;
	
	@Column(name="linked_attribute_type",length = 5100) 
	private String linkedAttributeType;
	
	@Column(name="parent_attribute_id",length = 5100 )
	private String parentAttributeID;
	
	@Column(name="is_web_service")
	private Long isWebService;
	
	@Column(name="fieldset_id",length = 5100)
	private String fieldsetID;

	
	public Long getpId() {
		return pId;
	}


	public void setpId(Long pId) {
		this.pId = pId;
	}


	public Long getBaseServiceID() {
		return baseServiceID;
	}


	public void setBaseServiceID(Long baseServiceID) {
		this.baseServiceID = baseServiceID;
	}


	public String getServiceName() {
		return serviceName;
	}


	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public Long getServiceId() {
		return serviceId;
	}


	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}


	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public Long getTemplateID() {
		return templateID;
	}


	public void setTemplateID(Long templateID) {
		this.templateID = templateID;
	}


	public String getTemplateName() {
		return templateName;
	}


	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}


	public String getFormFlag() {
		return formFlag;
	}


	public void setFormFlag(String formFlag) {
		this.formFlag = formFlag;
	}


	public Long getAttributeID() {
		return attributeID;
	}


	public void setAttributeID(Long attributeID) {
		this.attributeID = attributeID;
	}


	public String getAttributeLabel() {
		return attributeLabel;
	}


	public void setAttributeLabel(String attributeLabel) {
		this.attributeLabel = attributeLabel;
	}


	public String getAttributeInputType() {
		return attributeInputType;
	}


	public void setAttributeInputType(String attributeInputType) {
		this.attributeInputType = attributeInputType;
	}


	public String getDefaultValuetype() {
		return defaultValuetype;
	}


	public void setDefaultValuetype(String defaultValuetype) {
		this.defaultValuetype = defaultValuetype;
	}


	public String getAttributepredefinedValue() {
		return attributepredefinedValue;
	}


	public void setAttributepredefinedValue(String attributepredefinedValue) {
		this.attributepredefinedValue = attributepredefinedValue;
	}


	public String getAttributeLGDLocationType() {
		return attributeLGDLocationType;
	}


	public void setAttributeLGDLocationType(String attributeLGDLocationType) {
		this.attributeLGDLocationType = attributeLGDLocationType;
	}


	public String getLinkedAttributeType() {
		return linkedAttributeType;
	}


	public void setLinkedAttributeType(String linkedAttributeType) {
		this.linkedAttributeType = linkedAttributeType;
	}


	public String getParentAttributeID() {
		return parentAttributeID;
	}


	public void setParentAttributeID(String parentAttributeID) {
		this.parentAttributeID = parentAttributeID;
	}


	public Long getIsWebService() {
		return isWebService;
	}


	public void setIsWebService(Long isWebService) {
		this.isWebService = isWebService;
	}


	public String getFieldsetID() {
		return fieldsetID;
	}


	public void setFieldsetID(String fieldsetID) {
		this.fieldsetID = fieldsetID;
	}


	@Override
	public String toString() {
		return "AttributeMasterDataSql [BaseServiceID=" + baseServiceID + ", serviceName=" + serviceName
				+ ", serviceId=" + serviceId + ", taskName=" + taskName + ", templateID=" + templateID
				+ ", templateName=" + templateName + ", formFlag=" + formFlag + ", attributeID=" + attributeID
				+ ", attributeLabel=" + attributeLabel + ", attributeInputType=" + attributeInputType
				+ ", defaultValuetype=" + defaultValuetype + ", attributepredefinedValue=" + attributepredefinedValue
				+ ", attributeLGDLocationType=" + attributeLGDLocationType + ", linkedAttributeType="
				+ linkedAttributeType + ", parentAttributeID=" + parentAttributeID + ", isWebService=" + isWebService
				+ ", fieldsetID=" + fieldsetID + "]";
	}

}