package com.web.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.store.dao.ProductDao;
import com.web.store.model.BookBean;
import com.web.store.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Transactional
	@Override
	public List<BookBean> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Transactional
	@Override
	public void updateAllStocks() {
	    List<BookBean> allProducts = productDao.getAllProducts();
	    for(BookBean bb : allProducts) {
	        if (bb.getStock() != null && bb.getStock() < 50) {
	        	productDao.updateStock(bb.getBookId(), bb.getStock() + 50);
	        }
	    }
	}
	
	@Transactional
	@Override
	public List<String> getAllCategories() {
	    return productDao.getAllCategories();
	}

	@Transactional
	@Override
	public List<BookBean> getProductsByCategory(String category) {
	    return productDao.getProductsByCategory(category);
	}
}
