package web.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "../error/error.html";
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("vo") != null) {
				session.invalidate();
				path = "index.jsp";				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(path);
	}

}
