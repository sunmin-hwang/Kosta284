package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.sevlet.model.Member;
import web.sevlet.model.MemberDAOImpl;

@WebServlet(urlPatterns = "/LoginServlet", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 결과페이지
		 * login_result.jsp
		 * */
		//1. 폼값 가져옴
		//2. DAO 통해 로그인
		//3. session 받아와서 바인딩(vo!=null)
		//4. login_result.jsp 네비게이션
		/*
		 * request.setCharacterEncoding("utf-8");
		 * response.setContentType("text/html;charset=utf-8");
		 */
		
		String id = request.getParameter("id");
		String pass=  request.getParameter("password");
		String path = "index.html";
		
		try {
			Member rvo = MemberDAOImpl.getInstance().login(id, pass);
			HttpSession session = request.getSession();
			/*
			 	Session에 바인딩하는 경우
			 	1) 로그인 로직...
			 	2) 정보수정 로직...
			 */
			if(rvo!=null) {
				session.setAttribute("vo", rvo);
				System.out.println("LoginServlet..JSESSIONID ::: " + session.getId());
				path = "login_result.jsp";
			}
		} catch (SQLException e) {
			System.out.println(e);
			path="login_fail.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
