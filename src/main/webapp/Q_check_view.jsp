<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문 상세 보기</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>제목</td>
			<td>${question.qtitle}</td>
		</tr>
		<tr>
			<td>질문 작성 번호</td>
			<td>${question.qcode}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${question.q_cid}</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${question.qdate}</td>
		</tr>
		<tr>
			<td colspan="2">내용</td>
		</tr>
	</table>
	
	<c:if test="${not empty question.qcontent}">
		<textarea rows="30" cols="30" readonly="readonly">${question.qcontent}</textarea>
	</c:if>
	<c:if test="${empty question.qcontent}">
		<p>No content available</p>
	</c:if>
		
	<form action="answer_write.do" name="review_up" method="post" >
		<input type="hidden" name="qtitle" value="${question.qtitle}">
		<input type="hidden" name="qcode" value="${question.qcode}">
		<input type="hidden" name="q_cid" value="${question.q_cid}">
		<input type="hidden" name="qcontent" value="${question.qcontent}">
		<input type="submit" value="답변달기"> 
	</form>
	<form action="admin_q_list.do" method="post">
		<input type="submit" value="확인">
	</form>
</body>
</html>