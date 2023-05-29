<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<title>판매상품 등록</title>
  <style>
    body {
      margin: 0 auto;
      width: 500px;
    }
  </style>
</head>
<body>
	<h2>판매상품 등록</h2>
	<form action="write.do" method="post" name="address">
		<table>
			<tr>
		        <td>상품번호</td>
            <td><input type="text" name="pimage" size="20"></td>
         </tr>
         <tr>
            <td>상품이미지</td>
            <td><input type="text" name="pimagename" size="20"></td>
          </tr>
          <tr>
            <td>상품 이름</td>
            <td><input type="text" name="pname" size="20"></td>
         </tr>
         <tr>
          <td>상품가격</td>
            <td><input type="text" name="pprice" size="20"></td>
         </tr>
			<tr>
				<td colspan="2"><input type="button" value="입고" onclick="checkAddress()">&nbsp;&nbsp;&nbsp;<a href="product.do">판매상품보기</a></td>
			</tr>
		</table>
	</form>
</body>
</html>
</body>
</html>