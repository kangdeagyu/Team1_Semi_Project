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
			String query = "select rcode, r_cid, r_pcode, rtitle, rcontent, rstar, rdate from review where r_pcode = ?";
			
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
			String query = "select rcode, r_cid, r_pcode, rtitle, rcontent, rstar, rdate from review where rcode = ?";
			
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
	
	
	
	
}
