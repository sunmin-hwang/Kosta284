package web.servlet.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.BookDAOImpl;
import web.servlet.vo.Book;

public class ShowBookController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String searchOption = request.getParameter("searchOption");
		String searchText = request.getParameter("searchText");
		
		String path = "../error/error.html";
		try {
			ArrayList<Book> list = BookDAOImpl.getInstance().showBooks(searchOption, searchText);
			request.setAttribute("list", list);
			path = "book/bookList.jsp";
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(path);
	}

}
