package com.test.dto;

import java.util.Set;

public class CategoryDTO implements BaseDTO {
	
	Long id;
	
	String name;
	
	Set<SubCategoryDTO> subCategories;

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

	public Set<SubCategoryDTO> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<SubCategoryDTO> subCategories) {
		this.subCategories = subCategories;
	}

}
