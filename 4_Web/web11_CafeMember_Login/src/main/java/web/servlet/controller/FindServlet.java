package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.sevlet.model.Member;
import web.sevlet.model.MemberDAOImpl;

@WebServlet(urlPatterns = "/Find", loadOnStartup = 1)
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FindServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get방식 요청을 처리...
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post방식 요청을 처리...
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직을 여기서 작성...
		/*
		 1. 한글처리..양방향
		 2. 폼에서 id값 받아옴
		 3. MemberDAOImpl의 findByMember(String id) 호출해서 값 받아옴
		 4. 받아온 값 바인딩
		 5. 네비게이션
		 */
		/*
		 * request.setCharacterEncoding("utf-8");
		 * response.setContentType("text/html;charset=utf-8");
		 */
		
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
		request.getRequestDispatcher(path).forward(request, response);
	}
}
