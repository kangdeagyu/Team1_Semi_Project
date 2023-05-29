package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.Kkg_Answer_Dto;
import com.javalec.bbs.dto.Kkg_Question_Dto;
import com.javalec.bbs.dto.Kkg_Review_Dto;

public class Kkg_QnA_Dao {

	DataSource dataSource;
	
	
	public Kkg_QnA_Dao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/shoestar");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	
	
	
	public ArrayList<Kkg_Question_Dto> q_list(String qcid) {
		
		ArrayList<Kkg_Question_Dto> dtos = new ArrayList<Kkg_Question_Dto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection =dataSource.getConnection();
			String query = "select qcode, q_cid, qtitle, qcontent, qdate, qdeldate from question where q_cid = ? AND qdeldate < DATE_ADD(qdate, INTERVAL 2 SECOND)";
			
			System.out.println("q_cid : "+qcid);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, qcid);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int qcode = resultSet.getInt("qcode");
				String q_cid = resultSet.getString("q_cid");
				String qtitle = resultSet.getString("qtitle");
				String qcontent = resultSet.getString("qcontent");
				Timestamp qdate = resultSet.getTimestamp("qdate");
				Timestamp qdeldate = resultSet.getTimestamp("qdeldate");
				System.out.println("resultSet.getInt(rcode) : "+resultSet.getInt("qcode"));
				
				Kkg_Question_Dto dto = new Kkg_Question_Dto(qcode, q_cid,  qtitle, qcontent, qdate, qdeldate);
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
		
	}//q_list end
	
	public ArrayList<Kkg_Question_Dto> admin_q_list() {
		
		ArrayList<Kkg_Question_Dto> dtos = new ArrayList<Kkg_Question_Dto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection =dataSource.getConnection();
			String query = "select qcode, q_cid, qtitle, qcontent, qdate, qdeldate from question ";
			
			System.out.println("q_cid : ");
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int qcode = resultSet.getInt("qcode");
				String q_cid = resultSet.getString("q_cid");
				String qtitle = resultSet.getString("qtitle");
				String qcontent = resultSet.getString("qcontent");
				Timestamp qdate = resultSet.getTimestamp("qdate");
				Timestamp qdeldate = resultSet.getTimestamp("qdeldate");
				System.out.println("resultSet.getInt(rcode) : "+resultSet.getInt("qcode"));
				
				Kkg_Question_Dto dto = new Kkg_Question_Dto(qcode, q_cid,  qtitle, qcontent, qdate, qdeldate);
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
		
	}//admin_q_list end
	
	
	
	
	
	
	//q_insert(q_cid, qtitle, qcontent)
		public boolean q_insert(String q_cid, String qtitle, String qcontent) {
			//			boolean rs  = dao.review_insert(cid, pcode, rtitle, rcontent, rstar);
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				int qcode = 0;
				
				//question db에 값 입력.
				connection =dataSource.getConnection();
				String sql = "insert into question (q_cid, qtitle, qcontent, qdate, qdeldate) values (?,?,?,now(),now()) ";
				
				System.out.println("qtitle : "+qtitle);
				preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, q_cid);
				preparedStatement.setString(2, qtitle);
				preparedStatement.setString(3, qcontent);
				System.out.println("입력 완료 : " + qtitle);
				preparedStatement.executeUpdate();
				
				ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
				    qcode = generatedKeys.getInt(1);
				}
				
				String sql_answer = "insert into answer (a_qcode,atitle, acontent) values (?,?,?)";
				System.out.println(sql_answer + "qcode : "+qcode);
				preparedStatement = connection.prepareStatement(sql_answer);
				preparedStatement.setInt(1,qcode);
				preparedStatement.setString(2, "답변 ) "+ qtitle) ;
				preparedStatement.setString(3, "질문이 접수되었습니다. 관리자가 확인 중입니다. <br/> 빠른 확인후 정확한 답변 드리겠습니다.");
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
			

		} //q_insert
	
	
	
	
	
	
	
	
	//question_view
	
	public Kkg_Question_Dto question_view(int q_code){
		Kkg_Question_Dto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection =dataSource.getConnection();
			String query = "select qcode, q_cid, qtitle, qcontent, qdate, qdeldate from question where qcode = ? ";
			
			System.out.println("qcode : "+q_code);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, q_code);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int qcode = resultSet.getInt("qcode");
				String q_cid = resultSet.getString("q_cid");
				String qtitle = resultSet.getString("qtitle");
				String qcontent = resultSet.getString("qcontent");
				Timestamp qdate = resultSet.getTimestamp("qdate");
				Timestamp qdeldate = resultSet.getTimestamp("qdeldate");
				System.out.println("resultSet.getInt(rcode) : "+resultSet.getInt("qcode"));
				
				dto = new Kkg_Question_Dto(qcode, q_cid,  qtitle, qcontent, qdate, qdeldate);
		
	
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
	}//question view end
	
	public boolean question_update(int qcode, String cid, String qtitle, String qcontent) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection =dataSource.getConnection();
			String sql = "update question set qtitle = ?, qcontent = ?, qdate= now() where qcode = ?";
			
			System.out.println("qtitle : "+qtitle);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, qtitle);
			preparedStatement.setString(2, qcontent);
			preparedStatement.setInt(3, qcode);
			System.out.println("수정 완료" + qtitle);
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
	}//question_update  end
	
	
	public boolean question_delete(int qcode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection =dataSource.getConnection();
			String sql = "update question set qdeldate= now() where qcode = ?";
			
			System.out.println("qcode : "+qcode);
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, qcode);
			System.out.println("삭제 완료" + qcode);
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
	}//Question end
	
	public Kkg_Answer_Dto answer_view(int q_code){
		Kkg_Answer_Dto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		//내가 가진건 qcode (q_code)
		//question 에서 qcode, cid,qcontent, qdate 가져와야함. >>> 이건 위에 question_view 에서 가져오자.
		//Answer 에서 acode , a_qcode, a_aid, atitle, acontent, adate, adeldate 가져와야 함
		
		
		try {
			connection =dataSource.getConnection();
			String query = "select acode, a_qcode, a_aid, atitle, acontent, adate, adeldate from answer where a_qcode = ? ";
			
			System.out.println("qcode : "+q_code);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, q_code);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int acode = resultSet.getInt("acode");
				int a_qcode = resultSet.getInt("a_qcode");
				String a_aid = resultSet.getString("a_aid");
				String atitle = resultSet.getString("atitle");
				String acontent = resultSet.getString("acontent");
				Timestamp adate = resultSet.getTimestamp("adate");
				Timestamp adeldate = resultSet.getTimestamp("adeldate");
				System.out.println("resultSet.getInt(acode) : "+resultSet.getInt("acode"));
				
				dto = new Kkg_Answer_Dto(acode, a_qcode,  a_aid, atitle, acontent, adate, adeldate);
		
	
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
	}//question view end
	
	
	//a_insert(acode, atitle, acontent, aid)
	public boolean a_insert(int acode, String atitle, String acontent, String aid) {
		//			boolean rs  = dao.review_insert(cid, pcode, rtitle, rcontent, rstar);
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection =dataSource.getConnection();
			String sql = "update answer set a_aid = ? , atitle = ?, acontent = ? , adate=now(), adeldate=now() where acode = ?";
			
			//System.out.println("rtitle : "+rtitle);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, aid);
			preparedStatement.setString(2, atitle);
			preparedStatement.setString(3, acontent);
			preparedStatement.setInt(4, acode);
			
			System.out.println("입력 완료" + acode);
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
	
	
}//end
