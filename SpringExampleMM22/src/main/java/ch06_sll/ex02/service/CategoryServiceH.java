package ch06_sll.ex02.service;

import java.util.List;

import ch06_sll.ex02.model.CategoryH;

public interface CategoryServiceH {

	CategoryH findById(int id);

	CategoryH findByName(String categoryName);
	
	Object save(CategoryH category);

	List<CategoryH> findAll();
}
