package ch06_sll.ex02.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ch06_sll.ex00.HibernateUtils;
import ch06_sll.ex02.dao.CategoryDaoH;
import ch06_sll.ex02.model.CategoryH;

public class CategoryDaoImplH implements CategoryDaoH {

	SessionFactory  factory;
	
	public CategoryDaoImplH() {
		this.factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public CategoryH findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.get(CategoryH.class, id);
	}

	@Override
	public CategoryH findByName(String categoryName) {
		Session session = factory.getCurrentSession();
		String  hql = "FROM ch06_sll_ex02_CategoryH c WHERE c.name = :name"; 
		List<CategoryH> categories = session.createQuery(hql, CategoryH.class)
				                           .setParameter("name", categoryName)
				                           .getResultList();
		if (categories.size() > 0) {
			return categories.get(0);
		}  else {
			return null;
		}
	}


	@Override
	public Object save(CategoryH category) {
		Session session = factory.getCurrentSession();
		session.save(category);
		return findById(category.getCategoryId());
	}

	@Override
	public List<CategoryH> findAll() {
		Session session = factory.getCurrentSession();
		String  hql = "FROM ch06_sll_ex02_CategoryH"; 
		List<CategoryH> categories = session.createQuery(hql, CategoryH.class)
				                           .getResultList();
		return categories;
	}

}
