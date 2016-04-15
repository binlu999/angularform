package com.jpa.survey.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jpa.survey.dao.SurveyQuestionTypeDao;
import com.jpa.survey.entity.SurveyQuestionType;
import com.jpa.survey.vo.SurveyQuestionTypeVO;

public class SurveyQuestionTypeFileImporter {

	private SurveyQuestionTypeDao surveyQuestionTypeDao;
	ObjectMapper mapper;

	public SurveyQuestionTypeFileImporter() {

	}

	public void importQuestionType(String resourcePath) throws JsonParseException, JsonMappingException, IOException {
		InputStream input = this.getClass().getClassLoader()
				.getResourceAsStream(resourcePath);
		SurveyQuestionTypeVO surveyQuestionTypeVO = mapper.readValue(input, SurveyQuestionTypeVO.class);
		for(SurveyQuestionType type:surveyQuestionTypeVO.getSurveyQuestionTypes()){
			this.surveyQuestionTypeDao.save(type);
		}
	}
	
	public SurveyQuestionTypeVO importQuestionTypeByGSON(String resourcePath) throws  IOException {
		
		InputStream input =null;
		try{
		input= this.getClass().getClassLoader()
				.getResourceAsStream(resourcePath);
		Gson gson = new GsonBuilder().create();
		Reader reader = new InputStreamReader(input);
		SurveyQuestionTypeVO surveyQuestionTypeVO = gson.fromJson(reader, SurveyQuestionTypeVO.class);
		return surveyQuestionTypeVO;
		}finally{
			if(input!=null)
				input.close();
		}
				
	}
	
}
