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
	
	public ArrayList<SJihwan_UserOrderList_Dto> list(String cid) {
		ArrayList<SJihwan_UserOrderList_Dto> dtos = new ArrayList<SJihwan_UserOrderList_Dto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = datasource.getConnection();
			String query = "select p.pimage, p.pcode, o.onum, p.pname, p.pprice, o.oqty, o.odate, c.cname ";
			String query1 = " from Customer c, product p, ordering o ";
			String query2 = " where c.cid = o.o_cid and o.o_pcode = p.pcode and o.o_cid = ?";
			preparedStatement = connection.prepareStatement(query+query1+query2);
			preparedStatement.setString(1, cid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String pimage = resultSet.getString(1);
				int pcode= resultSet.getInt(2);
			    int onum=resultSet.getInt(3);
			    String pname = resultSet.getString(4);
			    int pprice = resultSet.getInt(5);
			    int oqty = resultSet.getInt(6);
			    String odate = resultSet.getString(7);
			    String cname= resultSet.getString(8);
			    SJihwan_UserOrderList_Dto dto = new SJihwan_UserOrderList_Dto(pimage, onum, pname, pprice, oqty, odate, pcode, cname);
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
