package com.web.spring.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Member {
	@Id//유일한 값..PK
	@Column(name="member_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberNo;

	@Column(unique = true)
	private String id;
	
	private String pwd;
	
	@Column(length = 20)
	private String name;

	private String address;
		
	@CreationTimestamp
	private LocalDateTime regDate;
	
	private String role;

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", address="
				+ address + ", regDate=" + regDate + ", role=" + role + "]";
	}
	
}
