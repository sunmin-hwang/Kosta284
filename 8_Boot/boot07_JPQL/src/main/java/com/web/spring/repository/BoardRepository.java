package com.web.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.spring.entity.Board;
import com.web.spring.entity.BoardIF;

public interface BoardRepository extends JpaRepository<Board, Long>{
	//자동적으로 findAll()..모든 게시글 받아오기
	/*
	 JPQL 사용
	 JPQL은 SQL과 비슷하지만 SQL이 아니다. 객체지향 언어이다.
	 JPQL에서 FROM절 뒤에는 테이블명이 아니라 엔티티 이름이 나온다!!
	 */
	
	//Board 엔티티는 board 테이블과 매핑된 객체이기 때문에 결과적으로 board테이블에 있는 모든것을 조회
	//@Query(value = "SELECT b FROM Board b")// 조인을 사용해야 한번에 연결된 정보를 함께 가져온다
	//@Query(value = "SELECT b FROM Board b JOIN b.custom c") //조인 사용
	@Query(value = "SELECT b FROM Board b JOIN FETCH b.custom") // 조인하면서 연관된 정보를 바로 받아오려면 fetch
	//@Query(value = "SELECT b FROM Board b JOIN FETCH Custom c ON b.custom.customId = c.customId") // 일반적인 조인구문
	List<Board> getBoards();
	
	// 전체 게시글 갯수를 반환
	@Query(value = "SELECT count(b) FROM Board b") // boardId는 상관없지만 board_id는 에러 발생
	Long getBoardCount();
	
	/*
	 SELECT * FROM board b, custom c, custom_role cr, role r
	 WHERE b.custom_id = c.custom_id
	 AND c.custom_id = cr.custom_id
	 AND cr.role_id = r.role_id
	 AND r.name="ROLE_ADMIN";
	*/
	//@Query(value = "SELECT b FROM Board b JOIN FETCH b.custom c JOIN FETCH c.roles r WHERE r.name = :roleName")
	@Query(value = "SELECT b, c FROM Board b JOIN b.custom c JOIN c.roles r WHERE r.name = :roleName")
	List<Board> getBoards(@Param("roleName") String roleName);
	
	@Query(value = "SELECT b.board_id, b.title, b.content, b.count, b.regDate, b.custom_id, c.name FROM board b, custom c WHERE b.custom_id=c.custom_id", nativeQuery = true)
	//@Query(value = "SELECT b, c.name FROM board b, custom c WHERE b.custom_id=c.custom_id", nativeQuery = true)
	List<Board> getBoardsNative();

	@Query(value = "SELECT b.board_id, b.title, b.custom_id, c.name FROM board b, custom c WHERE b.custom_id=c.custom_id", nativeQuery = true)
	List<BoardIF> getBoardsNative2();
}
