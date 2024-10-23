package com.web.spring.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //db테이블과 매핑괴는 객체...자동으로 테이블 명은 custom
@Table(name="custom") //엔터티 클래스 명과 테이블 명이 다를때 지정
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Custom {
	@Id//유일한 값..PK
	@Column(name="custom_id")//안해도 잡힘
	@GeneratedValue(strategy = GenerationType.IDENTITY)// auto increment
	private Integer customId;
	
	@Column(length = 500)
	private String password;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 200)
	private String email;
	
	@CreationTimestamp
	private LocalDateTime regDate;
}
