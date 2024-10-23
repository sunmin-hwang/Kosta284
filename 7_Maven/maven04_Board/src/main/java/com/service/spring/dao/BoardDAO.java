package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Board;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public static final String NS = "ns.sql.Board.";
	
	public int write(Board vo) {
		return sqlSession.insert(NS + "write", vo);
	}
	
	public String selectByNoForDate(int no) {
		return sqlSession.selectOne(NS + "selectByNoForDate", no);
	}
	
	public List<Board> getBoardList() {
		return sqlSession.selectList(NS + "getBoardList");
	}
	
	public Board showContent(int no) {
		return sqlSession.selectOne(NS + "showContent", no);
	}  
	
	public void deleteBoard(int no) {
		sqlSession.delete(NS + "deleteBoard", no);
	}
	
	public void updateCount(int no) {
		sqlSession.update(NS + "updateCount", no);
	}
	
	public void updateBoard(Board vo) {
		sqlSession.update(NS + "updateBoard", vo);
	}
}
