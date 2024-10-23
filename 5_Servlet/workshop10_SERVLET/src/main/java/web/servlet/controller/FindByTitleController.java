package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.BookDAOImpl;
import web.servlet.vo.Book;

public class FindByTitleController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");
		Book book = null;
		try {
			book = BookDAOImpl.getInstance().findByTitle(isbn);
			request.setAttribute("book", book);
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return new ModelAndView("book/bookList_result.jsp");
	}

}
