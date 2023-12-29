package com.web.store.dao.impl;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.store.dao.ProductDao;
import com.web.store.model.BookBean;
@Repository
public class ProductDaoImpl implements ProductDao {
	SessionFactory factory;
	
	@Autowired
	public ProductDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public List<BookBean> getAllProducts() {
		Session session = factory.getCurrentSession();
		String hql = "FROM BookBean";
		List<BookBean> list = session.createQuery(hql, BookBean.class)
				                     .getResultList();
		return list;
	}
}
