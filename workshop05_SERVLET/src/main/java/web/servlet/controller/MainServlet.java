package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.dao.productDAO;
import web.servlet.vo.Product;

@WebServlet(urlPatterns = "/MainServlet", loadOnStartup = 1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        
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
		
		String name = request.getParameter("name").trim();
		int price = Integer.parseInt(request.getParameter("price").trim());
		String detail = request.getParameter("detail").trim();
		
		Product pvo = new Product(name, price, detail);
		
		try {
			productDAO.getInstance().register(pvo);
			request.setAttribute("vo", pvo);
			
			response.sendRedirect("List");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

}
