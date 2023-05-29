<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지 : 질문 목록 보기</title>
</head>

		<script>
	function goBack() {
	    window.history.back();
	}
	</script>
<body>


	<h1>관리자페이지 : 질문 게시판</h1>
	<table border="1">
		<tr>
			<th>review No.</th><th>작성자</th><th>제목</th><th>작성일</th><th>삭제일</th><th>답변 완료 여부</th><th> 답변글 보러가기</th>
		</tr>
		
		
			<c:forEach items="${qList}" var = "dto"> <!-- 커맨드에서 list 라는 이름으로 보낸 데이터들. -->
				<tr>
					<td>${dto.qcode}</td>
					<td>${dto.q_cid}</td>
					<td><a href="question_check_view.do?qcode=${dto.qcode}">${dto.qtitle}</a></td>
					<td>${dto.qdate}</td>
					<td>
					
					<c:if test="${dto.qdate > dto.qdeldate }">
					${dto.qdeldate}
					</c:if>

					
					</td>
					<td>
					<c:if test="${dto.qdate > dto.qdeldate }">
					$(dto.qdeldate}
					</c:if>
					
					
					</td>
									
					
					<td><a href = "answer_view.do?qcode=${dto.qcode}">답글 보러가기</a></td>
					
				</tr>
			</c:forEach>

			</table> 
			<br/>
			<br/>


	<form action="review_temp_start.jsp" method="post">
		<input type="submit" value="확 인">
	</form>





</body>
</html>