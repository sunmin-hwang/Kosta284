package spring.service.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spring.service.domain.Member;

public class UnitTest {
	public static void main(String[] args) throws IOException {
		SqlSessionFactory factory = TestUtil.getFactory();
		
		SqlSession session = factory.openSession();

		Member pvo = new Member("mybatis", "mybatis", "마바", "일본");
		
		session.insert("MemberMapper.registerMember", pvo);
		session.commit();
		session.selectList("MemberMapper.findAllMember").forEach(c->System.out.println(c));
		
		System.out.println("===========================================================");
		
		List<Member> members = session.selectList("MemberMapper.getMember", "k");
		for (int i =0 ;  i < members.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ members.get(i).toString() );
		}
		
		System.out.println("===========================================================");
		
		session.delete("MemberMapper.deleteMember", "mybatis");
		session.commit();
		
		session.selectList("MemberMapper.findAllMember").forEach(c->System.out.println(c));
		session.close();
	}
}
