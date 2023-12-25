package ch06.ex01.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch05.ex00.dao.MemberDao;
import ch05.ex00.entity.Member;
@Repository("MemberRepositoryHibernate")
public class MemberRepositoryHibernateImpl implements MemberDao {
	
	SessionFactory factory;
    
	@Autowired
	public MemberRepositoryHibernateImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public Member save(Member member) {
		Session session = factory.getCurrentSession();
		Integer id = (Integer) session.save(member);
		return session.get(Member.class, id);
	}

	@Override
	public Member findById(Integer id) {
		Member member = null;
		Session session = factory.getCurrentSession();
		member = (Member) session.get(Member.class, id);
		return member;
	}

	

	@Override
	public void update(Member mem) {
		Member member = null;
		Session session = factory.getCurrentSession();
		// 
		member = (Member) session.get(Member.class, mem.getId());
		member.setPhoneNo(mem.getPhoneNo());
		member.setExperience(mem.getExperience());
		member.setName(mem.getName());
		member.setBirthday(mem.getBirthday());
		member.setPassword(mem.getPassword());
		member.setRegisterTime(mem.getRegisterTime());
		session.update(member);
	}

	@Override
	public void delete(Integer id) {
		Session session = factory.getCurrentSession();
		Member mem = new Member();
		mem.setId(id);
		session.delete(mem);
	}

	@Override
	public List<Member> findAll() {
		List<Member> allMembers = new ArrayList<Member>();
		Session session = factory.getCurrentSession();
		allMembers = session.createQuery("FROM Member", Member.class).list();
		return allMembers;
	}

	@Override
	public boolean existsByUserId(String userId) {
		boolean exist = false;
		Session session = factory.getCurrentSession();
		System.out.println("userId=" + userId);
		String queryString = "FROM Member m WHERE m.userId = :userId";
		List<?> list = session.createQuery(queryString)
							  .setParameter("userId", userId)
							  .getResultList();
		
		if (!list.isEmpty()) {
			exist = true;
		}
		return exist;
	}
}
