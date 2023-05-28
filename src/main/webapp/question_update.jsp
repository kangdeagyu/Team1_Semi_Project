<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문지 작성 및 수정하기</title>
</head>
	
	<script>
	function goBack() {
	    window.history.back();
	}
	</script>
<body>

	<form action = "question_update_execute.do" method="post" >
		<input type="hidden" name="qcode" value="${param.qcode}">
		<table border="1">
			<tr><td>제목</td>				<td><input type="text" name="qtitle" value="${param.qtitle}"></td></tr>
			<tr><td>작성자 </td> 			<td><input type="text" name="q_cid" value= "${param.q_cid}" readonly="readonly"></td>
			<tr><td>상품코드 </td> 		<td><input type="text" name="qcode" value="${param.qcode}" readonly="readonly"></td></tr>
			
			<tr><td colspan="2">내용 </td></tr>
			
		</table>
		<textarea name="qcontent" cols="35" rows="30" > ${param.qcontent} </textarea> <br/>
		<input type="submit" value="저장하기" size="20"> <button onclick="goBack()">취 소</button>
		
	</form>
	
	
	
	
	<form action="question_delete.do" method="post">

	<input type="hidden" name="qcode" value="${param.qcode}">
	<input type="hidden" name="cid" value="${param.q_cid}">

	<input type="submit" value="삭제">
	
	
	</form>
	
	<form action="Q_list.do.jsp" method="post">
		<input type="submit" value="확 인">
	</form>



</body>
</html>