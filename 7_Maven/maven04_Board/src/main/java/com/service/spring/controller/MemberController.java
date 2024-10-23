package com.service.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Member;
import com.service.spring.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("login.do")
	public String doLogin(Member pvo, HttpSession session, Model model){
		String path = "Error";
		try {
			Member rvo = memberService.selectUser(pvo);
			if(rvo!=null) {
				session.setAttribute("mvo", rvo);
				path = "member/login_result";
			}
			return path;
		} catch (Exception e) {
			model.addAttribute("message", "로그인 작업 - 에러 발생");
			return path;
		}
	}
	
	@RequestMapping("logout.do")
	public String doLogout(HttpSession session){
		Member mvo = (Member) session.getAttribute("mvo");
		if(mvo != null) session.invalidate();
		return "redirect:index.jsp";
	}
}
