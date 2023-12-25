package ch06_sll.ex02.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch06_sll.ex00.HibernateUtils;
import ch06_sll.ex02.dao.CategoryDaoH;
import ch06_sll.ex02.dao.impl.CategoryDaoImplH;
import ch06_sll.ex02.model.CategoryH;
import ch06_sll.ex02.service.CategoryServiceH;

public class CategoryServiceImplH implements CategoryServiceH {

	CategoryDaoH  categoryDao;
	SessionFactory  factory;
	
	public CategoryServiceImplH() {
		this.categoryDao = new CategoryDaoImplH();
		this.factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public CategoryH findById(int id) {
		CategoryH category = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		try {
//			tx = session.beginTransaction();
//			System.out.println("-------------------------");
			category = categoryDao.findById(id);
//			System.out.println("-------------------------");
//			tx.commit();
		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
			throw new RuntimeException(ex.getMessage());
		}
		return category;
	}

	@Override
	public CategoryH findByName(String categoryName) {
		CategoryH category = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		    category = categoryDao.findByName(categoryName);
		    tx.commit();
		} catch(Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(ex.getMessage());
		}
		return category;
	}

	@Override
	public CategoryH save(CategoryH category) {
		CategoryH categoryH1 = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			categoryDao.save(category);
			categoryH1 = findById(category.getCategoryId());
			tx.commit();
		} catch(Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(ex.getMessage());
		}
		return categoryH1;
	}

	@Override
	public List<CategoryH> findAll() {
		List<CategoryH>  categories = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("1.******************");
		    categories = categoryDao.findAll();
		    System.out.println("2.******************");
		    tx.commit();
		} catch(Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(ex.getMessage());
		}
		return categories;
	}

}
