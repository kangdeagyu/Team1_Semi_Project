<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문 상세 보기</title>
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
<h1>질문 상세 보기</h1>
<table border="1">
    <tr>
        <td>제목</td>
        <td>${question.qtitle}</td>
    </tr>
    <tr>
        <td>질문 작성 번호</td>
        <td>${question.qcode}</td>
    </tr>
    <tr>
        <td>작성자</td>
        <td>${question.q_cid}</td>
    </tr>
    <tr>
        <td>작성일</td>
        <td>${question.qdate}</td>
    </tr>
    <tr>
        <td colspan="2">내용</td>
    </tr>
</table>
<textarea rows="30" cols="30" readonly="readonly" class="form-control">${question.qcontent}</textarea>
<c:choose>
    <c:when test="${session.sid == question.q_cid}">
        <form action="question_update.do" name="review_up" method="post">
            <input type="hidden" name="qtitle" value="${question.qtitle}">
            <input type="hidden" name="qcode" value="${question.qcode}">
            <input type="hidden" name="q_cid" value="${question.q_cid}">
            <input type="hidden" name="qcontent" value="${question.qcontent}">
            <input type="submit" value="수정/삭제" class="btn btn-primary">
        </form>
    </c:when>
    <c:otherwise>
        <form action="Q_list.do.jsp" method="post">
            <input type="submit" value="확인" class="btn btn-primary">
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>