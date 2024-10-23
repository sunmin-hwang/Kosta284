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
public class RegisterController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		Member pvo = null;
		
		if(name.equals("")&&address.equals("")) {
			pvo = new Member(id, password);			
		}else {
			pvo = new Member(id, password, name, address);
		}
		
		String path = "index.html";
		
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			request.setAttribute("vo", pvo);
			path = "register_result.jsp";
		} catch (SQLException e) {
		}
		return new ModelAndView(path);
	}

}
