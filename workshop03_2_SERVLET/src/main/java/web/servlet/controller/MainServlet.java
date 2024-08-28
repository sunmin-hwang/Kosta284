package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.vo.User;

@WebServlet(urlPatterns = "/MainServlet", loadOnStartup = 1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MainServlet() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		if(id.equals("kosta")&&pass.equals("1234")) {
			User user = new User(id, pass, "nameme", "종각");
			request.setAttribute("user", user);
			
			request.getRequestDispatcher("LoginSuccess").forward(request, response);
		}else {
			request.getRequestDispatcher("LoginError").forward(request, response);
		}
	}

}
