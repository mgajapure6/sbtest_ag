package com.test.dto;

import java.util.Set;

public class QuestionDTO implements BaseDTO {
	
	private Long id;

	private String question;

	private Set<SubQuestionDTO> subQuestions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Set<SubQuestionDTO> getSubQuestions() {
		return subQuestions;
	}

	public void setSubQuestions(Set<SubQuestionDTO> subQuestions) {
		this.subQuestions = subQuestions;
	}
	
	

}
