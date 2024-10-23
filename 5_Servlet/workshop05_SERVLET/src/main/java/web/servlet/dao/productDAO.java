package web.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.servlet.vo.Product;

public class productDAO {
	private DataSource ds;
	
	private static productDAO dao = new productDAO();
	private productDAO() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
		}
	}
	public static productDAO getInstance() {
		return dao;
	}
	
	public Connection gerConnect() throws SQLException {
		return ds.getConnection();
	}

	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}
	
	public void register(Product vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = gerConnect();
			String query = "INSERT INTO product(name, price, detail) VALUES(?,?,?)";
			
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPrice());
			ps.setString(3, vo.getDetail());
			
			ps.executeUpdate();
		} finally {
			closeAll(ps, conn);
		}
	}
	
	public ArrayList<Product> findProducts() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<Product> list = new ArrayList<Product>();
		
		try {
			conn = gerConnect();
			String query = "SELECT product_no, name, price, detail FROM product";
			
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Product(rs.getInt("product_no"), rs.getString("name"), rs.getInt("price"), rs.getString("detail")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
		
	}
}
