package ch06_sll.ex02.dao;

import java.util.List;

import ch06_sll.ex02.model.CategoryH;

public interface CategoryDaoH {

	CategoryH findById(Integer id);

	CategoryH findByName(String categoryName);
	
	Object save(CategoryH category);

	List<CategoryH> findAll();
}
