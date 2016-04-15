package com.jpa.survey.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jpa.survey.dao.SurveyFormDao;
import com.jpa.survey.entity.QuestionOption;
import com.jpa.survey.entity.SurveyQuestion;
import com.jpa.survey.entity.SurveyForm;
import com.jpa.survey.entity.Question;
import com.jpa.survey.vo.SurveyFormVO;

public class SurveyFormFileImporter {
	private SurveyFormDao surveyFormDao;
	ObjectMapper mapper;

	public SurveyFormFileImporter() {
		// surveyFormDao = new SurveyFormDao();
		mapper = new ObjectMapper();
		mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
	}

	public SurveyFormVO importFileToObject(String resourcePath)
			throws JsonParseException, JsonMappingException, IOException {
		InputStream input = this.getClass().getClassLoader()
				.getResourceAsStream(resourcePath);
		SurveyFormVO surveyFormVO = mapper.readValue(input, SurveyFormVO.class);
		return surveyFormVO;

	}

	public SurveyFormVO importFileToObjectByGson(String resourcePath)
			throws JsonParseException, JsonMappingException, IOException {
		InputStream input =null;
		try{
		input= this.getClass().getClassLoader()
				.getResourceAsStream(resourcePath);
		Gson gson = new GsonBuilder().create();
		Reader reader = new InputStreamReader(input);
		SurveyFormVO surveyFormVO = gson.fromJson(reader, SurveyFormVO.class);
		return surveyFormVO;
		}finally{
			if(input!=null)
				input.close();
		}

	}

	public void importFile(String resourcePath) throws JsonParseException,
			JsonMappingException, IOException {
		SurveyFormVO surveyFormVO = importFileToObject(resourcePath);
		SurveyForm surveyForm = surveyFormVO.getEntity();
		persit(surveyForm);
	}

	private void persit(SurveyForm surveyForm) {
		surveyFormDao.save(surveyForm);
	}

}
