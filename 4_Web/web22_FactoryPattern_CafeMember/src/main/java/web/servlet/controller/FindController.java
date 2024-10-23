package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.sevlet.model.Member;
import web.sevlet.model.MemberDAOImpl;

/*
	Component란?
 	인터페이스 기반으로 작성된 재사용성 강한 자바 클래스
 	폼값 받아서
 	DAO 리턴받고 비지니스 로직 호출...데이터 반환
 	바인딩
 	네비게이션
 */
public class FindController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id =request.getParameter("id");
		String path = "find_fail.jsp";
		try {
			Member rvo = MemberDAOImpl.getInstance().findByMember(id);
			if(rvo!=null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}
			
		} catch (SQLException e) {
			
		}
		return new ModelAndView(path);
	}

}
