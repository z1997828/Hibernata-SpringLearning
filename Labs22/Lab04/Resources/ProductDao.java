package com.web.store.dao;

import java.util.List;

import com.web.store.model.BookBean;

public interface ProductDao {
	List<BookBean>  getAllProducts();  

	void updateStock(int productId, int newQuantity);

}
