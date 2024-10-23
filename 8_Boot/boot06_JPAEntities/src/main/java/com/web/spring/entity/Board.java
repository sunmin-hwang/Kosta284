package com.web.spring.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Board {
	@Id
	@Column(name = "board_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardId;
	
	@Column(length = 100)
	private String title;
	
	@Lob
	private String content;
	
	private int count;
	
	@CreationTimestamp
	private LocalDateTime regDate;

	//추가
	//Custom...
	@ManyToOne(fetch = FetchType.LAZY) //fetch의 default FetchType.EAGER --> preloading
	@JoinColumn(name = "custom_id")
	private Custom custom;

	/*
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", title=" + title + ", content=" + content + ", count=" + count
				+ ", regDate=" + regDate + ", custom=" + custom + "]";
	}
	*/
	
	//연관된 객체는 제외
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", title=" + title + ", content=" + content + ", count=" + count
				+ ", regDate=" + regDate + "]";
	}
	
}
