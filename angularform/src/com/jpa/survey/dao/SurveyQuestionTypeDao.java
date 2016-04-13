package com.jpa.survey.dao;

import java.util.HashMap;
import java.util.Map;

import com.jpa.survey.entity.SurveyQuestionType;

public class SurveyQuestionTypeDao extends EntityDao<SurveyQuestionType> {

	public SurveyQuestionTypeDao() {
		super(SurveyQuestionType.class);
	}

	public SurveyQuestionType findBy(String code) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("code", code);
		SurveyQuestionType quetionType = super.runNamedTypedQueryForSingle(
				"SUVEY_QUESTION_TYPES.findSingleBy", parameters);
		return quetionType;
	}

}
