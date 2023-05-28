package com.javalec.bbs.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.javalec.bbs.dto.SJihwan_UserOrderList_Dto;

public class SJihwan_UserOrderList_Dao {

	
	
	// Field
	
	DataSource datasource;
	
	
	
	
	// Constructor
	
	public SJihwan_UserOrderList_Dao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/shoestar");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	// Method
	
	public ArrayList<SJihwan_UserOrderList_Dto> list() {
		ArrayList<SJihwan_UserOrderList_Dto> dtos = new ArrayList<SJihwan_UserOrderList_Dto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = datasource.getConnection();
			String query = "select p.pimage, p.pcode, o.onum, p.pname, p.pprice, o.oqty, o.odate ";
			String query1 = " from Customer c, product p, ordering o ";
			String query2 = " where c.cid = o.o_cid and o.o_pcode = p.pcode and o.o_cid = 'JS1987' ";
			preparedStatement = connection.prepareStatement(query+query1+query2);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			    int pcode = resultSet.getInt(2);
			    File file = new File("./" + pcode);
			    FileOutputStream output = new FileOutputStream(file);
			    InputStream input = resultSet.getBinaryStream(1);
			    
			    byte[] buffer = new byte[1024];
			    while (input.read(buffer) > 0) {
			        output.write(buffer);
			    }
			    
			    String pimageName = file.getPath(); // 파일의 전체 경로를 가져옴
			    int onum=resultSet.getInt(3);
			    String pname = resultSet.getString(4);
			    int pprice = resultSet.getInt(5);
			    int oqty = resultSet.getInt(6);
			    String odate = resultSet.getString(6);
			    SJihwan_UserOrderList_Dto dto = new SJihwan_UserOrderList_Dto(pimageName, onum, pname, pprice, oqty, odate);
			    dtos.add(dto);
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
		return dtos;
		
	} // list
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//End
