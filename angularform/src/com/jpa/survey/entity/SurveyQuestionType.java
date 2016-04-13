package com.jpa.survey.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//@Entity(name = "SUVEY_QUESTION_TYPES")
@NamedQueries({
	@NamedQuery(name = "SUVEY_QUESTION_TYPES.findAll", query = "SELECT f FROM SUVEY_QUESTION_TYPES f"),
	@NamedQuery(name = "SUVEY_QUESTION_TYPES.deleteAll", query = "DELETE FROM SUVEY_QUESTION_TYPES f"),
	@NamedQuery(name = "SUVEY_QUESTION_TYPES.findSingleBy", query = "SELECT f FROM SUVEY_QUESTION_TYPES f WHERE f.code = :code ")})
public class SurveyQuestionType extends GenericEntity{
	
	@Id
	@Column(name = "QUESTION_TYPE_CODE", nullable = false)
	private String code;
	
	@Column(name = "QUESTION_TYPE_DESC")
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
