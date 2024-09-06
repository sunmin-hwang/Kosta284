package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import web.servlet.vo.Book;

public interface BookDAO {
	public Connection getConnection() throws SQLException;
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	void registerBook(Book vo) throws SQLException;
	ArrayList<Book> showBooks(String searchOption, String searchText) throws SQLException;
	Book findByTitle(String title) throws SQLException;
}
