package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/BuyServlet", loadOnStartup = 1)
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BuyServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("vo") != null) { //기존의 세션을 사용...로그인이 되었다면..
			System.out.println("BuyServlet JSSESION :: " + session.getId());
			
			session.setAttribute("pname", "WideTV");
			request.getRequestDispatcher("buy_result.jsp").forward(request, response);
		}else {//로그인 안된 상태라면
			response.sendRedirect("login.html");
		}
	}

}
