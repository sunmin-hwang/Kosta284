package spring.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.Member;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;

public class MyBatisSpringDIAppTest {
	public static void main(String[] args) throws Exception{
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
								new String[] {	"/beans/memberservice.xml"	 }
									                                                    );
		
		MemberService memberService = (MemberService)context.getBean("memberServiceImpl");
		
		Member pvo = new Member("DI", "iBatis", "마이바티스디아이", "jonggak");
		System.out.println("회원가입 :: ");
		memberService.registerMember(pvo);
		
		System.out.println("전체 회원 :: ");
		memberService.showAllMember().forEach(m->System.out.println(m));
		System.out.println();
		
		pvo.setPassword("myBatis");
		pvo.setName("myBatisWithDI");
		System.out.println("정보수정 :: ");
		memberService.updateMember(pvo);
		
		System.out.println("이름이 mybatis인 회원 검색 :: ");
		System.out.println(memberService.getMember("mybatis"));
		System.out.println();
		
		Member mem = new Member();
		mem.setId("DI");
		System.out.println("id가 DI인 회원 검색 :: ");
		System.out.println(memberService.login(mem));
		System.out.println();
		
		mem.setPassword("myBatis");
		System.out.println("id가 DI이고 password가 myBatis인 회원 로그인 :: ");
		System.out.println(memberService.login(mem));
		System.out.println();
		
		MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAOImpl");
		System.out.println("회원 탈퇴 :: ");
		memberDAO.deleteMember("DI");
		
		System.out.println("전체 회원 :: ");
		memberService.showAllMember().forEach(m->System.out.println(m));
	}
}
