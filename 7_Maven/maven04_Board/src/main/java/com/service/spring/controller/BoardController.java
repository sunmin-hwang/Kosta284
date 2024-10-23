package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping("write.do")
	public String write(Board bvo, HttpSession session, Model model){
		Member mvo = (Member)session.getAttribute("mvo");
		if(mvo == null) return "redirect:index.jsp";
		String path = "Error";
		try {
			System.out.println(bvo);
			bvo.setMember(mvo);
			boardService.write(bvo);
			System.out.println(bvo);
			model.addAttribute("bvo", bvo);
			path = "board/show_content";
			return path;
		} catch (Exception e) {
			model.addAttribute("message", "게시글 작성 - 에러 발생");
			return path;
		}
	}
	
	@RequestMapping("list.do")
	public String list(Model model){
		String path = "Error";
		try {
			List<Board> list = boardService.getBoardList();
			model.addAttribute("list", list);
			path = "board/list";
			return path;
		} catch (Exception e) {
			model.addAttribute("message", "전체 게시글 - 에러 발생");
			return path;
		}
	}
	
	@RequestMapping("showContent.do")
	public String write(int no, HttpSession session, Model model){
		Member mvo = (Member)session.getAttribute("mvo");
		if(mvo == null) return "redirect:index.jsp";
		String path = "Error";
		try {
			boardService.updateCount(no);
			Board bvo = boardService.showContent(no);
			model.addAttribute("bvo", bvo);
			path = "board/show_content";
			return path;
		} catch (Exception e) {
			model.addAttribute("message", "특정 게시글 검색 - 에러 발생");
			return path;
		}
	}
	
	@RequestMapping("delete.do")
	public String doDelete(int no, Model model){
		String path = "Error";
		try {
			boardService.deleteBoard(no);
			path = "redirect:list.do";
			return path;
		} catch (Exception e) {
			model.addAttribute("message", "게시글 삭제 - 에러 발생");
			return path;
		}
	}
	
	@RequestMapping("updateView.do")
	public String update(int no, Model model){
		String path = "Error";
		try {
			Board bvo = boardService.showContent(no);
			model.addAttribute("bvo", bvo);
			path = "board/update";
			return path;
		} catch (Exception e) {
			model.addAttribute("message", "게시글 수정 - 에러 발생");
			return path;
		}
	}
	
	@RequestMapping("updateBoard.do")
	public String doUpdate(Board vo, Model model){
		String path = "Error";
		try {
			boardService.updateBoard(vo);
			Board bvo = boardService.showContent(vo.getNo());
			model.addAttribute("bvo", bvo);
			path = "board/show_content";
			return path;
		} catch (Exception e) {
			model.addAttribute("message", "게시글 수정 - 에러 발생");
			return path;
		}
	}
	
}
