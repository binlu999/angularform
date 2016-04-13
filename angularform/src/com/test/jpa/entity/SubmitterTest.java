package com.test.jpa.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.jpa.survey.dao.SubmitterAnswerDao;
import com.jpa.survey.dao.SubmitterDao;
import com.jpa.survey.dao.SurveyFormDao;
import com.jpa.survey.entity.Question;
import com.jpa.survey.entity.QuestionOption;
import com.jpa.survey.entity.Submitter;
import com.jpa.survey.entity.SubmitterAnswer;
import com.jpa.survey.entity.SurveyForm;
import com.jpa.survey.entity.SurveyQuestion;

public class SubmitterTest extends GenericTest<SubmitterDao, Submitter> {

	private SurveyFormDao surveyFormDao = new SurveyFormDao();
	private SubmitterAnswerDao submitterAnswerDao = new SubmitterAnswerDao();

	protected SubmitterTest() throws InstantiationException,
			IllegalAccessException {
		super(SubmitterDao.class);
		
	}

	@Override
	public Submitter creatOne() {
		List<SurveyForm> forms = surveyFormDao.findAll();
		if (forms != null && forms.size() > 0) {
			SurveyForm form = forms.get(0);
			Submitter submitter = new Submitter();
			submitter.setSurveyForm(form);
			submitter.setBestTimeToCall("AM");
			submitter.setBranchOfficeCode("BRCH");
			submitter.setBusinessSegCode("BUSSGECODE");
			submitter.setCompanyCode("COMPCD");
			submitter.setMarketingOrgCode("MOCODE");
			submitter.setPcCOde("PCCODE");
			submitter.setPolicyNo("POLICNO");
			submitter.setPsoNo("PSONO");
			submitter.setRegionCode("REGCODE");
			submitter.setSubmittedTime(new Date());
			submitter.setSubmitterFirstName("firstName");
			submitter.setSubmitterLastName("lastName");
			submitter.setSubmitterPhoneNo("PhoneNo");
			return submitter;
		}
		return null;
	}

	public void testAnswer() {
		Submitter submitter = this.creatOne();
		submitter = this.save(submitter);
		long id = submitter.getSurveySubmitterId();
		
		SurveyForm form = submitter.getSurveyForm();
		Collection<SurveyQuestion> surveyQuestions = form.getSurveyQuestions();

		for (SurveyQuestion sq : surveyQuestions) {
			Question question = sq.getQuestion();
			answerQuestion(submitter, form, question);
		}

	}

	private SubmitterAnswer answerQuestion(Submitter submitter, SurveyForm form,
			Question question) {
		Collection<QuestionOption> options = question.getQuestionOptions();
		
		QuestionOption option = options.iterator().next();
		
		Question triggerQuestion = option.getTriggerQuestion();
		if (triggerQuestion != null) {
			answerQuestion(submitter, form, triggerQuestion);

		}
		SubmitterAnswer answer = new SubmitterAnswer();
		answer.setSubmitter(submitter);
		answer.setSurveySubmitterId(submitter.getSurveySubmitterId());
		answer.setSurveyForm(form);
		answer.setSurveyFormId(form.getSurveyFormId());
		answer.setQuestion(question);
		answer.setQuestionId(question.getQuestionId());
		answer.setOption(option);
		answer.setOptionId(option.getOptionId());
		answer.setAnswerText("OPT:" + option.getOptionText());


		System.out.println("Before save answer");
		SubmitterAnswer newAns = submitterAnswerDao.save(answer);
		System.out.println("After save answer");
		return newAns;
	}

}
