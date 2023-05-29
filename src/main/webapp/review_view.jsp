<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 글 보기</title>
</head>
	

<body>

	<table border="1">
		<tr><td>제목</td>				<td>${review.rtitle}</td></tr>
		<tr><td>리뷰 작성 번호 </td>	<td>${review.rcode}</td> </tr>
		<tr><td>작성자 </td> 			<td>${review.r_cid}</td>
		<tr><td>작성일</td> 			<td>${review.rdate}</td>	</tr>
		<tr><td>상품코드 </td> 		<td>${review.r_pcode}</td></tr>
		<tr><td>별점</td> 			<td>${review.rstar}</td> </tr>
		<tr><td colspan="2">내용 </td></tr>

	
	</table>
	
	<textarea rows="30" cols="30" readonly="readonly">${review.rcontent}</textarea>
	
	<form action="review_update.do" name="review_up" method="post" >
	<input type="hidden" name="rtitle" value="${review.rtitle}">
	<input type="hidden" name="rcode" value="${review.rcode}">
	<input type="hidden" name="r_cid" value="${review.r_cid}">
	<input type="hidden" name="rstar" value="${review.rstar}">
	<input type="hidden" name="rcontent" value="${review.rcontent}">
	<input type="submit" value="수정/삭제"> 
	
	
	
	</form>





</body>
</html>