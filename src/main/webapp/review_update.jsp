<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성/삭제</title>
</head>


<body>
	<form action = "review_update_execute.do" method="post" >
		<input type="hidden" name="rcode" value="${param.rcode}">
		<table border="1">
			<tr><td>제목</td>				<td><input type="text" name="rtitle" value="${param.rtitle}"></td></tr>
			<tr><td>작성자 </td> 			<td><input type="text" name="cid" value= "${param.r_cid}" readonly="readonly"></td>
			<tr><td>상품코드 </td> 		<td><input type="text" name="pcode" value="${param.rcode}" readonly="readonly"></td></tr>
			<tr><td>별점</td> 			<td><input type="number" name="rstar" value="${param.rstar}"></td> </tr>
			
			<tr><td colspan="2">내용 </td></tr>
			
		</table>
		<textarea name="rcontent" cols="35" rows="30" > ${param.rcontent} </textarea> <br/>
		<input type="submit" value="저장하기" size="20"> 
	</form>
	
	
	
	
	<form action="review_delete.do" method="post">

	<input type="hidden" name="rcode" value="${param.rcode}">
	<input type="hidden" name="cid" value="${param.r_cid}">

	<input type="submit" value="삭제">  
	
	
	
	</form>
</body>
</html>