package com.web.spring.entity;

import java.time.LocalDateTime;

/*
 b.board_id, b.title, b.custom_id, c.name
 이 컬럼들을 읽어오는 템플릿 기능을 Gette로 만들어 놓는다.
 
 Spring DATE JPA 해당 템플릿을 바탕으로 구현클래스는 생성해준다
 */
public interface BoardIF {
	Long getBoardId();
	String getTitle();
	String getContent();
	String getName();
	LocalDateTime getRegDate();
	int getCount();
	String getCustomId();
}
