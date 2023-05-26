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
	
	public boolean loginCheck(String sid, String spw) {
		boolean result = false;
		int count = 0;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection(); // sql 연결
			String query = "select count(sid) from Customer where sid = ?, spw = ?";
			ps = connection.prepareStatement(query);
			ps.setString(1, sid);
			ps.setString(2, spw);
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
	
	
	
}
