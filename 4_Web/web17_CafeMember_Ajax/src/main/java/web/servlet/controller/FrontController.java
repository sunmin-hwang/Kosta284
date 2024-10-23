package web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.sevlet.model.Member;
import web.sevlet.model.MemberDAOImpl;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontController() {
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPrecess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPrecess(request, response);
	}
	
	protected void doPrecess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성...한글처리 안해도 된다...Filter등록되어져 있다.
		//command값 받아온다..
		String command = request.getParameter("command");
		String path = "index.html";
		
		if(command.equals("find")) {
			path = find(request, response);
		} else if(command.equals("login")) {
			path = login(request, response);
		} else if(command.equals("register")) {
			path = register(request, response);
		} else if(command.equals("showAll")) {
			path = showAll(request, response);
		} else if(command.equals("logout")) {
			path = logout(request, response);
		} else if(command.equals("idCheck")) {
			idCheck(request, response);
			return;
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	private String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		String path = "find_fail.jsp";
		try {
			Member rvo = MemberDAOImpl.getInstance().findByMember(id);
			if(rvo!=null) {
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";
			}
			
		} catch (SQLException e) {
			
		}
		return path;
	}

	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass=  request.getParameter("password");
		String path = "index.html";
		
		try {
			Member rvo = MemberDAOImpl.getInstance().login(id, pass);
			HttpSession session = request.getSession();
			if(rvo!=null) {
				session.setAttribute("vo", rvo);
				System.out.println("LoginServlet..JSESSIONID ::: " + session.getId());
				path = "login_result.jsp";
			}
		} catch (SQLException e) {
			System.out.println(e);
			path="login_fail.jsp";
		}
		return path;
	}
	
	private String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		Member pvo = null;
		
		if(name.equals("")&&address.equals("")) {
			pvo = new Member(id, password);			
		}else {
			pvo = new Member(id, password, name, address);
		}
		
		String path = "index.html";
		
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			request.setAttribute("vo", pvo);
			path = "register_result.jsp";
		} catch (SQLException e) {
		}
		return path;
	}

	private String showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Member> list = new ArrayList<Member>();
		
		String path = "index.html";
		
		try {
			list = MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
			path = "allView.jsp";
		} catch (SQLException e) {
		}
		return path;
	}
	
	private String logout(HttpServletRequest request, HttpServletResponse response) {
		String path = "login.jsp";
		try {
			//세션을 죽이는 로직..logout.jsp
			HttpSession session = request.getSession();
			if(session.getAttribute("vo") != null) {
				session.invalidate();
				path = "logout.jsp";				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return path;
	}

	private void idCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		
		String id = request.getParameter("id");
		
		boolean find = false;
		try {
			find = MemberDAOImpl.getInstance().idExist(id);
		} catch (SQLException e) {
			
		}
		
		out.print(find);
		
	}

}
