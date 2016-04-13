package com.jpa.survey.vo;

import java.util.List;

import com.jpa.survey.entity.SurveyQuestionType;

public class SurveyQuestionTypeVO {
	List<SurveyQuestionType> surveyQuestionTypes;

	public List<SurveyQuestionType> getSurveyQuestionTypes() {
		return surveyQuestionTypes;
	}

	public void setSurveyQuestionTypes(List<SurveyQuestionType> surveyQuestionTypes) {
		this.surveyQuestionTypes = surveyQuestionTypes;
	}
	
}
