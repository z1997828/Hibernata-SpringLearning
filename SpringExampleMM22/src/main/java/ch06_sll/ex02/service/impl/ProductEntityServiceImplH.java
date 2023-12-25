package ch06_sll.ex02.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch06_sll.ex00.HibernateUtils;
import ch06_sll.ex02.dao.CategoryDaoH;
import ch06_sll.ex02.dao.ProductEntityDaoH;
import ch06_sll.ex02.dao.impl.CategoryDaoImplH;
import ch06_sll.ex02.dao.impl.ProductEntityDaoImplH;
import ch06_sll.ex02.model.CategoryH;
import ch06_sll.ex02.model.ProductEntityH;
import ch06_sll.ex02.service.ProductEntityServiceH;

public class ProductEntityServiceImplH implements ProductEntityServiceH {

	ProductEntityDaoH  productEntityDao;
	CategoryDaoH  categoryDao;
	SessionFactory  factory;
	
	public ProductEntityServiceImplH() {
		this.categoryDao = new CategoryDaoImplH();
		this.productEntityDao = new ProductEntityDaoImplH();
		this.factory = HibernateUtils.getSessionFactory();
	}
	
	@Override
	public Object save(ProductEntityH product) {
		Object obj = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			CategoryH category = categoryDao.findByName(product.getCategory().getName());
			if (category != null) {
				product.setCategory(category);
			} else {
				categoryDao.save(product.getCategory());
			}
			obj = productEntityDao.save(product);
			tx.commit();
		} catch(Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(ex.getMessage());
		}
		return obj;
	}

	@Override
	public ProductEntityH findById(int id) {
		ProductEntityH productEntity = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			productEntity = productEntityDao.findById(id);
			tx.commit();
		} catch(Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(ex.getMessage());
		}
		
		return productEntity;
	}

	@Override
	public void update(ProductEntityH product) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			productEntityDao.update(product);
			tx.commit();
		} catch(Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(ex.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			productEntityDao.delete(id);
			tx.commit();
		} catch(Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(ex.getMessage());
		}
	}

	@Override
	public List<ProductEntityH> findAll() {
		List<ProductEntityH>  ProductEntities = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ProductEntities = productEntityDao.findAll();
		    tx.commit();
		} catch(Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(ex.getMessage());
		}
		return ProductEntities;
	}

}
