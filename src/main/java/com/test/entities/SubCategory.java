package com.test.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.BeanUtils;

import com.test.dto.SubCategoryDTO;

@Entity
@Table(name = "sub_category")
public class SubCategory extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "sub_category_id", referencedColumnName = "id")
	private Set<Question> questions;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "sub_category_id", referencedColumnName = "id")
	private List<SubSectionCategory> subSectionCategories;

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

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public List<SubSectionCategory> getSubSectionCategories() {
		return subSectionCategories;
	}

	public void setSubSectionCategories(List<SubSectionCategory> subSectionCategories) {
		this.subSectionCategories = subSectionCategories;
	}

	@Override
	public SubCategoryDTO getDTO() {
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
		BeanUtils.copyProperties(this, subCategoryDTO);
		return subCategoryDTO;
	}

}
