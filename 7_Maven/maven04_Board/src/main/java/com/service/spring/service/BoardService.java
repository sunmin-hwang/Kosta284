package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.BoardDAO;
import com.service.spring.domain.Board;

@Service
public class BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
	public int write(Board vo) {
		int row=boardDAO.write(vo);
		
		String date=boardDAO.selectByNoForDate(vo.getNo());
		vo.setWriteDate(date);
		
		return row;
	}
	
	public String selectByNoForDate(int no) {
		return boardDAO.selectByNoForDate(no);
	}
	
	public List<Board> getBoardList() {
		return boardDAO.getBoardList();
	}
	
	public Board showContent(int no) {
		return boardDAO.showContent(no);
	}  
	
	public void deleteBoard(int no) {
		boardDAO.deleteBoard(no);
	}
	
	public void updateCount(int no) {
		boardDAO.updateCount(no);
	}
	
	public void updateBoard(Board vo) {
		boardDAO.updateBoard(vo);
	}
}
