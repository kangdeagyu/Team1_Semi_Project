<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 정보</title>
<!-- 부트스트랩 CSS 링크 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
${sid } 고객님 환영합니다. <br/>
<h3>${contentView.pname}</h3>
<input type="hidden" name="cid" value=${sid }>
	<table>
			<td>
			<form action="usermain.do" method="post">
				<input type="submit" name="action" value="홈" class="btn btn-primary">
			</form>
			</td>
			<td>
			<form action="loginview.do" method="post">
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
	</table>
<form action="basket.do" method="post">
		<input type="hidden" name="pcode" value="${contentView.pcode }">
		<input type="hidden" name="cid" value="${sid }">
		<table class="table table-bordered">
			<tr>
				<td>상품이름 :</td>
				<td>${contentView.pname }</td>
			</tr>
			<tr>
				<td>상품번호 :</td>
				<td>${contentView.pcode }</td>
			</tr>
			<tr>
				<td>가격 :</td>
				<td>${contentView.pprice }</td>
			</tr>
			<tr>
				<td><img src="${contentView.pimage }" alt="${contentView.pname}" height="100" width="100"></td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="text" name="bqty" class="form-control"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="장바구니 담기" class="btn btn-primary">
					&nbsp;&nbsp;&nbsp;
					<a href="usermain.do" class="btn btn-secondary">목록보기</a>
				</td>
			</tr>
		</table>
	</form>
<!-- 부트스트랩 JS 링크 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
