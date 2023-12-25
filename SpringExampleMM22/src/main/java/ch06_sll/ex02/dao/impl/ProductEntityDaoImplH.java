package ch06_sll.ex02.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ch06_sll.ex00.HibernateUtils;
import ch06_sll.ex02.dao.ProductEntityDaoH;
import ch06_sll.ex02.model.ProductEntityH;

public class ProductEntityDaoImplH implements ProductEntityDaoH {

	SessionFactory factory;

	public ProductEntityDaoImplH() {
		this.factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public ProductEntityH save(ProductEntityH product) {
		Session session = factory.getCurrentSession();
		session.save(product);
		return findById(product.getProductId());
	}

	@Override
	public ProductEntityH findById(int id) {
		Session session = factory.getCurrentSession();
		return session.get(ProductEntityH.class, id);
	}

	@Override
	public void update(ProductEntityH e) {
		Session session = factory.getCurrentSession();
		session.update(e);
	}

	@Override
	public void delete(int id) {
		Session session = factory.getCurrentSession();
		String hql = "DELETE FROM ch06_sll_ex02_ProductH WHERE productId = :id";
		session.createQuery(hql, ProductEntityH.class).executeUpdate();
	}

	@Override
	public List<ProductEntityH> findAll() {
		Session session = factory.getCurrentSession();
		String hql = "FROM ch06_sll_ex02_ProductH";
		List<ProductEntityH> productEntities = session.createQuery(hql, ProductEntityH.class).getResultList();
		return productEntities;
	}

}
