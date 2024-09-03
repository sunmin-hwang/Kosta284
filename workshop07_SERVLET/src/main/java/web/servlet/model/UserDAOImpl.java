package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.servlet.vo.User;

public class UserDAOImpl implements UserDAO{
	private DataSource ds;
	
	private static UserDAOImpl dao = new UserDAOImpl();
	private UserDAOImpl() {
		//Naming Service 작업을 진행..
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
		}
	}
	public static UserDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	@Override
	public User login(String userId, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User vo = null;
		try {
			conn = getConnection();
			String query = "SELECT 	userId, password, name, email FROM userinfo WHERE userid = ? AND password = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, userId);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()) vo = new User(userId, password, rs.getString("name"), rs.getString("email"));
		} finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}

}
