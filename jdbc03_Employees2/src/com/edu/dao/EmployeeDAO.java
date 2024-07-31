package com.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.edu.exception.DuplicateNumException;
import com.edu.vo.Employee;

import config.ServerInfo;

public class EmployeeDAO {
	private static EmployeeDAO dao = new EmployeeDAO();

	private EmployeeDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 로딩 실패");
		}
	}
	
	public static EmployeeDAO getinstance(){
		return dao;
	} 
	
	public Connection getConnect() throws SQLException {
		System.out.println("DB연결 성공");
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
	
	public void insertEmployee(Employee emp) {
		String query = "INSERT INTO employee(num, name, salary, address) VALUES(?,?,?,?)";
		try (Connection conn = getConnect(); PreparedStatement ps = conn.prepareStatement(query)){				
			ps.setInt(1, emp.getNum());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			ps.setString(4, emp.getAddress());
					
			ps.executeUpdate();		
		} catch (SQLIntegrityConstraintViolationException e) { //중복오류
			System.out.println(e.getMessage());
		} catch (SQLException e) { // 문법오류
			System.out.println(e);
		}
	}
	
	public void removeEmployee(int num) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = getConnect();
		String query = "DELETE FROM employee WHERE num=?";
		ps = conn.prepareStatement(query);
		
		ps.setInt(1, num);
		
		ps.executeUpdate();
		
		closeAll(ps, conn);
	}
	
	public void updateEmployee(Employee emp) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = getConnect();
		String query = "UPDATE employee SET name=?, salary=?, address=? WHERE num=?";
		ps = conn.prepareStatement(query);
		
		ps.setString(1, emp.getName());
		ps.setDouble(2, emp.getSalary());
		ps.setString(3, emp.getAddress());
		ps.setInt(4, emp.getNum());
		
		ps.executeUpdate();
		
		closeAll(ps, conn);
	}
	
	public List<Employee> selectEmployee() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Employee> employees = new ArrayList<Employee>();
		
		conn = getConnect();
		String query = "SELECT num, name, salary, address FROM employee";
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			employees.add(new Employee(rs.getInt("num"),
					          rs.getString("name"),
					          rs.getDouble(3),
					          rs.getString(4))); 
		}
		
		closeAll(rs, ps, conn);
		
		return employees;
	}
	
	public Employee selectEmployee(int num) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee employee = null;
		
		conn = getConnect();
		String query = "SELECT num, name, salary, address FROM employee WHERE num=?";
		ps = conn.prepareStatement(query);
		
		ps.setInt(1, num);
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			employee = new Employee(num,
					          rs.getString("name"),
					          rs.getDouble(3),
					          rs.getString(4)); 
		}
		
		closeAll(rs, ps, conn);
		
		return employee;
	}
	
}
