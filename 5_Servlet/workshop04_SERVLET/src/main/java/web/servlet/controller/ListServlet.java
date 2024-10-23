package web.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;

import web.servlet.vo.Product;

@WebServlet(urlPatterns = "/List", loadOnStartup = 1)
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArrayList<Product> list = null;
	
    public ListServlet() {
       list = new ArrayList<Product>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product p1 =  new Product(1, "AAA", 4555500, "아주 굳");
		Product p3 =  new Product(2, "BBB", 5416500, "아주 밷");
		Product p2 =  new Product(3, "CCC", 85452100, "아주 씨");
		
		list.add(p1); list.add(p2); list.add(p3);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

}
