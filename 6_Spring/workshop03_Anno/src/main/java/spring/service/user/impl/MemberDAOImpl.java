package spring.service.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.service.domain.Member;
import spring.service.user.MemberDAO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	public static final String NS = "MemberMapper.";
	
	@Override
	public int registerMember(Member member) throws Exception {
		return sqlSession.insert(NS + "registerMember", member);
	}

	@Override
	public int updateMember(Member member) throws Exception {
		return sqlSession.update(NS + "updateMember", member);
	}

	@Override
	public int deleteMember(String id) throws Exception {
		return sqlSession.delete(NS + "deleteMember", id);
	}

	@Override
	public List<Member> showAllMember() throws Exception {
		return sqlSession.selectList(NS + "showAllMember");
	}

	@Override
	public List<Member> getMember(String name) throws Exception {
		return sqlSession.selectList(NS + "getMember", name);
	}

	@Override
	public Member login(Member member) throws Exception {
		return sqlSession.selectOne(NS + "login", member);
	}

}
