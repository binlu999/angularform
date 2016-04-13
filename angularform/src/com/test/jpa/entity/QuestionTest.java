package com.test.jpa.entity;

import java.util.Date;

import com.jpa.survey.dao.QuestionDao;
import com.jpa.survey.entity.Question;

public class QuestionTest extends
		GenericTest<QuestionDao, Question> {

	protected QuestionTest() throws InstantiationException,
			IllegalAccessException {
		super(QuestionDao.class);
	}

	@Override
	public Question creatOne() {
		Question e = new Question();
		e.setQuestionText("Have you received your contract?");
		//e.setQuestionTypeId(QuestionType.TEXT.getValue());
		e.setInactiveFlag(false);
		e.setLastUPDTId("SYSTEM ADMIN");
		e.setLastUPDTDate(new Date());
		//assert (e.getQuestionId() == 0);
		return e;
	}

	public void testDeleteAll(){
		this.dao.deletAll();
	}
}
