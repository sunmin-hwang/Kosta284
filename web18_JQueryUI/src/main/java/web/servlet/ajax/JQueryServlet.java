package web.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/front.do")
public class JQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JQueryServlet() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command.equals("subject")) {
			subject(request, response);
		} else if(command.equals("company")) {
			company(request, response);
		}
	}

	private void subject(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = "Big Data | Python | java OOP | JDBC & Modeling | Spring MVC";
		PrintWriter out = response.getWriter();
		out.print(result);
		
	}

	private void company(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = "<ul><li> Tomato System </li><br><li> NCSoft Coporation </li><br><li> EAST System Company </li><br><li> LGCNS Software </li><br><li> Tomato System2 </li><br><li> Tomato System3 </li></ul>";
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
