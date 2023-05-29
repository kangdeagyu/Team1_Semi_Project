<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성</title>
</head>



<body>
	<form action = "review_insert.do" method="post" >
		<table border="1">
			<tr><td>제목</td>				<td><input type="text" name="rtitle"></td></tr>
			<tr><td>작성자 </td> 			<td><input type="text" name="cid" value= "${cid}" readonly="readonly"></td>
			<tr><td>상품코드 </td> 		<td><input type="text" name="pcode" value="${pcode}" readonly="readonly"></td></tr>
			<tr><td>별점</td> 			<td><input type="number" name="rstar"></td> </tr>
			
			<tr><td colspan="2">내용 </td></tr>
			
		</table>
		<textarea name="rcontent" cols="35" rows="30"> </textarea> <br/>
		<input type="submit" value="저장하기" size="20"> 
		
	</form>
	
	

	
	
	
</body>
</html>