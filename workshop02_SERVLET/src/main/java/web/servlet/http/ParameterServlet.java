package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/params", loadOnStartup = 1)
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ParameterServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String job = request.getParameter("job");
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		String searchWord = request.getParameter("searchWord");
		
		PrintWriter out = response.getWriter();
		out.println("<h3>job : " + job + "</h3>");
		out.println("<h3>pageNo : " + pageNo + "</h3>");
		out.println("<h3>searchWord : " + searchWord + "</h3>");
	}  

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		StringBuilder sbHpbby = new StringBuilder();
		for(String h : hobby) {
			sbHpbby.append(h).append(" , ");
		}
		sbHpbby.delete(sbHpbby.length()-2, sbHpbby.length()-1);
		String favorite = request.getParameter("favorite");
		String desc = request.getParameter("desc");
		
		PrintWriter out = response.getWriter();
		out.println("<h3>name : " + name + "</h3>");
		out.println("<h3>email : " + email + "</h3>");
		out.println("<h3>gender : " + gender + "</h3>");
		out.print("<h3>hobby : " + sbHpbby + "</h3>");
		out.println("<h3>favorite : " + favorite + "</h3>");
		out.println("<h3>desc : " + desc + "</h3>");
	}
}
