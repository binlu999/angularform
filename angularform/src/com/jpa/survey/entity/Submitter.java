package com.jpa.survey.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//@Entity(name = "SUBMITTERS")
public class Submitter extends GenericEntity {

	@Id
	@Column(name = "SURVEY_SUBMITTER_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long surveySubmitterId;

	@Column(name = "SURVEY_FORM_ID", nullable = false)
	private long surveyFormId;

	@Column(name = "POLICY_NO")
	private String policyNo;

	@Column(name = "COMPANY_CODE")
	private String companyCode;

	@Column(name = "SUBMITTED_TMSTMP")
	private Date submittedTime;

	@Column(name = "SUBMITTER_LAST_NAME")
	private String submitterLastName;

	@Column(name = "SUBMITTER_FIRST_NAME")
	private String submitterFirstName;

	@Column(name = "REGION_CODE")
	private String regionCode;

	@Column(name = "BRCH_OFC_CODE")
	private String branchOfficeCode;

	@Column(name = "PSO_NO")
	private String psoNo;

	@Column(name = "BUS_SEG_CODE")
	private String businessSegCode;

	@Column(name = "MARKETING_ORG_CODE")
	private String marketingOrgCode;

	@Column(name = "PC_CODE")
	private String pcCOde;

	@Column(name = "SUBMITTER_IP_ADDRESS")
	private String submitterIPAddress;

	@Column(name = "SUBMITTER_PHONE_NO")
	private String submitterPhoneNo;

	@Column(name = "BEST_TIME_TO_CALL")
	private String bestTimeToCall;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.ALL })
	@JoinColumn(name = "SURVEY_FORM_ID")
	private SurveyForm surveyForm;

	@OneToMany(mappedBy = "submitter", cascade = { CascadeType.ALL,
			CascadeType.PERSIST, CascadeType.REMOVE })
	private Collection<SubmitterAnswer> submitterAnswer = new ArrayList<SubmitterAnswer>();

	public Submitter() {

	}

	public long getSurveySubmitterId() {
		return surveySubmitterId;
	}

	public void setSurveySubmitterId(long surveySubmitterId) {
		this.surveySubmitterId = surveySubmitterId;
	}

	public long getSurveyFormId() {
		return surveyFormId;
	}

	public void setSurveyFormId(long surveyFormId) {
		this.surveyFormId = surveyFormId;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Date getSubmittedTime() {
		return submittedTime;
	}

	public void setSubmittedTime(Date submittedTime) {
		this.submittedTime = submittedTime;
	}

	public String getSubmitterLastName() {
		return submitterLastName;
	}

	public void setSubmitterLastName(String submitterLastName) {
		this.submitterLastName = submitterLastName;
	}

	public String getSubmitterFirstName() {
		return submitterFirstName;
	}

	public void setSubmitterFirstName(String submitterFirstName) {
		this.submitterFirstName = submitterFirstName;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getBranchOfficeCode() {
		return branchOfficeCode;
	}

	public void setBranchOfficeCode(String branchOfficeCode) {
		this.branchOfficeCode = branchOfficeCode;
	}

	public String getPsoNo() {
		return psoNo;
	}

	public void setPsoNo(String psoNo) {
		this.psoNo = psoNo;
	}

	public String getBusinessSegCode() {
		return businessSegCode;
	}

	public void setBusinessSegCode(String businessSegCode) {
		this.businessSegCode = businessSegCode;
	}

	public String getMarketingOrgCode() {
		return marketingOrgCode;
	}

	public void setMarketingOrgCode(String marketingOrgCode) {
		this.marketingOrgCode = marketingOrgCode;
	}

	public String getPcCOde() {
		return pcCOde;
	}

	public void setPcCOde(String pcCOde) {
		this.pcCOde = pcCOde;
	}

	public String getSubmitterIPAddress() {
		return submitterIPAddress;
	}

	public void setSubmitterIPAddress(String submitterIPAddress) {
		this.submitterIPAddress = submitterIPAddress;
	}

	public String getSubmitterPhoneNo() {
		return submitterPhoneNo;
	}

	public void setSubmitterPhoneNo(String submitterPhoneNo) {
		this.submitterPhoneNo = submitterPhoneNo;
	}

	public String getBestTimeToCall() {
		return bestTimeToCall;
	}

	public void setBestTimeToCall(String bestTimeToCall) {
		this.bestTimeToCall = bestTimeToCall;
	}

	public SurveyForm getSurveyForm() {
		return surveyForm;
	}

	public void setSurveyForm(SurveyForm surveyForm) {
		this.surveyForm = surveyForm;
	}

}
