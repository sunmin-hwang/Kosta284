package web.servlet.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/front.do", loadOnStartup = 1)
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AjaxServlet() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
