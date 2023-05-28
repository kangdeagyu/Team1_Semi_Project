<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 질문 작성 페이지.</title>
</head>




<body>

	<form action = "Q_Insert.do" method="post" >
		<table border="1">
			<tr><td>제목</td>				<td><input type="text" name="qtitle"></td></tr>
			<tr><td>작성자 </td> 			<td><input type="text" name="cid" value= "${sessionScope.ID}" readonly="readonly"></td>
			
			<tr><td colspan="2">내용 </td></tr>
			
		</table>
		<textarea name="qcontent" cols="30" rows="30"> </textarea> <br/>
		<input type="submit" value="저장하기" size="20"> 
		
	</form>

	<form action="Q_list.do.jsp" method="post">
		<input type="submit" value="확 인">
	</form>

</body>
</html>