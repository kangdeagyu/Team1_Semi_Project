package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.Kkg_Review_Dto;

public class Kkg_Review_Dao {

	DataSource dataSource;

	
	
	public Kkg_Review_Dao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoestar");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

	
	
	
	public ArrayList<Kkg_Review_Dto> reviewList(int pcode){
		
		ArrayList<Kkg_Review_Dto> dtos = new ArrayList<Kkg_Review_Dto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection =dataSource.getConnection();
			String query = "select rcode, r_cid, r_pcode, rtitle, rcontent, rstar, rdate from review where r_pcode = ? AND rddate < DATE_ADD(rdate, INTERVAL 2 SECOND)";
			
			System.out.println("pcode : "+pcode);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, pcode);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int rcode = resultSet.getInt("rcode");
				String r_cid = resultSet.getString("r_cid");
				int r_pcode = resultSet.getInt("r_pcode");
				String rtitle = resultSet.getString("rtitle");
				String rcontent = resultSet.getString("rcontent");
				int rstar = resultSet.getInt("rstar");
				Timestamp rdate = resultSet.getTimestamp("rdate");
				System.out.println("resultSet.getInt(rcode) : "+resultSet.getInt("rcode"));
				
				Kkg_Review_Dto dto = new Kkg_Review_Dto(rcode, r_cid, r_pcode, rtitle, rcontent, rstar, rdate);
				dtos.add(dto);
	
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("파이널리 실행 전");
			
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("파이널리 실행 후");
			}
		}
	
		return dtos;
	

	}//reviewList
	
	
	
	public Kkg_Review_Dto review_view(int r_code){
		Kkg_Review_Dto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection =dataSource.getConnection();
			String query = "select rcode, r_cid, r_pcode, rtitle, rcontent, rstar, rdate from review where rcode = ? ";
			
			System.out.println("rcode : "+r_code);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, r_code);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int rcode = resultSet.getInt("rcode");
				String r_cid = resultSet.getString("r_cid");
				int r_pcode = resultSet.getInt("r_pcode");
				String rtitle = resultSet.getString("rtitle");
				String rcontent = resultSet.getString("rcontent");
				int rstar = resultSet.getInt("rstar");
				Timestamp rdate = resultSet.getTimestamp("rdate");
				System.out.println("resultSet.getInt(rcode) : "+resultSet.getInt("rcode"));
				
				dto = new Kkg_Review_Dto(rcode, r_cid, r_pcode, rtitle, rcontent, rstar, rdate);
		
	
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("파이널리 실행 전");
			
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("파이널리 실행 후");
			}
		}
	
			
		return dto;
	}
	
	public boolean review_insert(String cid, int pcode, String rtitle, String rcontent, int rstar) {
		//			boolean rs  = dao.review_insert(cid, pcode, rtitle, rcontent, rstar);
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection =dataSource.getConnection();
			String sql = "insert into review (r_cid, r_pcode, rtitle, rcontent, rstar, rdate,rddate) values (?,?,?,?,?,now(),now()) ";
			
			System.out.println("rtitle : "+rtitle);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cid);
			preparedStatement.setInt(2, pcode);
			preparedStatement.setString(3, rtitle);
			preparedStatement.setString(4, rcontent);
			preparedStatement.setInt(5, rstar);
			System.out.println("입력 완료" + rtitle);
			preparedStatement.executeUpdate();
			
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			System.out.println("파이널리 실행 전");
			return false;
		} finally {
			try {
				//if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("파이널리 실행 후");
			}
		}
		

	} //review insert
	
	
	public boolean review_update(String cid, String rtitle, String rcontent, int rstar, int rcode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection =dataSource.getConnection();
			String sql = "update review set rtitle = ?, rcontent = ?, rstar = ?, rdate= now() where rcode = ?";
			
			System.out.println("rtitle : "+rtitle);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, rtitle);
			preparedStatement.setString(2, rcontent);
			preparedStatement.setInt(3, rstar);
			preparedStatement.setInt(4, rcode);
			System.out.println("수정 완료" + rtitle);
			preparedStatement.executeUpdate();
			
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			System.out.println("파이널리 실행 전");
			return false;
		} finally {
			try {
				//if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("파이널리 실행 후");
			}
		}
		
	}//review_update
	
	public boolean review_delete(int rcode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection =dataSource.getConnection();
			String sql = "update review set rddate= now() where rcode = ?";
			
			System.out.println("rcode : "+rcode);
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, rcode);
			System.out.println("수정 완료" + rcode);
			preparedStatement.executeUpdate();
			
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			System.out.println("파이널리 실행 전");
			return false;
		} finally {
			try {
				//if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("파이널리 실행 후");
			}
		}
		
	}//review_delete
	
	
	
	
	
} //end
