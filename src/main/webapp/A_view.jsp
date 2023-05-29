<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변보기</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

<style>
    body {
        background-color: white;
        padding: 20px;
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

    .form-inline {
        display: flex;
        flex-wrap: nowrap;
        justify-content: flex-start;
    }

    .form-inline .form-control {
        margin-right: 10px;
    }
</style>

</head>
<body>

<table class="table table-bordered">
    <tr>
        <td>제목</td>
        <td>${answer.atitle}</td>
    </tr>
    <tr>
        <td>질문 작성 번호</td>
        <td>${question.qcode}</td>
        <td>답변 작성 번호</td>
        <td>${answer.acode}</td>
    </tr>
    <tr>
        <td>질문자</td>
        <td>${question.q_cid}</td>
        <td>작성자</td>
        <td>${answer.a_aid}</td>
    </tr>
    <tr>
        <td>질문 작성/수정일</td>
        <td>${question.qdate}</td>
        <td>답변 작성일</td>
        <td>${answer.adate}</td>
    </tr>
    <tr>
        <td colspan="2">질문 내용</td>
    </tr>
</table>
<textarea readonly="readonly" rows="5" style="width: 100%;">${question.qcontent}</textarea><br/>
<p>답변 내용</p>
<textarea readonly="readonly" rows="5" style="width: 100%;">${answer.acontent}</textarea><br/><br/>

<c:choose>
    <c:when test="${fn:startsWith(sessionScope.ID, 'admin')}">
        <form action="admin_q_list.do" method="post">
            <input type="submit" value="취소" class="btn btn-primary">
        </form>
    </c:when>
    <c:otherwise>
        <form action="Q_list.do" method="post">
            <input type="submit" value="취소" class="btn btn-primary">
        </form>
    </c:otherwise>
</c:choose>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-tCfRxgEnA8qVngw/CR11iVyfuUJap8aCUoGe5p2rTEi2FS9i1W4XoTSvPTNT2Z5e" crossorigin="anonymous"></script>

</body>
</html>