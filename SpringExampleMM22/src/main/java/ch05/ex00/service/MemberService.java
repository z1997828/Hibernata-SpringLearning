package ch05.ex00.service;

import java.util.List;

import ch05.ex00.entity.Member;

public interface MemberService {
	
	public Member save(Member mem);

	public Member findById(Integer id);

	public boolean existsByUserId(String userId);

	public void update(Member mem);

	public void delete(Integer id);

	public List<Member> findAll();

}
