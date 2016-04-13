package com.jpa.survey.dao;

import java.util.Collection;
import java.util.List;
import com.jpa.survey.entity.SurveyQuestion;
import com.jpa.survey.entity.SurveyForm;
import com.jpa.survey.entity.Question;

public class SurveyFormDao extends EntityDao<SurveyForm>{
	QuestionDao surveyQuestionDao=new QuestionDao();
	public SurveyFormDao(){
		super(SurveyForm.class);
	}

	@Override
	public SurveyForm save(SurveyForm surveyForm) {
		Collection<SurveyQuestion> sqs = surveyForm.getSurveyQuestions();
		for(SurveyQuestion sq:sqs){
			Question question = sq.getQuestion();
			Question savedQuestion=surveyQuestionDao.save(question);
			sq.setQuestion(savedQuestion);
			sq.setQuestionId(savedQuestion.getQuestionId());
		}
		return super.save(surveyForm);
	}

	public List<SurveyForm> findAll() {
		return super.runNamedTypedQueryForAll("SURVEY_FORMS.findAll");
	}

	public int deletAll() {
		return super.runNamedQuery("SURVEY_FORMS.deleteAll");
	}
	
}
