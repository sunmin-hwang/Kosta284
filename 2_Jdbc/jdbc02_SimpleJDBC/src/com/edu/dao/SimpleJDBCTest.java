package com.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.vo.Custom;

import config.ServerInfo;

public class SimpleJDBCTest {
	public SimpleJDBCTest() throws Exception {
		//1. 드라이버 로딩.
		Class.forName(ServerInfo.DRIVER_NAME);
	}
	
	//고정적으로 각 메소드마다 반복되는 로직을 공통로직으로 정의...connection, close
	public Connection getConnect() throws SQLException{
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{
		if(rs != null) rs.close();
		closeAll(ps, conn);
	}
	
	public void addCustom(Custom c) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		
		//insert into...
		//1. 디비 연결
		conn = getConnect();
		//2. PreparedStatement 생성
		String query = "INSERT INTO custom(id, name, address) VALUES(?, ?, ?)";
		ps = conn.prepareStatement(query);
		//3. 바인딩
		ps.setInt(1, c.getId());
		ps.setString(2, c.getName());
		ps.setString(3, c.getAddress());
		//4. 쿼리문 실행
		ps.executeUpdate();
		System.out.println(c.getName() + " 추가완료");
		
		closeAll(ps, conn);
		
	}
	
	public Custom getCustom(int id) throws Exception{ //Business Logic(중요한 로직...DB Access Logic)
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Custom c = null;
		
		//select where
		//1. 디비 연결
		conn = getConnect();
		//2. PreparedStatement 생성
		String query = "SELECT id, name, address FROM custom WHERE id=?";
		ps = conn.prepareStatement(query);
		//3. 바인딩
		ps.setInt(1, id);
		//4. 쿼리문 실행
		rs = ps.executeQuery();
		if(rs.next()) {
			c = new Custom(id, rs.getString("name"), rs.getString("address"));			
		}
		closeAll(rs, ps, conn);
		
		return c;		
	}
	
	public List<Custom> getCustom() throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Custom> list = new ArrayList<Custom>();
		
		//select where
		//1. 디비 연결
		conn = getConnect();
		//2. PreparedStatement 생성
		String query = "SELECT id, name, address FROM custom";
		ps = conn.prepareStatement(query);
		//3. 쿼리문 실행
		rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new Custom(rs.getInt("id"), rs.getString("name"), rs.getString("address")));			
		}
		closeAll(rs, ps, conn);
		return list;
	}
	
	public static void main(String[] args) throws Exception {
		SimpleJDBCTest dao = new SimpleJDBCTest();
		//dao.addCustom(new Custom(555, "Blake", "LA"));
		System.out.println(dao.getCustom(111));
		dao.getCustom().forEach(System.out::println);
	}
}
