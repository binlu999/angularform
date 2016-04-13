package com.test.jpa.entity;

import com.jpa.survey.dao.QuestionOptionDao;
import com.jpa.survey.dao.QuestionDao;
import com.jpa.survey.entity.QuestionOption;
import com.jpa.survey.entity.Question;

public class QuestionOptionTest extends
		GenericTest<QuestionOptionDao, QuestionOption> {

	protected QuestionOptionTest() throws InstantiationException,
			IllegalAccessException {
		super(QuestionOptionDao.class);
	}

	@Override
	public QuestionOption creatOne() {
		QuestionOption e=new QuestionOption();
		e.setOptionText("Yes");
		e.setOptionOrder(1);
		return e;
	}
	
	public void testAssignToQuestion(){
		QuestionDao questionDao=new QuestionDao();
		Question question = questionDao.find(6451);
		Question trigerQuestion = questionDao.find(6251);
		
		QuestionOption option = this.find(6501);
		
		option.setSurveyQuestion(question);
		option.setTriggerQuestion(trigerQuestion);
		this.dao.save(option);
		
		//question.getQuestionOptions().add(option);
		//questionDao.save(question);
		
	}

}
