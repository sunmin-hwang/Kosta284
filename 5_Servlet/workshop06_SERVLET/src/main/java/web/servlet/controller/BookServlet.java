package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.BookDAOImpl;
import web.servlet.vo.Book;

@WebServlet(urlPatterns = "/book/BookServlet", loadOnStartup = 1)
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookServlet() {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
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
		
		try {
			BookDAOImpl.getInstance().registerBook(book);
			HttpSession session = request.getSession();
			session.setAttribute("book", book);
			request.getRequestDispatcher("bookSuccess.jsp").forward(request, response);
		} catch (SQLException e) {
			System.out.println(e);
			response.sendRedirect("../error/error.html");
		}
	}

}
