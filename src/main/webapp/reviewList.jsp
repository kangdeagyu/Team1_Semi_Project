<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 리뷰 목록</title>
</head>
<body>

<h1>리뷰 게시판</h1>
	<table border="1">
		<tr>
			<th>review No.</th><th>작성자</th><th>제품</th><th>제목</th><th>별점</th><th>작성일</th>
		</tr>
		
		
			<c:forEach items="${rList}" var = "dto"> <!-- 커맨드에서 list 라는 이름으로 보낸 데이터들. -->
				<tr>
					<td>${dto.rcode}</td>
					<td>${dto.r_cid}</td>
					<td>${dto.r_pcode}</td>
					<td><a href="review_view.do?rcode=${dto.rcode}">${dto.rtitle}</a></td>
					<td>${dto.rstar}</td>
					<td>${dto.rdate}</td>
					
					
				</tr>
			</c:forEach>

			
			
			
	</table>


</body>
</html>