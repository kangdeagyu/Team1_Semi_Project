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
			String query = "select pimagename, pprice, pname from product";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String Pimagename = resultSet.getString("pimagename");
				int Pprice = resultSet.getInt("pprice");
				String Pname = resultSet.getString("pname");
				
//				File file = new File("./" + Pimagename);
//				FileOutputStream output = new FileOutputStream(file);   // fileoutputstream은 file만드는 클래스
//				InputStream input = resultSet.getBinaryStream("pimage");  // db에서 image를 가져오는 것
//				byte[] buffer = new byte[1024];  // 1024는 한번에 불러오는 파일의 크기 버퍼가 바이트배열로 만들어지는데 그림의 일부분(정해준 크기)만큼씩 블록으로 생성하여 배열로 들어옴
//				while(input.read(buffer)>0) {
//					output.write(buffer);
//				}
				Kms_UserMain_Dto dto = new Kms_UserMain_Dto(Pimagename, Pprice, Pname);
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
}


