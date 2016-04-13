package com.jpa.survey.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

//@Entity(name = "QUESTIONS_MASTER_TABLE")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name = "QUESTIONS_MASTER_TABLE.findAll", query = "SELECT f FROM QUESTIONS_MASTER_TABLE f"),
	@NamedQuery(name = "QUESTIONS_MASTER_TABLE.deleteAll", query = "DELETE FROM QUESTIONS_MASTER_TABLE f") })
public class Question extends GenericFormEntity{
	
	@Id
	@Column(name = "QUESTION_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key questionId;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.ALL })
	@JoinColumn(name = "QUESTION_TYPE_CODE")
	private SurveyQuestionType surveyQuestionType;
	
	@Column(name = "QUESTION_TEXT")
	private String questionText;

	@OneToMany(mappedBy="question")
    private Collection<SurveyQuestion> surveyQuestions = new ArrayList<SurveyQuestion>();
	
	@OneToMany(mappedBy="surveyQuestion", cascade = { CascadeType.PERSIST, CascadeType.ALL })
	private Collection<QuestionOption> questionOptions = new ArrayList<QuestionOption>();
	   
	public Key getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Key questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public SurveyQuestionType getSurveyQuestionType() {
		return surveyQuestionType;
	}

	public void setSurveyQuestionType(SurveyQuestionType surveyQuestionType) {
		this.surveyQuestionType = surveyQuestionType;
	}

	public Collection<QuestionOption> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(Collection<QuestionOption> questionOptions) {
		this.questionOptions = questionOptions;
	}
	
	
}
