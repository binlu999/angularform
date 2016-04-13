package com.test.jpa.entity;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jpa.survey.entity.QuestionOption;
import com.jpa.survey.entity.SurveyQuestion;
import com.jpa.survey.entity.SurveyForm;
import com.jpa.survey.entity.Question;

public class EntityTestRunner {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException {
		//QuestionOptionTest test=new QuestionOptionTest();
		//new SurveyQuestionTest().testDeleteAll();
		//(new SurveyContentTest()).testDeletAll();
		SurveyFormTest formTest = new SurveyFormTest();
		//formTest.testFindAll();
		//formTest.testExport();
		//formTest.testImport();
		//formTest.testDeleteAll();
		
		SubmitterTest submitterTest=new SubmitterTest();
		submitterTest.testAnswer();
		
		SurveyQuestionTypeTest surveyQuestionTypeTest=new SurveyQuestionTypeTest();
		try {
			surveyQuestionTypeTest.testExport();
			//surveyQuestionTypeTest.testImport();
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*
		SurveyForm form = formTest.find(6401);
		Collection<SurveyContent> contents = form.getSurveyContents();
		for(SurveyContent content:contents){
			SurveyQuestion q = content.getSurveyQuestion();
			Collection<QuestionOption> options = q.getQuestionOptions();
			assert(options.size()>0);
		}
		assert(contents.size()>0);
	*/
	}

}
