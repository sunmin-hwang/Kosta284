package broker.twotier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.InvalidTransactionException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;

public class Database implements DatabaseTemplate {
	private static Database db = new Database("127.0.0.1");
	
	private Database(String serverIp){
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공..");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패..");
		}
	}
	
	public static Database getInstance() {
		return db;
	}
	

	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("디비 연결 성공...");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}
	
	//존재유무 확인하는 비지니스 로직..
	private boolean isExist(String ssn, Connection conn) throws SQLException{
		String query = "SELECT ssn FROM customer WHERE ssn=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, ssn);
		
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			if(!isExist(cust.getSsn(), conn)) {
				String query = "INSERT INTO customer(ssn, cust_name, address) VALUES(?,?,?)";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				
				System.out.println(ps.executeUpdate() + " 명 INSERT OK~~!!..addCustomer");
			}else throw new DuplicateSSNException("고객님은 이미 회원이십니다.");
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			if(isExist(ssn, conn)) {
				String query = "DELETE FROM customer WHERE ssn=?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, ssn);
				
				System.out.println(ps.executeUpdate() + " 명 DELETE OK~~!!..deleteCustomer");
			}else throw new RecordNotFoundException("고객님의 정보가 존재하지 않습니다.");
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			if(isExist(cust.getSsn(), conn)) {
				String query = "UPDATE customer SET cust_name=?, address=? WHERE ssn=?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getName());
				ps.setString(2, cust.getAddress());
				ps.setString(3, cust.getSsn());
				
				System.out.println(ps.executeUpdate() + " 명 UPDATE OK~~!!..updateCustomer");
			}else throw new RecordNotFoundException("고객님의 정보가 존재하지 않습니다.");
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<SharesRec> getPortfolio(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<SharesRec> shares = new ArrayList<SharesRec>();
		
		try {
			conn = getConnect();
			String query = "SELECT ssn, symbol, quantity FROM shares WHERE ssn=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, ssn);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				shares.add(new SharesRec(rs.getString("ssn"), rs.getString("symbol"), rs.getInt("quantity")));
			}

			return shares;
			
		} finally {			
			closeAll(rs, ps, conn);
		}
	}

	@Override
	public CustomerRec getCustomer(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerRec cus = null;
		
		try {
			conn = getConnect();
			String query = "SELECT ssn, cust_name, address FROM customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, ssn);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				ArrayList<SharesRec> shares = getPortfolio(ssn);
				if(shares.isEmpty()) {
					cus = new CustomerRec(ssn, rs.getString("cust_name"), rs.getString("address"));
				}else {
					cus = new CustomerRec(ssn, rs.getString("cust_name"), rs.getString("address"), shares);				
				}
			}
			
			return cus;			
		} finally {
			closeAll(rs, ps, conn);
		}
	}

	@Override
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CustomerRec> customers = new ArrayList<CustomerRec>();
		
		try {
			conn = getConnect();
			String query = "SELECT ssn, cust_name, address FROM customer";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ArrayList<SharesRec> shares = getPortfolio(rs.getString("ssn"));
				if(shares.isEmpty()) {
					customers.add(new CustomerRec(rs.getString("ssn"), rs.getString("cust_name"), rs.getString("address")));
				}else {
					customers.add(new CustomerRec(rs.getString("ssn"), rs.getString("cust_name"), rs.getString("address"), shares));				
				}
			}
			
			return customers;		
		} finally {
			closeAll(rs, ps, conn);
		}
	}

	@Override
	public ArrayList<StockRec> getAllStocks() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<StockRec> stocks = new ArrayList<StockRec>();
		
		try {
			conn = getConnect();
			String query = "SELECT symbol, price FROM stock";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				stocks.add(new StockRec(rs.getString("symbol"), rs.getInt("price")));
			}
			
			return stocks;
		} finally {
			closeAll(rs, ps, conn);
		}
		
	}

	@Override
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnect();
			ArrayList<SharesRec> shares = getPortfolio(ssn);
			String query = null;
			
			if(!shares.isEmpty() && shares.stream().filter(i->i.getSymbol().equals(symbol)).count()!=0) {
				query = "UPDATE shares SET quantity=quantity+? WHERE ssn=? AND symbol=?";
			}else {
				query = "INSERT INTO shares(quantity,ssn,symbol) VALUES(?,?,?)";
			}
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, quantity);
			ps.setString(2, ssn);
			ps.setString(3, symbol);
			
			System.out.println(ps.executeUpdate() + " 명 주식 거래 OK~~!!..buyShares");	
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void sellShares(String ssn, String symbol, int quantity)
			throws SQLException, InvalidTransactionException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			ArrayList<SharesRec> shares = getPortfolio(ssn);
			int num = 1;
			String query = null;
			
			SharesRec share = shares.stream()
					                 .filter(i->i.getSymbol().equals(symbol))
					                 .findAny()
					                 .orElseThrow(()-> new RecordNotFoundException("해당 주식의 거래 정보가 존재하지 않습니다."));
			
			
			if(share.getQuantity() > quantity) {					
				query = "UPDATE shares SET quantity=quantity-? WHERE ssn=? AND symbol=?";
				ps = conn.prepareStatement(query);
					
				ps.setInt(num++, quantity);
			} else if(share.getQuantity() == quantity) {					
				query = "DELETE FROM shares WHERE ssn=? AND symbol=?";
				ps = conn.prepareStatement(query);
			} else throw new InvalidTransactionException("보유한 주식의 양보다 많은 거래량입니다.");
			
			ps.setString(num++, ssn);
			ps.setString(num, symbol);
			
			System.out.println(ps.executeUpdate() + " 명 주식거래 OK~~!!..sellShares");
				
		} finally {
			closeAll(ps, conn);
		}
	}

//	public static void main(String[] args) throws SQLException {//단위테스트용...
//		Database data = Database.getInstance();
//		try {
//			data.addCustomer(new CustomerRec("555-555", "hwang", "울서"));
//		} catch (SQLException | DuplicateSSNException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			data.deleteCustomer("555-555");
//		} catch (SQLException | RecordNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			data.updateCustomer(new CustomerRec("555-555", "Hwaaang", "서울"));
//		} catch (SQLException | RecordNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		data.getPortfolio("111-111").forEach(System.out::println);
//		
//		System.out.println(data.getCustomer("111-111"));
//		
//		data.getAllCustomers().forEach(System.out::println);
//		
//		data.getAllStocks().forEach(System.out::println);
//		
//		data.buyShares("111-111", "JDK", 10);
//		data.buyShares("111-112", "TMAs", 15);
//		
//		data.getPortfolio("111-111").forEach(System.out::println);
//		data.getPortfolio("111-112").forEach(System.out::println);
//		
//		try {
//			data.sellShares("111-111", "DUKE", 5);
//		} catch (SQLException | InvalidTransactionException | RecordNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		data.getPortfolio("111-111").forEach(System.out::println);
//		
//		try {
//			data.sellShares("111-111", "DUKE", 5);
//		} catch (SQLException | InvalidTransactionException | RecordNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		data.getPortfolio("111-111").forEach(System.out::println);
//		
//		try {
//			data.sellShares("111-111", "DUKE", 6);
//		} catch (SQLException | InvalidTransactionException | RecordNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		data.getPortfolio("111-111").forEach(System.out::println);
//	}
}
