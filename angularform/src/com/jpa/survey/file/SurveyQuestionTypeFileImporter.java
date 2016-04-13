package com.jpa.survey.file;

import java.io.IOException;
import java.io.InputStream;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.survey.dao.SurveyQuestionTypeDao;
import com.jpa.survey.entity.SurveyQuestionType;
import com.jpa.survey.vo.SurveyQuestionTypeVO;

public class SurveyQuestionTypeFileImporter {

	private SurveyQuestionTypeDao surveyQuestionTypeDao;
	ObjectMapper mapper;

	public SurveyQuestionTypeFileImporter() {
		surveyQuestionTypeDao = new SurveyQuestionTypeDao();
		mapper = new ObjectMapper();
	}

	public void importQuestionType(String resourcePath) throws JsonParseException, JsonMappingException, IOException {
		InputStream input = this.getClass().getClassLoader()
				.getResourceAsStream(resourcePath);
		SurveyQuestionTypeVO surveyQuestionTypeVO = mapper.readValue(input, SurveyQuestionTypeVO.class);
		for(SurveyQuestionType type:surveyQuestionTypeVO.getSurveyQuestionTypes()){
			this.surveyQuestionTypeDao.save(type);
		}
	}
}
