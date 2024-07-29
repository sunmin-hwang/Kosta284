package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
/*
 서버주소
 계정명
 계정 비번
 이런 값들은 프로그램 코드에 노출되면 안되는 값들이다.
 프로그램에 이런 실제값이 들어가는것 == 하드코딩이라 한다.
 
 서버의 파편적인 정보를 외부에 모듈화(메타데이터화) 시켜야한다.
 */
public class JDBC4ProcessTest3 {
	
	public JDBC4ProcessTest3(){
		try {
			//2.
			Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			System.out.println("DB Connection Success....");
			
			/*
			//3.
			//INSERT
			String query = "INSERT INTO custom(id, name, address) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query); //미리 쿼리문이 컴파일만 먼저 수행됨...
			System.out.println("PreparedStatement 생성...");
			
			//4. 바인딩 및 쿼리문 실행
			ps.setInt(1, 444);
			ps.setString(2, "황선우");
			ps.setString(3, "서울");
			
			System.out.println(ps.executeUpdate() + " ROW INSERT OK~~!!");
			*/
			
			/*
			//DELETE...id값이 222인 사람을 삭제
			String query = "DELETE FROM custom WHERE id=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement 생성");
			ps.setInt(1, 222);
			
			System.out.println(ps.executeUpdate() + " ROW DELETE OK~~!!");
			*/
			
			/*
			//UPDATE...id값이 444인 사람의 정보를 수정..name(오상욱),address(광주)
			String query = "UPDATE custom SET name=?, address=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, "오상욱");
			ps.setString(2, "광주");
			ps.setInt(3, 444);
			
			System.out.println(ps.executeUpdate() + " ROW UPDATE OK~~!!");
			*/
			
			//조회하기
			String query = "SELECT id, name, address FROM custom";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id") + ", " +
			                       rs.getString("name") + ", " +
						           rs.getString(3));
			}
			
		} catch (SQLException e) {
			System.out.println("DB Connection Fail....");
		}
	}
	
	public static void main(String[] args) {
			new JDBC4ProcessTest3();
	}
	
	static {
		//1.
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공...");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패...");
		}
	}
}
