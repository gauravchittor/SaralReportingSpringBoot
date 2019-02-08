package com.saral.reporting.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_adm_sign")
public class LoginData {

	@Id
	@Column(name="sign_no")
	private String signNo;

	@Column(name = "passwd")
	private String passwd;

	@Column(name = "sign_role")
	private String signRole;

	@Column(name = "sign_desc")
	private String signDesc;

	@Column(name = "choice_cntr_no")
	private String choiceCntrNo;

	@Column(name = "designation")
	private String designation;

	@Column(name = "description")
	private String description;

	@Column(name = "smsid")
	private String smsid;

	@Column(name = "fingerprintimage")
	private Byte[] fingerprintimage;

	@Column(name = "superior_id")
	private String superiorId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "cert_serial_num")
	private String certSerialNum;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "generated_login")
	private Character generateLogin;

	@Column(name = "signing_option")
	private Character signingOption;

	@Column(name = "last_mdfd_by")
	private String lastMdfdBy;

	@Column(name = "last_mdfd_date")
	private Date lastMdfdDate;

	@Column(name = "user_id") // timestamp without time zone,
	private Long userId;

	@Column(name = "location_type_id")
	private Long locationTypeId;

	@Column(name = "location_id")
	private Long locationId;

	@Column(name = "state_id")
	private Long stateId;

	@Column(name = "location_type_flag")
	private Character locationTypeFlag;

	@Column(name = "zila_parisad")
	private Long zilaParisad;

	@Column(name = "panchayat_samiti")
	private Long panchayatSamiti;

	@Column(name = "gram_panchayat")
	private Long gramPanchayat;

	@Column(name = "corporation")
	private Long corporation;

	@Column(name = "municipality")
	private Long municipality;

	@Column(name = "spdi_created_by")
	private Long spdiCreatedBy;

	@Column(name = "spdi_status")
	private Long spdiStatus;

	@Column(name = "spdv_location_name")
	private String spdvLocationName;

	@Column(name = "spdv_change_password_flag")
	private Character spdvChangepasswordFlag;

	@Column(name = "smsemail_send_flag")
	private Character smsemailSendFlag;

	@Column(name = "sync_user_flag")
	private boolean syncUserFlag;

	

	public String getSignNo() {
		return signNo;
	}

	public void setSignNo(String signNo) {
		this.signNo = signNo;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getSignRole() {
		return signRole;
	}

	public void setSignRole(String signRole) {
		this.signRole = signRole;
	}

	public String getSignDesc() {
		return signDesc;
	}

	public void setSignDesc(String signDesc) {
		this.signDesc = signDesc;
	}

	public String getChoiceCntrNo() {
		return choiceCntrNo;
	}

	public void setChoiceCntrNo(String choiceCntrNo) {
		this.choiceCntrNo = choiceCntrNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSmsid() {
		return smsid;
	}

	public void setSmsid(String smsid) {
		this.smsid = smsid;
	}

	public Byte[] getFingerprintimage() {
		return fingerprintimage;
	}

	public void setFingerprintimage(Byte[] fingerprintimage) {
		this.fingerprintimage = fingerprintimage;
	}

	public String getSuperiorId() {
		return superiorId;
	}

	public void setSuperiorId(String superiorId) {
		this.superiorId = superiorId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCertSerialNum() {
		return certSerialNum;
	}

	public void setCertSerialNum(String certSerialNum) {
		this.certSerialNum = certSerialNum;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Character getGenerateLogin() {
		return generateLogin;
	}

	public void setGenerateLogin(Character generateLogin) {
		this.generateLogin = generateLogin;
	}

	public Character getSigningOption() {
		return signingOption;
	}

	public void setSigningOption(Character signingOption) {
		this.signingOption = signingOption;
	}

	public String getLastMdfdBy() {
		return lastMdfdBy;
	}

	public void setLastMdfdBy(String lastMdfdBy) {
		this.lastMdfdBy = lastMdfdBy;
	}

	public Date getLastMdfdDate() {
		return lastMdfdDate;
	}

	public void setLastMdfdDate(Date lastMdfdDate) {
		this.lastMdfdDate = lastMdfdDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getLocationTypeId() {
		return locationTypeId;
	}

	public void setLocationTypeId(Long locationTypeId) {
		this.locationTypeId = locationTypeId;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Character getLocationTypeFlag() {
		return locationTypeFlag;
	}

	public void setLocationTypeFlag(Character locationTypeFlag) {
		this.locationTypeFlag = locationTypeFlag;
	}

	public Long getZilaParisad() {
		return zilaParisad;
	}

	public void setZilaParisad(Long zilaParisad) {
		this.zilaParisad = zilaParisad;
	}

	public Long getPanchayatSamiti() {
		return panchayatSamiti;
	}

	public void setPanchayatSamiti(Long panchayatSamiti) {
		this.panchayatSamiti = panchayatSamiti;
	}

	public Long getGramPanchayat() {
		return gramPanchayat;
	}

	public void setGramPanchayat(Long gramPanchayat) {
		this.gramPanchayat = gramPanchayat;
	}

	public Long getCorporation() {
		return corporation;
	}

	public void setCorporation(Long corporation) {
		this.corporation = corporation;
	}

	public Long getMunicipality() {
		return municipality;
	}

	public void setMunicipality(Long municipality) {
		this.municipality = municipality;
	}

	public Long getSpdiCreatedBy() {
		return spdiCreatedBy;
	}

	public void setSpdiCreatedBy(Long spdiCreatedBy) {
		this.spdiCreatedBy = spdiCreatedBy;
	}

	public Long getSpdiStatus() {
		return spdiStatus;
	}

	public void setSpdiStatus(Long spdiStatus) {
		this.spdiStatus = spdiStatus;
	}

	public String getSpdvLocationName() {
		return spdvLocationName;
	}

	public void setSpdvLocationName(String spdvLocationName) {
		this.spdvLocationName = spdvLocationName;
	}

	public Character getSpdvChangepasswordFlag() {
		return spdvChangepasswordFlag;
	}

	public void setSpdvChangepasswordFlag(Character spdvChangepasswordFlag) {
		this.spdvChangepasswordFlag = spdvChangepasswordFlag;
	}

	public Character getSmsemailSendFlag() {
		return smsemailSendFlag;
	}

	public void setSmsemailSendFlag(Character smsemailSendFlag) {
		this.smsemailSendFlag = smsemailSendFlag;
	}

	public boolean isSyncUserFlag() {
		return syncUserFlag;
	}

	public void setSyncUserFlag(boolean syncUserFlag) {
		this.syncUserFlag = syncUserFlag;
	}

	@Override
	public String toString() {
		return "LoginData [sign_no=" + signNo + ", passwd=" + passwd + ", signRole=" + signRole + ", signDesc="
				+ signDesc + ", choiceCntrNo=" + choiceCntrNo + ", designation=" + designation + ", description="
				+ description + ", smsid=" + smsid + ", fingerprintimage=" + Arrays.toString(fingerprintimage)
				+ ", superiorId=" + superiorId + ", userName=" + userName + ", certSerialNum=" + certSerialNum
				+ ", mobileNo=" + mobileNo + ", generateLogin=" + generateLogin + ", signingOption=" + signingOption
				+ ", lastMdfdBy=" + lastMdfdBy + ", lastMdfdDate=" + lastMdfdDate + ", userId=" + userId
				+ ", locationTypeId=" + locationTypeId + ", locationId=" + locationId + ", stateId=" + stateId
				+ ", locationTypeFlag=" + locationTypeFlag + ", zilaParisad=" + zilaParisad + ", panchayatSamiti="
				+ panchayatSamiti + ", gramPanchayat=" + gramPanchayat + ", corporation=" + corporation
				+ ", municipality=" + municipality + ", spdiCreatedBy=" + spdiCreatedBy + ", spdiStatus=" + spdiStatus
				+ ", spdvLocationName=" + spdvLocationName + ", spdvChangepasswordFlag=" + spdvChangepasswordFlag
				+ ", smsemailSendFlag=" + smsemailSendFlag + ", syncUserFlag=" + syncUserFlag + "]";
	}

}
