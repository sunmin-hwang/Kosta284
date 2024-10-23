package com.service.spring;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;

public class DIUnitTest {
	ApplicationContext factory = 
			new ClassPathXmlApplicationContext("/beans/application.xml");
	BoardService service = (BoardService)factory.getBean("boardService");
	
	@Test
	public void write() throws Exception{
		Member m = new Member();
		m.setId("kosta");
		Board b = new Board("kosta", "kosta의 게시판 글입니다. 안녕하세요", m);
		
		service.write(b);
	}
	
	@Test
	public void getBoardList() throws Exception{
		List<Board> list = service.getBoardList();
		for(Board b : list)
			System.out.println(b);
	}
	
	@Test
	public void showContent() throws Exception{
		System.out.println(service.showContent(1));
	}
	
	@Test
	public void selectByNoForDate() throws Exception{
		System.out.println(service.selectByNoForDate(1));
	}
}
