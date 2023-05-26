package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class SDao {

	DataSource dataSource;
	
	public SDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean loginCheck(String cid, String cpw) {
		boolean result = false;
		int count = 0;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection(); // sql 연결
			String query = "select count(cid) from Customer where cid = ?, cpw = ?";
			ps = connection.prepareStatement(query);
			ps.setString(1, cid);
			ps.setString(2, cpw);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			if(count > 0) {
				result =  true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	
	}
	
	public void join(String cid, String cpw, String cname, String telno, String caddress, String cemail) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection(); // sql 연결
			String query = "insert into Customer (cid, cpw, cname, ctelno, caddress, cemail, cinsertdate) values (?,?,?,?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cid);
			preparedStatement.setString(2, cpw);
			preparedStatement.setString(3, cname);
			preparedStatement.setString(4, telno);
			preparedStatement.setString(5, caddress);
			preparedStatement.setString(6, cemail);
			
			preparedStatement.executeUpdate();
			

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
}// end

