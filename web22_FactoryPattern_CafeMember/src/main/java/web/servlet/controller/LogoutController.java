package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
	Component란?
 	인터페이스 기반으로 작성된 재사용성 강한 자바 클래스
 	폼값 받아서
 	DAO 리턴받고 비지니스 로직 호출...데이터 반환
 	바인딩
 	네비게이션
 */
public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "login.jsp";
		try {
			//세션을 죽이는 로직..logout.jsp
			HttpSession session = request.getSession();
			if(session.getAttribute("vo") != null) {
				session.invalidate();
				path = "logout.jsp";				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(path);
	}

}
