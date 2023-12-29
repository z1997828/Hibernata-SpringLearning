package com.web.store.dao.impl;

import java.util.ArrayList;
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
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<BookBean> getAllProducts() {
		String hql = "FROM BookBean";
		Session session = null;
		List<BookBean> list = new ArrayList<>();
		session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}
}
