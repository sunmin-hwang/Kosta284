package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.service.PhoneService;

@Controller
public class PhoneController {
	@Autowired
	private PhoneService phoneService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:index.jsp";
	}
	
	@GetMapping("/login.do")
	public String loginForm() {
		return "Login";
	}
	
	@GetMapping("/regPhone.do")
	public String getRegPhone(Model model) {
		model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록");
		return "PhoneReg";
	}
	
	@PostMapping("/login.do")
	public String doLogin(UserInfo pvo, HttpSession session, Model model){
		String path = "Error";
		try {
			UserInfo loginUser = phoneService.select(pvo);
			if(loginUser!=null) {
				session.setAttribute("loginUser", loginUser);
				path = "redirect:searchPhone.do";
			} else {
				path = "Login";
			}
			return path;
		} catch (Exception e) {
			model.addAttribute("message", "로그인 작업 - 에러 발생");
			model.addAttribute("title", "핸드폰 관리 - 에러");
			return path;
		}
	}
	
	@PostMapping("savePhone.do")
	public String doRegPhone(Phone pvo, HttpSession session, Model model){
		UserInfo loginUser = (UserInfo)session.getAttribute("loginUser");
		if(loginUser == null) return "redirect:index.jsp";
		String path = "Error";
		String title = "핸드폰 등록 - 에러 발생";
		try {
			phoneService.insert(pvo);
			title = "핸드폰 관리 - 핸드폰 저장 성공";
			model.addAttribute("title", title);
			path = "Result";
			return path;
		} catch (Exception e) {
			model.addAttribute("message", title);
			model.addAttribute("title", "핸드폰 관리 - 에러");
			return path;
		}
	}
		
	@GetMapping("/searchPhone.do")
	public String doList(Model model){
		String path = "Error";
		String title = "핸드폰 목록 - 에러 발생";
		try {
			List<Phone> phones = phoneService.select();
			title = "핸드폰 관리 - 핸드폰 목록 리스트";
			model.addAttribute("title", title);
			model.addAttribute("phones", phones);
			path = "PhoneList";
			return path;
		} catch (Exception e) {
			model.addAttribute("message", title);
			model.addAttribute("title", "핸드폰 관리 - 에러");
			return path;
		}
	}
	
	@GetMapping("/detail.do")
	public String detail(Phone pvo, Model model){
		String path = "Error";
		String title = "핸드폰 상세조회 - 에러 발생";
		try {
			Phone phone = phoneService.select(pvo);
			title = "핸드폰 관리 - 핸드폰 세부정보";
			model.addAttribute("title", title);
			model.addAttribute("phone", phone);
			path = "PhoneView";
			return path;
		} catch (Exception e) {
			model.addAttribute("message", title);
			model.addAttribute("title", "핸드폰 관리 - 에러");
			return path;
		}
	}
	
	@PostMapping("deleteAjax.do")
	@ResponseBody
	public String doAjaxDelete(@RequestParam List<String> num, Model model){
		String path = "Error";
		String title = "핸드폰 삭제 - 에러 발생";
		try {
			phoneService.delete(num);
			return "";
		} catch (Exception e) {
			model.addAttribute("message", title);
			model.addAttribute("title", "핸드폰 관리 - 에러");
			return path;
		}
	}
}
