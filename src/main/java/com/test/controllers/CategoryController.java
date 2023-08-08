package com.test.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.CategoryDTO;
import com.test.dto.QuestionDTO;
import com.test.dto.SubCategoryDTO;
import com.test.dto.SubQuestionDTO;
import com.test.dto.SubSectionCategoryDTO;

@RestController
@RequestMapping("cat")
public class CategoryController {
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> getCategory( @PathVariable("id") Long id){
		SubQuestionDTO sq1 = new SubQuestionDTO();
		sq1.setId(1L);
		sq1.setQuestion("sub question 1 ?");
		Set<SubQuestionDTO> subQuestionDTOs = Set.of(sq1);
		
		QuestionDTO q1 = new QuestionDTO();
		q1.setId(1L);
		q1.setQuestion("question 1 ?");
		QuestionDTO q2 = new QuestionDTO();
		q2.setId(2L);
		q2.setQuestion("question 2 ?");
		q2.setSubQuestions(subQuestionDTOs);
		Set<QuestionDTO> questionDTOs = Set.of(q1, q2);
		
		SubSectionCategoryDTO ssc1 = new SubSectionCategoryDTO();
		ssc1.setId(1L);
		ssc1.setName("Sub Section Category 1");
		ssc1.setQuestions(questionDTOs);
		Set<SubSectionCategoryDTO> subSectionCategoryDTOs = Set.of(ssc1);
		
		
		SubCategoryDTO sc1 = new SubCategoryDTO();
		sc1.setId(1L);
		sc1.setName("Sub Cagtegory 1");
		sc1.setQuestions(Set.of());
		sc1.setSubSectionCategories(subSectionCategoryDTOs);
		SubCategoryDTO sc2 = new SubCategoryDTO();
		sc2.setId(2L);
		sc2.setName("Sub Cagtegory 2");
		sc2.setQuestions(questionDTOs);
		sc2.setSubSectionCategories(Set.of());
		Set<SubCategoryDTO> subCategoryDTOs = Set.of(sc1, sc2);
		
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(id);
		categoryDTO.setName("MOTHER HEALTH INFO");
		categoryDTO.setSubCategories(subCategoryDTOs);
		
		Map<String, Object> map = new HashMap<>();
		map.put("mainCategory", categoryDTO);
		
		return ResponseEntity.ok(map);
	}
	
	

}
