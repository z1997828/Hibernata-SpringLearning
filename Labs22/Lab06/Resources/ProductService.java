package com.web.store.service;

import java.util.List;

import com.web.store.model.BookBean;

public interface ProductService {
	List<BookBean>  getAllProducts(); 
	
	void updateAllStocks();
	
	List<String>  getAllCategories();

	List<BookBean>  getProductsByCategory(String category);
	
	public BookBean getProductById(int productId);
} 
