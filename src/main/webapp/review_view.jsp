<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr><td>제목</td><td>${review.rtitle}</td></tr>
		<tr><td>리뷰 작성 번호 </td><td>${review.rcode}</td> </tr>
		<tr><td>작성자 </td> <td>${review.r_cid}</td>
		
		<tr><td>상품코드 </td> <td>${review.r_pcode}</td></tr>
		<tr><td>별점</td> <td>${review.rstar}</td> </tr>
		<tr><td colspan="2">내용 </td></tr>
		<tr><td colspan = "2">${review.rcontent}</td> </tr>
		

	
	</table>






</body>
</html>