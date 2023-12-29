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
	ProductDao dao;
    
	@Autowired
    public void setDao(ProductDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public List<BookBean> getAllProducts() {
		return dao.getAllProducts(); 
	}
}
