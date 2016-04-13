package com.jpa.survey.vo;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jpa.survey.entity.SurveyQuestion;
import com.jpa.survey.entity.SurveyForm;
import com.jpa.survey.entity.Question;

public class SurveyFormVO {

	@JsonIgnore
	private long surveyFormId;
	private String companyCode;
	private String marketArea;
	private String prodCode;
	private String formDescription;
	@JsonProperty("Questions")
	private java.util.List<QuestionVO> questionVOs;

	public SurveyFormVO() {
	}

	public SurveyFormVO(SurveyForm surveyForm) {
		this.surveyFormId = surveyForm.getSurveyFormId();
		this.companyCode = surveyForm.getCompanyCode();
		this.marketArea = surveyForm.getMarketArea();
		this.prodCode = surveyForm.getProdCode();
		this.formDescription = surveyForm.getFormDescription();
		this.questionVOs = new java.util.ArrayList<QuestionVO>();
		Collection<SurveyQuestion> sqs = surveyForm.getSurveyQuestions();
		for (SurveyQuestion sq : sqs) {
			Question q = sq.getQuestion();
			QuestionVO surveyQuestionVO = new QuestionVO(q);
			surveyQuestionVO.setDisplpayOrder(sq.getContentOrder());
			this.questionVOs.add(surveyQuestionVO);
		}
	}

	public long getSurveyFormId() {
		return surveyFormId;
	}

	public void setSurveyFormId(long surveyFormId) {
		this.surveyFormId = surveyFormId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getMarketArea() {
		return marketArea;
	}

	public void setMarketArea(String marketArea) {
		this.marketArea = marketArea;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getFormDescription() {
		return formDescription;
	}

	public void setFormDescription(String formDescription) {
		this.formDescription = formDescription;
	}

	@JsonIgnore
	public SurveyForm getEntity() {
		SurveyForm surveyForm = new SurveyForm();
		surveyForm.setSurveyFormId(this.surveyFormId);
		surveyForm.setCompanyCode(this.companyCode);
		surveyForm.setMarketArea(this.marketArea);
		surveyForm.setProdCode(this.prodCode);
		surveyForm.setFormDescription(this.formDescription);
		if (this.questionVOs != null) {
			Collection<SurveyQuestion> sqs = new java.util.ArrayList<SurveyQuestion>();
			for (QuestionVO questionVO : questionVOs) {
				Question q = questionVO.getEntity();
				SurveyQuestion sq = new SurveyQuestion();
				sq.setSurveyForm(surveyForm);
				sq.setQuestion(q);
				sq.setContentOrder(questionVO.getDisplpayOrder());
				sqs.add(sq);
			}
			surveyForm.setSurveyQuestions(sqs);
		}
		return surveyForm;
	}

}
