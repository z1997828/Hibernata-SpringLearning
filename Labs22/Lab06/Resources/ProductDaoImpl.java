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
	
	@Override
	public void updateStock(int productId, int newQuantity) {
		Session session = factory.getCurrentSession();
		String hql = "UPDATE BookBean b SET b.stock = :stock WHERE bookId = :id";
		session.createQuery(hql).setParameter("stock", newQuantity)
	                            .setParameter("id", productId)
	                            .executeUpdate();
	}
	
	@Override
	public List<String> getAllCategories() {
		Session session = factory.getCurrentSession();
	    String hql = "SELECT DISTINCT b.category FROM BookBean b";
	    List<String> list = session.createQuery(hql, String.class)
	    						   .getResultList();
	    return list;
	}

	@Override
	public List<BookBean> getProductsByCategory(String category) {
		Session session = factory.getCurrentSession();
	    String hql = "FROM BookBean bb WHERE bb.category = :category";
	    List<BookBean> list = session.createQuery(hql, BookBean.class)
	    						     .setParameter("category", category)
	    						     .getResultList();
	    return list;
	}

	@Override
	public BookBean getProductById(int productId) {
		Session session = factory.getCurrentSession();
		BookBean bb = session.get(BookBean.class, productId);
		return bb;
	}
}
