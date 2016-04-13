package com.jpa.survey.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.google.appengine.api.datastore.Key;

//@Entity(name = "QUESTION_OPTIONS")
@Inheritance(strategy = InheritanceType.JOINED)
public class QuestionOption extends GenericFormEntity {

	@Id
	@Column(name = "OPTION_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long optionId;

	@Column(name = "QUESTION_ID")
	private long questionId;

	@Column(name = "OPTION_TEXT")
	private String optionText;

	@Column(name = "OPTION_ORDER")
	private int optionOrder;

	@Column(name = "TRIGGER_QUESTION_ID")
	private Key triggerQuestionId;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.ALL })
	@JoinColumn(name = "QUESTION_ID")
	private Question surveyQuestion;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.ALL })
	@JoinColumn(name = "TRIGGER_QUESTION_ID", referencedColumnName = "QUESTION_ID")
	Question triggerQuestion;

	public long getOptionId() {
		return optionId;
	}

	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public Key getTriggerQuestionId() {
		return triggerQuestionId;
	}

	public void setTriggerQuestionId(Key triggerQuestionId) {
		this.triggerQuestionId = triggerQuestionId;
	}

	public int getOptionOrder() {
		return optionOrder;
	}

	public void setOptionOrder(int optionOrder) {
		this.optionOrder = optionOrder;
	}

	public Question getSurveyQuestion() {
		return surveyQuestion;
	}

	public void setSurveyQuestion(Question surveyQuestion) {
		/*
		if (this.triggerQuestionId == 0 || surveyQuestion.getQuestionId() == 0
				|| surveyQuestion.getQuestionId() != this.triggerQuestionId)
				*/
			this.surveyQuestion = surveyQuestion;
	}

	public Question getTriggerQuestion() {
		return triggerQuestion;
	}

	public void setTriggerQuestion(Question triggerQuestion) {
		/*
		if (this.questionId == 0 || triggerQuestion.getQuestionId() == 0
				|| triggerQuestion.getQuestionId() != this.questionId)
				*/
			this.triggerQuestion = triggerQuestion;
	}

}
