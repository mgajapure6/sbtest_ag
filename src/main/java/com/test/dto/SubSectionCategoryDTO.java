package com.test.dto;

import java.util.Set;

public class SubSectionCategoryDTO implements BaseDTO {
	
	Long id;

	String name;
	
	Set<QuestionDTO> questions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<QuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<QuestionDTO> questions) {
		this.questions = questions;
	}
	
	

}
