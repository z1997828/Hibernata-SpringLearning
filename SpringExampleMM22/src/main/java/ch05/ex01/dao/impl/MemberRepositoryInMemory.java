package ch05.ex01.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import ch05._00.utils.GlobalService;
import ch05.ex00.dao.MemberDao;
import ch05.ex00.entity.Member;

@Repository("MemberRepositoryInMemory")
public class MemberRepositoryInMemory implements MemberDao {

	@Override
	public Member save(Member member) {
		if (existsByUserId(member.getUserId()) ) {
			throw new IllegalStateException("會員代號已存在: 代號=" + member.getUserId());
		}
		GlobalService.getMembers().add(member);
		return member;
	}

	@Override
	public Member findById(Integer id) {
		List<Member> members = GlobalService.getMembers();
		for(Member member : members) {
			if (member.getId().equals(id)) {
				return member;
			}
		}
		return null;
	}

	@Override
	public boolean existsByUserId(String userId) {
		List<Member> members = GlobalService.getMembers();
		for(Member member : members) {
			if (member.getUserId().equalsIgnoreCase(userId)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void update(Member member) {
		List<Member> members = GlobalService.getMembers();
		for(Member mem : members) {
			if (mem.getId().equals(member.getId())) {
				mem.setBirthday(member.getBirthday());
				mem.setPhoneNo(member.getPhoneNo());
				mem.setExperience(member.getExperience());
				mem.setName(member.getName());
				mem.setPassword(member.getPassword());
			}
		}
	}

	@Override
	public void delete(Integer id) {
		List<Member> members = GlobalService.getMembers();
		Iterator<Member> it = members.iterator();
		while (it.hasNext()) {
			Member member = it.next();
			if (member.getId().equals(id)) {
				it.remove();
			}
		}
	}

	@Override
	public List<Member> findAll() {
		return GlobalService.getMembers();
	}
}