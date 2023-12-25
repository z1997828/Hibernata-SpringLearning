package ch06_sll.ex01.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ch06_sll.ex01.dao.ProductEntityDao;
import ch06_sll.ex01.model.ProductEntity;

@Repository
public class ProductEntityDaoImpl implements ProductEntityDao {

	SessionFactory factory;
//	@Autowired
	public ProductEntityDaoImpl(SessionFactory  factory) {
		this.factory = factory;
	}

	@Override
	public ProductEntity save(ProductEntity product) {
		Session session = factory.getCurrentSession();
		session.save(product);
		return findById(product.getProductId());
	}

	@Override
	public ProductEntity findById(int id) {
		Session session = factory.getCurrentSession();
		return session.get(ProductEntity.class, id);
	}

	@Override
	public void update(ProductEntity e) {
		Session session = factory.getCurrentSession();
		session.update(e);
	}

	@Override
	public void delete(int id) {
		Session session = factory.getCurrentSession();
		String hql = "DELETE FROM ch06_sll_ex01_Product WHERE productId = :id";
		session.createQuery(hql, ProductEntity.class).executeUpdate();
	}

	@Override
	public List<ProductEntity> findAll() {
		Session session = factory.getCurrentSession();
		String hql = "FROM ch06_sll_ex01_Product";
		List<ProductEntity> productEntities = session.createQuery(hql, ProductEntity.class).getResultList();
		return productEntities;
	}

}
