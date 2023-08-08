package com.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.dto.SubQuestionDTO;

@Entity
@Table(name = "sub_question")
public class SubQuestion extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Column(name = "question")
	private String question;

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

	@Override
	@JsonIgnore
	public SubQuestionDTO getDTO() {
		SubQuestionDTO subQuestionDTO = new SubQuestionDTO();
		BeanUtils.copyProperties(this, subQuestionDTO);
		return subQuestionDTO;
	}

}
