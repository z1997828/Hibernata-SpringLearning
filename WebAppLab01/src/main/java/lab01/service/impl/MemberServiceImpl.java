package lab01.service.impl;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import lab01.dao.MemberDao;
import lab01.dao.impl.MemberJdbcDaoImpl;
import lab01.model.MemberBean;
import lab01.service.MemberService;
import lab01.utils.HibernateUtils;

@Service
public class MemberServiceImpl implements MemberService {
	
	MemberDao memberDao = null;
	SessionFactory factory;
	public MemberServiceImpl() {
		memberDao = new MemberJdbcDaoImpl();
		factory = HibernateUtils.getSessionFactory();
	}	

	public MemberBean findById(Integer id) {
		MemberBean memberBean = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			memberBean = memberDao.findById(id);
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return memberBean;
	}
	
	public List<MemberBean> findAll() {
		List<MemberBean> beans;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			beans = memberDao.findAll();
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return beans;
	}

	public void save(MemberBean bean) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			memberDao.save(bean);
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	public void deleteById(Integer id) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			memberDao.deleteById(id);
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean existsByMemberId(String memberId) {
		boolean exist = false;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			exist = memberDao.existsByMemberId(memberId);
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return exist;
	}

	@Override
	public void update(MemberBean memberBean) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			memberDao.update(memberBean);
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}
}