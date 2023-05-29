<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문지 작성 및 수정하기</title>

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

<script>
    function goBack() {
        window.history.back();
    }
</script>

</head>
<body>

<h1>질문지 작성 및 수정하기</h1>

<form action="question_update_execute.do" method="post">
    <input type="hidden" name="qcode" value="${param.qcode}">
    <table class="table table-bordered">
        <tr>
            <td>제목</td>
            <td><input type="text" name="qtitle" value="${param.qtitle}" class="form-control"></td>
        </tr>
        <tr>
            <td>작성자</td>
            <td><input type="text" name="q_cid" value="${param.q_cid}" readonly="readonly" class="form-control"></td>
        </tr>
        <tr>
            <td>상품코드</td>
            <td><input type="text" name="qcode" value="${param.qcode}" readonly="readonly" class="form-control"></td>
        </tr>
        <tr>
            <td colspan="2">내용</td>
        </tr>
    </table>
    <textarea name="qcontent" rows="10" cols="35" class="form-control">${param.qcontent}</textarea> <br/>
    <div class="form-inline">
        <input type="submit" value="저장하기" class="btn btn-primary">
        <button onclick="goBack()" class="btn btn-secondary">취소</button>
    </div>
</form>

<form action="question_delete.do" method="post">
    <input type="hidden" name="qcode" value="${param.qcode}">
    <input type="hidden" name="cid" value="${param.q_cid}">
    <input type="submit" value="삭제" class="btn btn-danger">
</form>

<form action="Q_list.do.jsp" method="post">
    <input type="submit" value="확인" class="btn btn-success">
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>