package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.vo.User;

@Controller
public class FormController {
	//html의 폼의 값이 자동으로 컨트롤러에 바인딩..
	@RequestMapping("/form.do")
	public ModelAndView form(User user) {
		/*
		 1. 폼값 받아서
		 	String name = request.getParameter("userName");
		 	String addr = request.getParameter("userAddr");
		 	String id = request.getParameter("id");
		 2. pvo 생성
		 	User pvo = new User();
		 	pvo.setUserName(name);
		 	pvo.setUserAddr(userAddr);
		 	pvo.setId(id);
		 	pvo.setPassword(password);
		 */
		return new ModelAndView("result", "info", user);
	}
}
