package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.UserDAOImpl;
import web.servlet.vo.User;

@WebServlet(urlPatterns = "/Login", loadOnStartup = 1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MainServlet() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		
		try {
			User rvo = UserDAOImpl.getInstance().login(id, pass);
			HttpSession session = request.getSession();
			
			if(rvo!=null) {
				session.setAttribute("vo", rvo);
				request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			}else {
				response.sendRedirect("./error/error.html");
			}
		} catch (SQLException e) {
			System.out.println(e);
			response.sendRedirect("error.jsp");
		}
	}

}
