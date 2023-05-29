product 상품목록

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3>주문싱테</h3>
<form action="search.do" method="post">
      검색 선택 :
      <select name="query">
         <option value="pname">상품이름</option>
         <option value="pprice" selected="selected">가격</option>
      </select>
      <input type="text" name="content" size="30">
      <input type="submit" value="검색">      
</form>
<table border="1">
      <tr>
         <th>pcode</th>
         <th>상품번호</th>
         <th>상품이미지</th>
         <th>상품이름</th>
         <th>상품가격</th>
         
      </tr>
      <c:forEach items="${list }" var="dto">
         <tr>
            <td><a href=".do?seq=${dto.pcode}">${dto.pcode}</a></td>
            <td>${dto.pimage}</td>
            <td>${dto.pimagename}</td>
            <td>${dto.pnamed}</td>
            <td>${dto.pprice}</td>
         </tr>
      </c:forEach>
   </table><br/>
   <form action="product_view.do" method="post">
   </form>
   <hr/><br/>
</body>
</html>