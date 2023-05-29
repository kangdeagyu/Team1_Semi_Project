<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변보기</title>
</head>


<body>

	<table border="1" >
		<tr><td>제목</td>				<td>${answer.atitle}</td></tr>
		<tr><td>질문 작성 번호 </td>	<td>${question.qcode}</td> <td>답변 작성 번호 </td>	<td style="width: 40px;">${answer.acode}</td></tr>
		<tr><td>질문자 </td> 			<td>${question.q_cid}</td> <td>작성자		  </td> <td style="width: 40px;">${answer.a_aid}</td></tr>
		<tr><td>질문 작성/수정일</td> 	<td>${question.qdate}</td> <td>답변 작성일	  </td> <td style="width: 40px;">${answer.adate}</td></tr>
		<tr><td colspan="2">질문 내용 </td></tr>

	</table>
		<textarea readonly="readonly" style="width: 400px; height: 200px;">${question.qcontent}</textarea><br/>
		<p>답변 내용</p>
		<textarea readonly="readonly" style="width: 400px; height: 200px;">${answer.acontent}</textarea><br/><br/>
		
		
		<c:if test="${fn:startsWith(sessionScope.ID, 'admin')}">
			<form action="admin_q_list.do" method="post">
			<input type="submit" value="취소">
			</form>
		</c:if>
		
		<c:otherwise>
			<form action="Q_list.do" method="post">
			<input type="submit" value="취소">
			</form>
		</c:otherwise>
	
</body>
</html>