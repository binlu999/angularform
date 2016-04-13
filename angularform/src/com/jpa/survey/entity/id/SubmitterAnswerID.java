package com.jpa.survey.entity.id;

import java.io.Serializable;

public class SubmitterAnswerID implements Serializable {

	private static final long serialVersionUID = 1L;
	private long surveyFormId;
	private long surveySubmitterId;
	private long questionId;
	private long optionId;

	public SubmitterAnswerID(){
		
	}
	
	public SubmitterAnswerID(long surveyFormId, long surveySubmitterId,
			long questionId, long optionIdId) {
		this.surveyFormId = surveyFormId;
		this.surveySubmitterId = surveySubmitterId;
		this.questionId = questionId;
		this.optionId = optionIdId;
	}

	public long getSurveyFormId() {
		return surveyFormId;
	}

	public void setSurveyFormId(long surveyFormId) {
		this.surveyFormId = surveyFormId;
	}

	public long getSurveySubmitterId() {
		return surveySubmitterId;
	}

	public void setSurveySubmitterId(long surveySubmitterId) {
		this.surveySubmitterId = surveySubmitterId;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}


	public long getOptionId() {
		return optionId;
	}

	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null
				&& obj instanceof SubmitterAnswerID
				&& this.surveyFormId == ((SubmitterAnswerID) obj)
						.getSurveyFormId()
				&& this.surveySubmitterId == ((SubmitterAnswerID) obj)
						.getSurveySubmitterId()
				&& this.questionId == ((SubmitterAnswerID) obj).getQuestionId()
				&& this.optionId == ((SubmitterAnswerID) obj).getOptionId();
	}

	@Override
	public int hashCode() {
		return (int) (this.surveyFormId + this.surveySubmitterId
				+ this.questionId + this.optionId);
	}

}
