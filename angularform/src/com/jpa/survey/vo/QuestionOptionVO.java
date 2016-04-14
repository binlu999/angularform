package com.jpa.survey.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jpa.survey.entity.QuestionOption;
import com.jpa.survey.entity.Question;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionOptionVO {

	@JsonIgnore
	private String optionId;
	private String optionText;
	private int optionOrder;
	@JsonProperty("triggerQuestion")
	private QuestionVO triggerQuestion;
	
	private String value;

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public QuestionOptionVO(){
		super();
	}
	public QuestionOptionVO(QuestionOption option) {
		this.optionId=String.valueOf(option.getOptionId());
		this.optionText=option.getOptionText();
		this.optionOrder=option.getOptionOrder();
		Question trigerQuestion = option.getTriggerQuestion();
		if(trigerQuestion!=null){
			this.triggerQuestion=new QuestionVO(trigerQuestion);
		}
	}

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public int getOptionOrder() {
		return optionOrder;
	}

	public void setOptionOrder(int optionOrder) {
		this.optionOrder = optionOrder;
	}

	public QuestionVO getTriggerQuestionVO() {
		return triggerQuestion;
	}

	public void setTriggerQuestionVO(QuestionVO triggerQuestionVO) {
		this.triggerQuestion = triggerQuestionVO;
	}
	
	@JsonIgnore
	public QuestionOption getEntity() {
		QuestionOption option=new QuestionOption();
		option.setOptionId(Long.valueOf(this.optionId));
		option.setOptionText(this.optionText);
		option.setOptionOrder(this.optionOrder);
		if(this.triggerQuestion!=null){
			option.setTriggerQuestion(this.triggerQuestion.getEntity());
		}
		return option;
	}	

}
