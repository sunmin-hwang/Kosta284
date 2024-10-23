package spring.service.user;

import java.util.List;

import spring.service.domain.Member;

public interface MemberService {
	void registerMember(Member member) throws Exception;
	void updateMember(Member member) throws Exception;
	
	List<Member> showAllMember() throws Exception;
	List<Member> getMember(String name) throws Exception;
	Member login(Member member) throws Exception;
}
