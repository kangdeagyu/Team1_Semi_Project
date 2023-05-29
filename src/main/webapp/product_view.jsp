<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정 및 삭제</title>
  <style>
    body {
      margin: 0 auto;
      width: 500px;
    }
  </style>
</head>
<body>
   <h2>상품 수정 및 삭제</h2>
   <form action="modify.do" method="post">
      <input type="hidden" name="seq" value="${product.seq}">
      <table>
         <tr>
            <td>번호</td>
            <td>${product.pcode}</td>
         </tr>
         <tr>
            <td>상품번호</td>
            <td><input type="text" name="pimage" size="20" value="${product.pimagename}"></td>
         </tr>
         <tr>
            <td>상품이미지</td>
            <td><input type="text" name="pimagename" size="20" value="${product.pimage}"></td>
          </tr>
          <tr>
            <td>상품 이름</td>
            <td><input type="text" name="pname" size="20" value="${product.pname}"></td>
         </tr>
         <tr>
          <td>상품가격</td>
            <td><input type="text" name="pprice" size="20" value="${product.pprice}"></td>
         </tr>
        
         <tr>
            <td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="product.do">목록보기</a>
            &nbsp;&nbsp;&nbsp;<a href="delete.do?seq=${product.seq }">삭제</a></td>
         </tr>
      </table>
   </form>
</body>
</html>