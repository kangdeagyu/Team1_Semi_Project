<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>신발 리스트</title>
<!-- 부트스트랩 CSS 링크 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<style>
    body {
        font-family: Arial, sans-serif;
    }
    h1 {
        text-align: center;
    }
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        padding: 10px;
        text-align: left;
        border: 1px solid #ddd;
    }
    img {
        max-width: 100px;
        max-height: 100px;
    }
    .logout-btn,
    .mypage-btn,
    .cartlist-btn,
    .write-question-btn {
        display: inline-block;
        margin-right: 10px;
        padding: 5px 10px;
        background-color: #337ab7;
        color: #fff;
        text-decoration: none;
        border-radius: 3px;
    }
    .search-form {
        margin-bottom: 10px;
    }
    .search-form select,
    .search-form input[type="text"],
    .search-form input[type="submit"] {
        margin-right: 5px;
        padding: 5px;
        border-radius: 3px;
    }
</style>
</head>

<body>
	<h1>신발 리스트</h1>
	${sid } 고객님 환영합니다.
	<input type="hidden" name="cid" value="${sid }">
	<table>
			<form action="loginview.do" method="post">
			<td>
			<input type="submit" name="action" value="로그아웃" class="btn btn-danger">
			</form>
			</td>
			<td>
			<form action="mypage.do" method="post">
				<input type="submit" name="action" value="마이페이지" class="btn btn-primary">
			</form>
			</td>
			<td>
			<form action="cartlist.do" method="post">
				<input type="submit" name="action" value="장바구니" class="btn btn-primary">
			</form>
			</td>
			<td>
			<form action="Q_Write.do" method="post">
				<input type="submit" name="action" value="질문 작성하기" class="btn btn-primary">
			</form>
			</td>
	</table>
	<form action="search.do" method="post" class="search-form">
    <div class="row align-items-center">
        <div class="col-auto">
            <select name="list" class="form-select">
                <option value="pname" selected="selected">상품명</option>
                <option value="pcode">상품번호</option>
            </select>
        </div>
        <div class="col">
            <input type="text" name="content" size="20" class="form-control">
        </div>
        <div class="col-auto">
            <input type="submit" value="검색" class="btn btn-primary">
        </div>
    </div>
</form>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th>이미지</th>
				<th>상품번호</th>
				<th>상품명</th>
				<th>상품가격</th>
				<th>리뷰</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><img src="${dto.pimage}" alt="${dto.pimagename}" height="100" width="100"></td>
					<td>${dto.pcode}</td>
					<td><a href="buy.do?pname=${dto.pname}">${dto.pname}</a></td>
					<td>${dto.pprice}</td>
					<td><a href="reviewlist.do?pcode=${dto.pcode}">리뷰목록</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
<!-- 부트스트랩 JS 링크 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>

	