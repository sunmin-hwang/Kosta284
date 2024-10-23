package web.servlet.page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Redirect2", loadOnStartup = 1)
public class ChoiceRedirect2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChoiceRedirect2() {
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] city = request.getParameterValues("city");
		
		if(city==null) {
			response.sendRedirect("error/error2.html");
		}else {
			StringBuilder sb = new StringBuilder();
			for(String c : city) {
				sb.append(c).append(", ");
			}
			sb.delete(sb.length()-2, sb.length()-1);
			
			request.setAttribute("city", sb.toString());
			
			request.getRequestDispatcher("redirect2.jsp").forward(request, response);
		}
	}

}
