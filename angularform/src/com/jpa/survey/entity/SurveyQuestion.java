package com.jpa.survey.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.google.appengine.api.datastore.Key;
import com.jpa.survey.entity.id.SurveyQuestionID;

//@Entity(name = "SURVEY_QUESTIONS")
@Inheritance(strategy = InheritanceType.JOINED)
@IdClass(SurveyQuestionID.class)
@NamedQueries({
	@NamedQuery(name = "SURVEY_QUESTIONS.findAll", query = "SELECT f FROM SURVEY_QUESTIONS f"),
	@NamedQuery(name = "SURVEY_QUESTIONS.deleteAll", query = "DELETE FROM SURVEY_QUESTIONS f") })
public class SurveyQuestion  {
	
	@Id
	@Column(name = "SURVEY_FORM_ID", insertable = false, updatable = false)
	private long surveyFormId;

	@Id
	@Column(name = "QUESTION_ID", insertable = false, updatable = false)
	private Key questionId;

	@Column(name = "CONTENT_ORDER")
	private int contentOrder;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.ALL })
	@JoinColumn(name = "SURVEY_FORM_ID")
	private SurveyForm surveyForm;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.ALL })
	@JoinColumn(name = "QUESTION_ID")
	Question question;

	public long getSurveyFormId() {
		return surveyFormId;
	}

	public void setSurveyFormId(long surveyFormId) {
		this.surveyFormId = surveyFormId;
	}

	public Key getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Key questionId) {
		this.questionId = questionId;
	}

	public int getContentOrder() {
		return contentOrder;
	}

	public void setContentOrder(int contentOrder) {
		this.contentOrder = contentOrder;
	}

	public SurveyForm getSurveyForm() {
		return surveyForm;
	}

	public void setSurveyForm(SurveyForm surveyForm) {
		this.surveyForm = surveyForm;
	}

	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public SurveyQuestion() {

	}

	public SurveyQuestion(SurveyForm surveyForm, Question question) {
		this.surveyFormId = surveyForm.getSurveyFormId();
		this.surveyForm = surveyForm;
		this.questionId = question.getQuestionId();
		this.question = question;
	}
}
