<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성/삭제</title>

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

    .form-inline {
        display: flex;
        flex-wrap: nowrap;
        justify-content: flex-start;
    }

    .form-inline .form-control {
        margin-right: 10px;
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

<h1>리뷰 작성/삭제</h1>
<form action="review_update_execute.do" method="post">
    <input type="hidden" name="rcode" value="${param.rcode}">
    <table class="table table-bordered">
        <tr>
            <td>제목</td>
            <td><input type="text" name="rtitle" value="${param.rtitle}" class="form-control"></td>
        </tr>
        <tr>
            <td>작성자</td>
            <td><input type="text" name="cid" value="${param.r_cid}" readonly="readonly" class="form-control"></td>
        </tr>
        <tr>
            <td>상품코드</td>
            <td><input type="text" name="pcode" value="${param.rcode}" readonly="readonly" class="form-control"></td>
        </tr>
        <tr>
            <td>별점</td>
            <td><input type="number" name="rstar" value="${param.rstar}" class="form-control"></td>
        </tr>
        <tr>
            <td colspan="2">내용</td>
        </tr>
    </table>
    <textarea name="rcontent" rows="10" cols="35" class="form-control">${param.rcontent}</textarea> <br/>
    <div class="form-inline">
        <input type="submit" value="저장하기" class="btn btn-primary"> &nbsp;&nbsp;&nbsp;
        <form action="review_delete.do" method="post">
            <input type="hidden" name="rcode" value="${param.rcode}">
            <input type="hidden" name="cid" value="${param.r_cid}">
            <input type="submit" value="삭제" class="btn btn-danger">
        </form>
    </div>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>