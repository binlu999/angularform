package com.test.jpa.entity;

import java.util.Date;
import java.util.List;

import com.jpa.survey.dao.QuestionOptionDao;
import com.jpa.survey.dao.SubmitterAnswerDao;
import com.jpa.survey.dao.SurveyFormDao;
import com.jpa.survey.entity.QuestionOption;
import com.jpa.survey.entity.Submitter;
import com.jpa.survey.entity.SubmitterAnswer;
import com.jpa.survey.entity.SurveyForm;

public class SubmitterAnswerTest extends
GenericTest<SubmitterAnswerDao, SubmitterAnswer> {
	SurveyFormDao surveyFormDao=new SurveyFormDao();
	protected SubmitterAnswerTest()
			throws InstantiationException, IllegalAccessException {
		super(SubmitterAnswerDao.class);
	}

	@Override
	public SubmitterAnswer creatOne() {
		List<SurveyForm> forms = surveyFormDao.findAll();
		if(forms!=null && forms.size()>0){
			SurveyForm form=forms.get(0);
			Submitter submitter=new Submitter();
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
			
		}
		return null;
	}

}
