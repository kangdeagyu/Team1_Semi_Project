<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>임시로 만든 리뷰 시작 페이지 입니다. 후에 다른 기능 들과 연결 시킬 때 참고합시다.</title>
</head>
<body>



	<form action="reviewlist.do" method="post">

		<h2>임시로 만든 리뷰시작 페이지 입니다. <br/></h2>
		pcode별로 리뷰 목록을 긁어올 수 있도록 만들었습니다.<br/>
		상품 목록에서 리뷰 보기 할때,  <span style="color : darkred; font-size : 70"> pcode </span> 가져와서 
		<span style="color : darkred; font-size : 70"> /reviewlist.do?pcode=_____</span> 방식로 보내면 됩니다. 
		
		<hr><hr><hr>
	
	
		<input type="text" size="40" name="pcode" > <br/><br/>
		<input type="submit" size="20" value="해당제품 리뷰 목록 보기"> 
	</form>
	
	<hr>
	<hr>
	
	
	<form action="review_write.do" method="post">
			<h2>리뷰 작성하러 가기 <br/></h2>
		<span style="color : darkred; font-size : 70"> pcode </span> 가져와서 
		<span style="color : darkred; font-size : 70"> /review_write.do?pcode=_____</span> 방식로 보내면 됩니다. 
		<input type="text" size="40" name="pcode" > <br/><br/>
		<input type="submit" size="20" value="리뷰 작성 하러가기"> 
	</form>
	
	<hr>
	<hr>
	

	<form action="Q_Write.do" method="post">
		<h2>질문 작성하러 가기 <br/></h2>
		<span style="color : darkred; font-size : 70"> /Q_Write.do</span> 방식로 보내면 됩니다. 
		<input type="submit" size="20" value="질문 작성하기"> 
	</form>	
	
	<form action="Q_list.do" method="post">
		<h2>내가 한 질문 보러가기 <br/></h2>
		<span style="color : darkred; font-size : 70"> /Q_list.do</span> 방식로 보내면 됩니다. <br/>
		customerid 는 session에 저장되어 있다고 생각하고 작업하였습니다. 
		<input type="submit" size="30" value="내가 한 질문"> 
	</form>	
	
	<hr>
	<hr>
	<hr>
	<form action="admin_q_list.do" method="post">
		<h2>질문 목록 <br/></h2>
		<span style="color : darkred; font-size : 70"> /admin_q_list.do</span> 방식로 보내면 됩니다. <br/>
		customerid 는 session에 저장되어 있다고 생각하고 작업하였습니다. 
		<input type="submit" size="30" value="질문 목록"> 
	</form>	
		
	
</body>
</html>