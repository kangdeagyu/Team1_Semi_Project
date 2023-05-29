package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.JDto;

public class JDao {

	
	DataSource dataSource;
	
	public JDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoestar");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<JDto> list(){
		ArrayList<JDto> dtos = new ArrayList<JDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection(); // sql 연결
			String query = "select cid, cname, ctelno, caddress, cemail from Customer";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String cid = resultSet.getString("cid");
				String cname = resultSet.getString("cname");
				String ctelno = resultSet.getString("ctelno");
				String caddress = resultSet.getString("caddress");
				String cemail = resultSet.getString("cemail");
				
				
				JDto dto = new JDto(cid, cname, ctelno, caddress, cemail);
				dtos.add(dto);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
	}
	public void modify(String pcode, String pname, String pprice, String pimagename, String pimage) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection(); // sql 연결
			String query = "update product set pname = ?, pprice = ?, imagename = ?, image = ? where pcode = ?";
			preparedStatement = connection.prepareStatement(query);
				
			preparedStatement.setString(1, pname);
			preparedStatement.setString(2, pprice);
			preparedStatement.setString(3, pimagename);
			preparedStatement.setString(4, pimage);
			preparedStatement.setInt(5, Integer.parseInt(pcode));
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
		
	}// modify
	
	public void Delete(String pcode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection(); // sql 연결
			String query = "delete from product where pcode = ?";
			preparedStatement = connection.prepareStatement(query);
				
			preparedStatement.setInt(1, Integer.parseInt(pcode));
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
	
		
		public ArrayList<JDto> product(){
			ArrayList<JDto> dtos = new ArrayList<JDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			try {
				connection = dataSource.getConnection(); // sql 연결
				String query = "select pcode, ppricep, pname, imagename, pimage from product";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					String pimagename = resultSet.getString("pimagename");
					String pimage = resultSet.getString("pimage");
					String pname = resultSet.getString("pname");
					String pprice = resultSet.getString("pprice");
					int pcode = resultSet.getInt("pcode");
					JDto dto = new JDto(pimagename, pimage, pname, pprice, pcode);
					dtos.add(dto);
				}
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
	}
}
		
// end
