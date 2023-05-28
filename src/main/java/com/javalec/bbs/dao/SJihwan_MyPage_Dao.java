package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.SJihwan_MyPage_Dto;

public class SJihwan_MyPage_Dao {
	
	
	// Field
	
		DataSource datasource;
		
		
		
		
		// Constructor
		
		public SJihwan_MyPage_Dao() {
			// TODO Auto-generated constructor stub
			try {
				Context context = new InitialContext();
				datasource = (DataSource) context.lookup("java:comp/env/jdbc/shoestar");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// Method
		public void modify(String cpw, String cname, String ctelno,  String caddress, String cemail, String cid) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				connection = datasource.getConnection();
				String query = "update customer set cpw=?, cname=?, ctelno=?, caddress=?, cemail=?, where cid= ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, cpw);
				preparedStatement.setString(2, cname);
				preparedStatement.setString(3, ctelno);
				preparedStatement.setString(4, caddress);
				preparedStatement.setString(5, cemail);
				preparedStatement.setString(6, cid);
				preparedStatement.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(preparedStatement !=null) preparedStatement.close();
					if(connection !=null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
	}
	
		public SJihwan_MyPage_Dto contentView(String cid) {
			SJihwan_MyPage_Dto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = datasource.getConnection();
				String query = "select * from customer where cid = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(cid));
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					String cpw= resultSet.getString("cpw");
					String cname= resultSet.getString("cname");
					String ctelno= resultSet.getString("ctelno");
					String caddress= resultSet.getString("caddress");
					String cemail=resultSet.getString("cemail");
					
					dto = new SJihwan_MyPage_Dto(cid, cpw, cname, ctelno, caddress, cemail);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(resultSet !=null) resultSet.close();
					if(preparedStatement !=null) preparedStatement.close();
					if(connection !=null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return dto;
		}
			
		
		public void delete(String cid) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				connection = datasource.getConnection();
				String query = "delete from customer where cid = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, cid);
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
					if (connection != null)
						connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
