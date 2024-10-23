package spring.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.service.domain.Member;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public void registerMember(Member member) throws Exception {
		memberDAO.registerMember(member);
	}

	@Override
	public void updateMember(Member member) throws Exception {
		memberDAO.updateMember(member);
	}

	@Override
	public List<Member> showAllMember() throws Exception {
		return memberDAO.showAllMember();
	}

	@Override
	public List<Member> getMember(String name) throws Exception {
		return memberDAO.getMember(name);
	}

	@Override
	public Member login(Member member) throws Exception {
		return memberDAO.login(member);
	}

}
