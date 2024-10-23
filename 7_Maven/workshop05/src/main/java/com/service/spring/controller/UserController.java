package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.User;
import com.service.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("memberLogin.do")
	public ModelAndView login(User user, HttpServletRequest request) throws Exception{
		
		System.out.println("getUser Before : " + user);
		
		User rvo = userService.getUser(user);
		
		System.out.println("getUser After : " + rvo);
		
		String path = "index.jsp";
		String msg = "아이디 혹은 패스워드가 틀렸습니더";
		
		if(rvo!=null) {
			request.getSession().setAttribute("user", rvo);
			msg = "성공적으로 로그인 됐습니다.";
		}
		request.setAttribute("msg", msg);
		return new ModelAndView("redirect:" + path);
	}
	
	@RequestMapping("memberLogout.do")
	public ModelAndView logout(HttpSession session) throws Exception{
		if(session.getAttribute("user") != null)
		session.invalidate();
		
		return new ModelAndView("redirect:index.jsp");
	}

}















