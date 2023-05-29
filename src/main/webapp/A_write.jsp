<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변보기</title>
<style>
    .textarea-style {
        width: 400px;
        height: 200px;
    }
</style>
</head>
<script>
    function goBack() {
        window.history.back();
    }
</script>
<body>
    <form action="A_insert.do" method="post">
    <table border="1" >
        <tr>
            <td>제목</td>
            <td><input type="text" name="atitle" value="${answer.atitle}" ></td>
        </tr>
        <tr>
            <td>질문 작성 번호 </td>
            <td>${question.qcode}</td>
            <td>답변 작성 번호 </td>
            <td style="width: 40px;"><input type="text" name="acode" value="${answer.acode}" readonly="readonly"></td>
        </tr>
        <tr>
            <td>질문자 </td>
            <td>${question.q_cid}</td>
            <td>작성자</td>
            <td style="width: 40px;">${answer.a_aid}</td>
        </tr>
        <tr>
            <td>질문 작성/수정일</td>
            <td>${question.qdate}</td>
            <td>답변 작성일</td>
            <td style="width: 40px;">${answer.adate}</td>
        </tr>
        <tr>
            <td colspan="2">질문 내용</td>
        </tr>
    </table>
    <textarea readonly="readonly" class="textarea-style">${question.qcontent}</textarea><br/>
    <p>답변 내용</p>
    <textarea class="textarea-style" name="acontent">${answer.acontent}</textarea><br/>
    <input type="submit" value="답변 완료">
    </form>
    
    <form action="admin_q_list.do" method="post">
    <input type="submit" value="취소">
    </form>
</body>
</html>