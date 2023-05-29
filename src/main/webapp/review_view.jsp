<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 글 보기</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

<style>
    body {
        background-color: white;
        padding: 20px;
    }

    h1 {
        color: indigo;
        margin-bottom: 30px;
    }

    table {
        margin-bottom: 30px;
    }

    td {
        padding: 10px;
    }

    textarea {
        width: 100%;
        padding: 10px;
    }

    input[type="submit"] {
        background-color: indigo;
        color: white;
        padding: 10px 20px;
        border: none;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #4b0082; /* 다운 톤 연보라색 */
    }
</style>

</head>
<body>

<h1>리뷰 글 보기</h1>
<table class="table table-bordered">
    <tr>
        <td>제목</td>
        <td>${review.rtitle}</td>
    </tr>
    <tr>
        <td>리뷰 작성 번호</td>
        <td>${review.rcode}</td>
    </tr>
    <tr>
        <td>작성자</td>
        <td>${review.r_cid}</td>
    </tr>
    <tr>
        <td>작성일</td>
        <td>${review.rdate}</td>
    </tr>
    <tr>
        <td>상품코드</td>
        <td>${review.r_pcode}</td>
    </tr>
    <tr>
        <td>별점</td>
        <td>${review.rstar}</td>
    </tr>
    <tr>
        <td colspan="2">내용</td>
    </tr>
</table>

<textarea rows="10" cols="35" readonly="readonly" class="form-control">${review.rcontent}</textarea>

<c:choose>
    <c:when test="${session.sid == review.r_cid}">
        <form action="review_update.do" name="review_up" method="post">
            <input type="hidden" name="rtitle" value="${review.rtitle}">
            <input type="hidden" name="rcode" value="${review.rcode}">
            <input type="hidden" name="r_cid" value="${review.r_cid}">
            <input type="hidden" name="rstar" value="${review.rstar}">
            <input type="hidden" name="rcontent" value="${review.rcontent}">
            <input type="submit" value="수정/삭제" class="btn btn-primary">
        </form>
    </c:when>
    <c:otherwise>
        <form action="reviewlist.do?pcode=${review.r_pcode}" method="post">
            <input type="submit" value="리뷰 목록으로 돌아가기" class="btn btn-primary">
        </form>
    </c:otherwise>
</c:choose>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>