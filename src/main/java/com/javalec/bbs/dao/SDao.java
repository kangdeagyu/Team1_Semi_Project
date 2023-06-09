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
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoestar");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int loginCheck(String cid, String cpw) {
		int result = 0;
		int count = 0;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection(); // sql 연결
			
			// 등록된 회원
			String query = "select count(cid) from Customer where cid = ? and cpw = ? and cdeletedate is null";
			ps = connection.prepareStatement(query);
			ps.setString(1, cid);
			ps.setString(2, cpw);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
			if(count > 0) {
				result =  1;	// 등록된 회원
			}
			if(count == 0) {
				result = 0;		// 등록되지 않은 회원
			}
			ps.close();
			rs.close();
			count = 0;
			
			// 탈퇴한 회원
			String query1 = "select count(cid) from Customer where cid = ? and cpw = ? and cdeletedate is not null";
			ps = connection.prepareStatement(query1);
			ps.setString(1, cid);
			ps.setString(2, cpw);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			if(count > 0) {
				result =  2;	// 탈퇴한 회원
			}
	
			ps.close();
			rs.close();
			count = 0;
			
			// 관리자
			String query3 = "select count(aid) from admin where aid = ? and apw = ?";
			ps = connection.prepareStatement(query3);
			ps.setString(1, cid);
			ps.setString(2, cpw);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			if(count > 0) {
				result =  3;	// 관리자
			}
//			if(count == 0) {
//				result = 0;
//			}
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
	
	public boolean join(String cid, String cpw, String cname, String telno, String caddress, String cemail) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean result = false;
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
			result = true;

		}catch (Exception e) {
			result = false;
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	
}// end

