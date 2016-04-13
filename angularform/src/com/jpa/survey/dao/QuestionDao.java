package com.jpa.survey.dao;

import java.util.Collection;

import com.jpa.survey.entity.QuestionOption;
import com.jpa.survey.entity.Question;

public class QuestionDao extends EntityDao<Question> {
	public QuestionDao() {
		super(Question.class);
	}

	@Override
	public Question save(Question question) {
		Collection<QuestionOption> options = question.getQuestionOptions();
		for (QuestionOption option : options) {
			Question triggerQuestion = option.getTriggerQuestion();
			if (triggerQuestion != null) {
				triggerQuestion = save(triggerQuestion);
				option.setTriggerQuestion(triggerQuestion);
				option.setTriggerQuestionId(triggerQuestion.getQuestionId());
			}
		}
		return super.save(question);
	}

	public int deletAll() {
		return super.runNamedQuery("QUESTIONS_MASTER_TABLE.deleteAll");
	}

}
