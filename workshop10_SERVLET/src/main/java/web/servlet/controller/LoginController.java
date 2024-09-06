package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.UserDAOImpl;
import web.servlet.vo.User;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		String path = "./error/error.html";
		
		try {
			User rvo = UserDAOImpl.getInstance().login(id, pass);
			HttpSession session = request.getSession();
			
			if(rvo!=null) {
				session.setAttribute("vo", rvo);
				path = "loginSuccess.jsp";
			}
		} catch (SQLException e) {
			System.out.println(e);
			path = "index.jsp";
		}
		return new ModelAndView(path);
	}

}
