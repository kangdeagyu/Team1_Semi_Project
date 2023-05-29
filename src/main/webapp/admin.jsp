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
   <h3>주문상태</h3>
<form action="search.do" method="post">
      검색 선택 :
      <select name="query">
         <option value="name">상풍명</option>
         <option value="address" selected="selected">주소</option>
      </select>
      <input type="text" name="content" size="30">
      <input type="submit" value="검색">      
</form>
<table border="1">
      <tr>
         <th>cid</th>
         <th>고객이름</th>
         <th>전화번호</th>
         <th>주소</th>
         <th>전자우편</th>
         <th>상품명</th>
      </tr>
      <c:forEach items="${list }" var="dto">
         <tr>
            <td><a>${dto.cid}</a></td>
            <td>${dto.cname}</td>
            <td>${dto.cphone}</td>
            <td>${dto.caddress}</td>
            <td>${dto.cemail}</td>
            <td>${dto.pname}</td>
            
         </tr>
      </c:forEach>
   </table><br/>
   <form action="product.do" method="post">
      <input type="submit" value="입력">
   </form>
   <hr/><br/>
</body>
</html>