package spring.service.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spring.service.domain.Member;

public class MyBatisMemberTestApp {
	public static void main(String[] args) {
		SqlSessionFactory factory = TestUtil.getFactory();
		
		SqlSession session = factory.openSession();
		
		Member pvo = new Member("mybatis", "ibatis", "아바", "일본");
		
		System.out.println("멤버 가입 :: " + session.insert("MemberMapper.registerMember", pvo));
		session.commit();
		
		session.selectList("MemberMapper.showAllMember").forEach(m->System.out.println(m));
		System.out.println();
		
		pvo.setPassword("mybatis");
		pvo.setName("마바");
		System.out.println("정보 수정 :: " + session.update("MemberMapper.updateMember", pvo));
		session.commit();
		session.selectList("MemberMapper.getMember", "마").forEach(m->System.out.println(m));;
		System.out.println();
		
		Member mem = new Member();
		mem.setId("kosta");
		System.out.println("id = kosta 아이디 찾기 :: " + session.selectOne("MemberMapper.login", mem));
		
		mem.setPassword("koko");
		System.out.println("id = kosta, pass = koko 로그인 :: " + session.selectOne("MemberMapper.login", mem));
		System.out.println();
		
		System.out.println("회원 삭제 :: " + session.update("MemberMapper.deleteMember", "mybatis"));
		session.commit();
		
		session.selectList("MemberMapper.showAllMember").forEach(m->System.out.println(m));
	}
}
