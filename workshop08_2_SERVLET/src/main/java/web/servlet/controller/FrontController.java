package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.BookDAOImpl;
import web.servlet.model.UserDAOImpl;
import web.servlet.vo.Book;
import web.servlet.vo.User;

@WebServlet(urlPatterns = "/front.do", loadOnStartup = 1)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontController() { }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPrecess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPrecess(request, response);
	}
	
	protected void doPrecess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String path = "index.html";
		
		if(command.equals("login")) {
			path = login(request, response);
		} else if(command.equals("book")) {
			path = book(request, response);
		} else if(command.equals("logout")) {
			path = logout(request, response);
		} else if(command.equals("showBook")) {
			path = showBook(request, response);
		}else if(command.equals("findByTitle")) {
			path = findByTitle(request, response);
		}  
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {		
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		String path = "./error/error.html";
		
		try {
			User rvo = UserDAOImpl.getInstance().login(id, pass);
			HttpSession session = request.getSession();
			
			if(rvo!=null) {
				session.setAttribute("vo", rvo);
				path = "loginSuccess.jsp";
			}
		} catch (SQLException e) {
			System.out.println(e);
			path = "index.jsp";
		}
		return path;
	}

	private String book(HttpServletRequest request, HttpServletResponse response) {
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
		
		return path;
	}

	private String logout(HttpServletRequest request, HttpServletResponse response) {
		String path = "../error/error.html";
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("vo") != null) {
				session.invalidate();
				path = "index.jsp";				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return path;
	}

	private String showBook(HttpServletRequest request, HttpServletResponse response) {
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
		return path;
	}

	private String findByTitle(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");
		Book book = null;
		try {
			book = BookDAOImpl.getInstance().findByTitle(isbn);
			request.setAttribute("book", book);
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return "book/bookList_result.jsp";
	}
	
}
