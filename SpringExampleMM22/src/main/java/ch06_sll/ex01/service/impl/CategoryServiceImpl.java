package ch06_sll.ex01.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch06_sll.ex01.dao.CategoryDao;
import ch06_sll.ex01.model.Category;
import ch06_sll.ex01.service.CategoryService;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

	CategoryDao  categoryDao;
	SessionFactory  factory;
	
//	@Autowired
	public CategoryServiceImpl(CategoryDao categoryDao, SessionFactory factory) {
		this.categoryDao = categoryDao;
		this.factory = factory;
	}

	@Override
	public Category findById(int id) {
		Category category = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			System.out.println("-------------------------");
			category = categoryDao.findById(id);
			System.out.println("-------------------------");			
//			tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
		return category;
	}

	@Override
	public Category findByName(String categoryName) {
		Category category = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
		    category = categoryDao.findByName(categoryName);
//		    tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
		return category;
	}

	@Override
	public Category save(Category category) {
		Category category1 = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			category1 = categoryDao.save(category);
//			tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
		return category1;
	}

	@Override
	public List<Category> findAll() {
		List<Category>  categories = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			System.out.println("1.******************");
		    categories = categoryDao.findAll();
		    System.out.println("2.******************");
//		    tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
		return categories;
	}
}
