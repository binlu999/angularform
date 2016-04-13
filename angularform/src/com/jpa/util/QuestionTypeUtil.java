package com.jpa.util;

import java.util.HashMap;
import java.util.Map;

import com.jpa.survey.dao.SurveyQuestionTypeDao;
import com.jpa.survey.entity.SurveyQuestionType;

public class QuestionTypeUtil {
	private static SurveyQuestionTypeDao surveyQuestionTypeDao=new SurveyQuestionTypeDao();
	private static Map<String, SurveyQuestionType> surveyQuestionTypes=new HashMap<String, SurveyQuestionType>();
	
	public static SurveyQuestionType getSurveyQuestionType(String code){
		SurveyQuestionType type = surveyQuestionTypes.get(code);
		if(type==null){
			type=surveyQuestionTypeDao.findBy(code);
			if(type!=null){
				surveyQuestionTypes.put(code, type);
			}
		}
		return type;
	}

}
