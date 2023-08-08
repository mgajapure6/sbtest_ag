package com.test.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entities.Category;
import com.test.entities.Question;
import com.test.entities.SubCategory;
import com.test.entities.SubQuestion;
import com.test.entities.SubSectionCategory;
import com.test.repositories.CategoryRepository;

@RestController
@RequestMapping("cat")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostConstruct
	public void init() {
		
		categoryRepository.deleteAll();
		
		SubQuestion subQuestion1 = new SubQuestion();
		subQuestion1.setQuestion("Diabetes");
		
		SubQuestion subQuestion2 = new SubQuestion();
		subQuestion2.setQuestion("BP");
		
		SubQuestion subQuestion3 = new SubQuestion();
		subQuestion3.setQuestion("Thyroid");
		
		SubQuestion subQuestion4 = new SubQuestion();
		subQuestion4.setQuestion("Other");
		
		Question question1 = new Question();
		question1.setQuestion("Is there any Diesease at the time of Delivery ?");
		question1.setSubQuestions(new HashSet<>(Arrays.asList(subQuestion1, subQuestion2, subQuestion3, subQuestion4)));
		
		Question question2 = new Question();
		question2.setQuestion("How many Deliveries ?");
		question2.setSubQuestions(new HashSet<>());
		
		Question question3 = new Question();
		question3.setQuestion("Abortions ?");
		question3.setSubQuestions(new HashSet<>());
		
		Question question4 = new Question();
		question4.setQuestion("Bleeding in 9 months ?");
		question4.setSubQuestions(new HashSet<>());
		
		Question question5 = new Question();
		question5.setQuestion("Consanguineous Marriages (in relations)");
		question5.setSubQuestions(new HashSet<>());
		
		SubSectionCategory subSectionCategory1 = new SubSectionCategory();
		subSectionCategory1.setName("Eating Habits");
		subSectionCategory1.setQuestions(new HashSet<>());
		
		SubSectionCategory subSectionCategory2 = new SubSectionCategory();
		subSectionCategory2.setName("Clothing");
		subSectionCategory2.setQuestions(new HashSet<>());
		
		SubCategory subCategory1 = new SubCategory();
		subCategory1.setName("Pre Pregnancy");
		subCategory1.setQuestions(new HashSet<>(Arrays.asList(question1, question2, question3, question4, question5)));
		subCategory1.setSubSectionCategories(new HashSet<>(Arrays.asList(subSectionCategory1, subSectionCategory2)));
		
		Question question6 = new Question();
		question6.setQuestion("Caesarean ?");
		question6.setSubQuestions(new HashSet<>());
		
		Question question7 = new Question();
		question7.setQuestion("Did baby cry immediate after delivery ?");
		question7.setSubQuestions(new HashSet<>());
		
		Question question8 = new Question();
		question8.setQuestion("Abortions ?");
		question8.setSubQuestions(new HashSet<>());
		
		Question question9 = new Question();
		question9.setQuestion("Bleeding in 9 months ?");
		question9.setSubQuestions(new HashSet<>());
		
		
		SubCategory subCategory2 = new SubCategory();
		subCategory2.setName("At the time of delivery");
		subCategory2.setQuestions(new HashSet<>(Arrays.asList(question6, question7, question8, question9)));
		subCategory2.setSubSectionCategories(new HashSet<>());
		
		Category category = new Category();
		category.setName("MOTHER'S HEALTH INFORMATION");
		category.setSubCategories(new HashSet<>(Arrays.asList(subCategory1, subCategory2)));
		
		categoryRepository.save(category);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> getCategory( @PathVariable("id") Long id){
		Map<String, Object> map = new HashMap<>();
		map.put("mainCategory", categoryRepository.findById(id).orElse(null));
		return ResponseEntity.ok(map);
	}
	
	
//	@GetMapping("/{id}")
//	public ResponseEntity<Map<String, Object>> getCategory( @PathVariable("id") Long id){
//		SubQuestionDTO sq1 = new SubQuestionDTO();
//		sq1.setId(1L);
//		sq1.setQuestion("sub question 1 ?");
//		Set<SubQuestionDTO> subQuestionDTOs = Set.of(sq1);
//		
//		QuestionDTO q1 = new QuestionDTO();
//		q1.setId(1L);
//		q1.setQuestion("question 1 ?");
//		QuestionDTO q2 = new QuestionDTO();
//		q2.setId(2L);
//		q2.setQuestion("question 2 ?");
//		q2.setSubQuestions(subQuestionDTOs);
//		Set<QuestionDTO> questionDTOs = Set.of(q1, q2);
//		
//		SubSectionCategoryDTO ssc1 = new SubSectionCategoryDTO();
//		ssc1.setId(1L);
//		ssc1.setName("Sub Section Category 1");
//		ssc1.setQuestions(questionDTOs);
//		Set<SubSectionCategoryDTO> subSectionCategoryDTOs = Set.of(ssc1);
//		
//		
//		SubCategoryDTO sc1 = new SubCategoryDTO();
//		sc1.setId(1L);
//		sc1.setName("Sub Cagtegory 1");
//		sc1.setQuestions(Set.of());
//		sc1.setSubSectionCategories(subSectionCategoryDTOs);
//		SubCategoryDTO sc2 = new SubCategoryDTO();
//		sc2.setId(2L);
//		sc2.setName("Sub Cagtegory 2");
//		sc2.setQuestions(questionDTOs);
//		sc2.setSubSectionCategories(Set.of());
//		Set<SubCategoryDTO> subCategoryDTOs = Set.of(sc1, sc2);
//		
//		CategoryDTO categoryDTO = new CategoryDTO();
//		categoryDTO.setId(id);
//		categoryDTO.setName("MOTHER HEALTH INFO");
//		categoryDTO.setSubCategories(subCategoryDTOs);
//		
//		Map<String, Object> map = new HashMap<>();
//		map.put("mainCategory", categoryDTO);
//		
//		return ResponseEntity.ok(map);
//	}
	
	

}
