package com.test.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
