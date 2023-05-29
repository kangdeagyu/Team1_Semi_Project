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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.javalec.bbs.dto.SJihwan_Cart_Purchase_Dto;


public class SJihwan_Cart_Purchase_Dao {

	// Field
	DataSource datasource;
	
	
	
	
	
	
	// Constructor
	public SJihwan_Cart_Purchase_Dao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/shoestar");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	//Method
	
	public ArrayList<SJihwan_Cart_Purchase_Dto> list(String cid) {
		ArrayList<SJihwan_Cart_Purchase_Dto> dtos = new ArrayList<SJihwan_Cart_Purchase_Dto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = datasource.getConnection();
			String query = "select p.pimage, p.pcode, p.pname, p.pprice, b.bqty, b.bcode ";
			String query1 = " from Customer c, product p, basket b ";
			String query2 = " where c.cid = b.b_cid and b.b_pcode = p.pcode and b.b_cid = ?";
			preparedStatement = connection.prepareStatement(query+query1+query2);
			preparedStatement.setString(1, cid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			    String pimage=resultSet.getString(1);
			    int pcode=resultSet.getInt(2);
			    String pname = resultSet.getString(3);
			    int pprice = resultSet.getInt(4);
			    int bqty = resultSet.getInt(5);
			    int bcode = resultSet.getInt(6);
			    SJihwan_Cart_Purchase_Dto dto = new SJihwan_Cart_Purchase_Dto(pimage, pcode, pname, pprice, bqty, bcode);
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
	
	
	
	
	
	
	public void delete(String bcode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = datasource.getConnection();
			String query = "delete from basket where bcode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bcode));
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
	
	public void purchase(String cid, String pcode, String qty) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = datasource.getConnection();
			String query = "insert into ordering (o_cid, o_pcode, oqty, odate) values (?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cid);
			preparedStatement.setString(2, pcode);
			preparedStatement.setString(3, qty);
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
	
	
	
	
	public SJihwan_Cart_Purchase_Dto total(String cid) {
	    SJihwan_Cart_Purchase_Dto dto = null;
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    try {
	        connection = datasource.getConnection();

	        String query = "SELECT c.cid, SUM(p.pprice * b.bqty) AS total_sales";
	        String query1 = " FROM basket b JOIN Customer c ON c.cid = b.b_cid";
	        String query2 = " JOIN product p ON p.pcode = b.b_pcode";
	        String query3 = " WHERE c.cid = ?";
	        String query4 = " GROUP BY c.cid";

	        preparedStatement = connection.prepareStatement(query + query1 + query2 + query3 + query4);
	        preparedStatement.setString(1, cid);
	        resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            int totalSales = resultSet.getInt("total_sales");
	            dto = new SJihwan_Cart_Purchase_Dto(totalSales);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (preparedStatement != null) preparedStatement.close();
	            if (connection != null) connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return dto;
	}
	
	
	
	
	
	

	
	
} //End
