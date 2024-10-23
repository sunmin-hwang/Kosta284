package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.BookDAOImpl;
import web.servlet.vo.Book;

public class BookController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String[] isbns = request.getParameterValues("bookNo");
		String isbn = isbns[0] + "-" + isbns[1] + "-" + isbns[2];
		String bookTitle = request.getParameter("bookTitle");
		String bookCategory = request.getParameter("bookCategory");
		String bookCountry = request.getParameter("bookCountry");
		String bookDate = request.getParameter("bookDate");
		String bookPublisher = request.getParameter("bookPublisher");
		String bookAuthor = request.getParameter("bookAuthor");
		int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
		String bookPrice2 = request.getParameter("bookPrice2");
		String bookSummary = request.getParameter("bookSummary");
		
		Book book = new Book(isbn, bookTitle, bookCategory, bookCountry, bookDate, bookPublisher, bookAuthor, bookPrice, bookPrice2, bookSummary);
		String path = "../error/error.jsp";
		
		try {
			BookDAOImpl.getInstance().registerBook(book);
			request.setAttribute("msg", "책 정보가 정상적으로 저장되었습니다.");
			path = "book/bookSuccess.jsp";
		} catch (SQLException e) {
			request.setAttribute("msg", "책 등록중 오류발생...정보저장 실패!!");
			System.out.println(e);
		}
		return new ModelAndView(path);
	}

}
