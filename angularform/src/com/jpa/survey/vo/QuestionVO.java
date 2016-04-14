package com.jpa.survey.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.appengine.api.datastore.Key;
import com.jpa.survey.entity.QuestionOption;
import com.jpa.survey.entity.Question;
import com.jpa.util.QuestionTypeUtil;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionVO {

	@JsonIgnore
	private String questionId;
	private String questionText;
	private String questionType;
	@JsonProperty("options")
	private List<QuestionOptionVO> options;
	private int displpayOrder;
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public QuestionVO() {
		super();
	}

	public QuestionVO(Question question) {

		this.questionId = question.getQuestionId().toString();
		this.questionText = question.getQuestionText();
		this.questionType = question.getSurveyQuestionType().getCode();

		Collection<QuestionOption> options = question
				.getQuestionOptions();
		if (options.size() > 0) {
			this.options = new ArrayList<QuestionOptionVO>();
			for (QuestionOption option : options) {
				QuestionOptionVO optionVO = new QuestionOptionVO(option);
				this.options.add(optionVO);
			}
		}
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public List<QuestionOptionVO> getOptions() {
		return options;
	}

	public void setOptions(List<QuestionOptionVO> options) {
		this.options = options;
	}
	
	

	public int getDisplpayOrder() {
		return displpayOrder;
	}

	public void setDisplpayOrder(int displpayOrder) {
		this.displpayOrder = displpayOrder;
	}

	@JsonIgnore
	public Question getEntity() {
		Question question = new Question();
		//question.setQuestionId(this.questionId);
		question.setQuestionText(this.questionText);
		question.setSurveyQuestionType(QuestionTypeUtil.getSurveyQuestionType(this.questionType));
		if(this.options!=null){
			ArrayList<QuestionOption> questionOptions=new ArrayList<QuestionOption>();
			for(QuestionOptionVO questionOptionVO : options){
				QuestionOption questionOption = questionOptionVO.getEntity();
				questionOption.setSurveyQuestion(question);
				questionOptions.add(questionOption);
			}
			question.setQuestionOptions(questionOptions);
		}
		return question;
	}
}
