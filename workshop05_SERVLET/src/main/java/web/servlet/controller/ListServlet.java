package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.dao.productDAO;
import web.servlet.vo.Product;

@WebServlet(urlPatterns = "/List", loadOnStartup = 1)
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArrayList<Product> list = null;
	
    public ListServlet() {
       list = new ArrayList<Product>();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String path = "index.html";
		try {
			list = productDAO.getInstance().findProducts();
			request.setAttribute("list", list);
			path = "list.jsp";
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
