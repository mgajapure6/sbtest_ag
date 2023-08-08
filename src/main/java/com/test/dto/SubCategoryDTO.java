package com.test.dto;

import java.util.Set;

public class SubCategoryDTO implements BaseDTO {

	Long id;

	String name;

	Set<QuestionDTO> questions;

	Set<SubSectionCategoryDTO> subSectionCategories;

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

	public Set<SubSectionCategoryDTO> getSubSectionCategories() {
		return subSectionCategories;
	}

	public void setSubSectionCategories(Set<SubSectionCategoryDTO> subSectionCategories) {
		this.subSectionCategories = subSectionCategories;
	}

	
}
