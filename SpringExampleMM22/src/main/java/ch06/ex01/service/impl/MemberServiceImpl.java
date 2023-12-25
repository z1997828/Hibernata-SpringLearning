package ch06.ex01.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ch05.ex00.dao.MemberDao;
import ch05.ex00.entity.Member;
import ch05.ex00.service.MemberService;
@Transactional
@Service("memberServiceHibernate")
public class MemberServiceImpl implements MemberService {

	@Autowired
	@Qualifier("MemberRepositoryHibernate")
	MemberDao memberDao;

	@Override
	public boolean existsByUserId(String userId) {
		return memberDao.existsByUserId(userId);
	}
	
	@Override
	public Member save(Member member) {
		return memberDao.save(member);
	}

	@Override
	public Member findById(Integer id) {
		return memberDao.findById(id);
	}
	
	@Override
	public void update(Member member) {
		memberDao.update(member);
	}

	@Override
	public void delete(Integer id) {
		memberDao.delete(id);		
	}

	@Override
	public List<Member> findAll() {
		return memberDao.findAll();
	}

}
