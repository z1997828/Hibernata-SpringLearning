package ch06_sll.ex01.service;

import java.util.List;

import ch06_sll.ex01.model.Category;

public interface CategoryService {

	Category findById(int id);

	Category findByName(String categoryName);
	
	Category save(Category category);

	List<Category> findAll();
}
