<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변보기</title>
<style>
    body {
        background-color: lavender;
        color: darkslategray;
    }
    table {
        border: 1px solid darkslategray;
        border-collapse: collapse;
        width: 100%;
    }
    th, td {
        border: 1px solid darkslategray;
        padding: 8px;
        text-align: left;
    }
    th {
        background-color: plum;
    }
    textarea {
        width: 400px;
        height: 200px;
        resize: none;
    }
    input[type="submit"] {
        background-color: plum;
        border: none;
        color: white;
        padding: 8px 16px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 14px;
        margin: 4px 2px;
        cursor: pointer;
        border-radius: 4px;
    }
</style>
</head>

<body>
    <table>
        <tr>
            <th>제목</th>
            <td>${answer.atitle}</td>
        </tr>
        <tr>
            <th>질문 작성 번호</th>
            <td>${question.qcode}</td>
            <th>답변 작성 번호</th>
            <td style="width: 40px;">${answer.acode}</td>
        </tr>
        <tr>
            <th>질문자</th>
            <td>${question.q_cid}</td>
            <th>작성자</th>
            <td style="width: 40px;">${answer.a_aid}</td>
        </tr>
        <tr>
            <th>질문 작성/수정일</th>
            <td>${question.qdate}</td>
            <th>답변 작성일</th>
            <td style="width: 40px;">${answer.adate}</td>
        </tr>
        <tr>
            <th colspan="2">질문 내용</th>
        </tr>
    </table>
    <textarea readonly="readonly">${question.qcontent}</textarea><br/>
    <p>답변 내용</p>
    <textarea readonly="readonly">${answer.acontent}</textarea><br/><br/>

    <c:if test="${fn:startsWith(sessionScope.ID, 'admin')}">
        <form action="admin_q_list.do" method="post">
            <input type="submit" value="취소">
        </form>
    </c:if>

    <c:otherwise>
        <form action="Q_list.do" method="post">
            <input type="submit" value="취소">
        </form>
    </c:otherwise>
</body>
</html>