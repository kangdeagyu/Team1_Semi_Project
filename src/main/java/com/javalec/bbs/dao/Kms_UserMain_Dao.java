package com.javalec.bbs.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.Kms_UserMain_Dto;

public class Kms_UserMain_Dao {

	DataSource dataSource;
	
	public Kms_UserMain_Dao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoestar");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Kms_UserMain_Dto> list(){
		ArrayList<Kms_UserMain_Dto> dtos = new ArrayList<Kms_UserMain_Dto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select pimage, pimagename, pcode, pprice, pname from product";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String Pimage = resultSet.getString(1);
				String Pimagename = resultSet.getString(2);
				int Pcode = resultSet.getInt(3);
				int Pprice = resultSet.getInt(4);
				String Pname = resultSet.getString(5);

				
				
				Kms_UserMain_Dto dto = new Kms_UserMain_Dto(Pimage, Pimagename, Pcode, Pprice, Pname);
				dtos.add(dto);
				
			
				}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
		
	} // list
	
	public Kms_UserMain_Dto contentView(String pname) {
		Kms_UserMain_Dto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select pimage, pcode, pname, pprice from product where pname = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pname);
			rs = preparedStatement.executeQuery();
			
			if(rs.next()) { // 한 줄 짜리니까 while 말고 if 쓰자
				int Pcode = rs.getInt("pcode");
				String Pimage = rs.getString("pimage");
				String Pname = rs.getString("pname");
				int Pprice = rs.getInt("pprice");
				
				dto = new Kms_UserMain_Dto(Pcode, Pimage, Pname, Pprice);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;

	} // content view
	
	public void basketAction(String cid, String pcode, int qty) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into basket (b_cid, b_pcode, bqty, bdate) values (?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cid);
			preparedStatement.setString(2, pcode);
			preparedStatement.setInt(3, qty);
			
			preparedStatement.executeUpdate();
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	} // 주소록 작성
	
	public ArrayList<Kms_UserMain_Dto> search1(String list, String content){
		ArrayList<Kms_UserMain_Dto> dtos = new ArrayList<Kms_UserMain_Dto>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select pimage, pimagename, pcode, pprice, pname from product";
			String Where2 = " where " + list + " like ?";
			ps = connection.prepareStatement(query + Where2);
			ps.setString(1, "%" + content + "%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String Pimage = rs.getString(1);
				String Pimagename = rs.getString(2);
				int Pcode = rs.getInt(3);
				int Pprice = rs.getInt(4);
				String Pname = rs.getString(5);

				
				
				Kms_UserMain_Dto dto = new Kms_UserMain_Dto(Pimage, Pimagename, Pcode, Pprice, Pname);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
	} // list 출력
}


