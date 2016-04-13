package com.jpa.survey.entity.id;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

public class SurveyQuestionID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public long surveyFormId;
	public Key questionId;

	public SurveyQuestionID() {

	}

	public SurveyQuestionID(long surveyFormId, Key questionId) {
		this.surveyFormId = surveyFormId;
		this.questionId = questionId;
	}

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

	@Override
	public boolean equals(Object obj) {
		return obj instanceof SurveyQuestionID
				&& this.surveyFormId == ((SurveyQuestionID) obj)
						.getSurveyFormId()
				&& this.questionId == ((SurveyQuestionID) obj)
						.getQuestionId();
	}

	@Override
	public int hashCode() {
		return (int) (this.surveyFormId + this.questionId.hashCode());
	}

	@Override
	public String toString() {
		return ""+this.surveyFormId+"::"+this.questionId;
	}
	
}
