package com.test.entities;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.dto.QuestionDTO;

@Entity
@Table(name = "question")
public class Question extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Column(name = "question")
	private String question;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "question_id", referencedColumnName = "id")
	private Set<SubQuestion> subQuestions;

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

	public Set<SubQuestion> getSubQuestions() {
		return subQuestions;
	}

	public void setSubQuestions(Set<SubQuestion> subQuestions) {
		this.subQuestions = subQuestions;
	}

	@Override
	@JsonIgnore
	public QuestionDTO getDTO() {
		QuestionDTO questionDTO = new QuestionDTO();
		BeanUtils.copyProperties(this, questionDTO);
		return questionDTO;
	}

}
