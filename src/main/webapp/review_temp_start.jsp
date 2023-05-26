<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>임시로 만든 리뷰 시작 페이지 입니다. 후에 다른 기능 들과 연결 시킬 때 참고합시다.</title>
</head>
<body>

	<h2>임시로 만든 리뷰시작 페이지 입니다. <br/></h2>
	후에 상품 목록에서 리뷰 보기 할때,  <span style="color : darkred; font-size : 70"> pcode </span> 가져와서 
	<span style="color : darkred; font-size : 70"> /reviewlist.do?pcode=_____</span> 방식로 보내면 됩니다. 
	
	<hr><hr><hr>
	
	<form action="reviewlist.do" method="post">
	
		<input type="text" size="40" name="pcode" > <br/><br/>
		<input type="submit" size="20" value="해당제품 리뷰 목록 보기"> 
	</form>
	
	
	
	
	
</body>
</html>