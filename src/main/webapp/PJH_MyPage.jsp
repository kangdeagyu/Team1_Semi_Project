<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        h2 {
            margin-top: 20px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        input[type="submit"] {
            padding: 5px 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 14px;
            margin-top: 10px;
        }

        input[type="text"] {
            padding: 5px;
            width: 100%;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<h2>MyPage</h2>
<table>
    <tr>
        <td>${content_view.cname} 고객님</td>
        <td>
            <form action="usermain.do" method="post">
                <input type="submit" name="action" value="Home">
            </form>
        </td>
        <td>
            <form action="loginview.do" method="post">
                <input type="submit" name="action" value="LogOut">
            </form>
        </td>
        <td>
            <form action="cartlist.do" method="post">
                <input type="submit" name="action" value="장바구니">
            </form>
        </td>
        <td>
            <form action="Q_list.do" method="post">
                <input type="submit" name="action" value="Q&A">
            </form>
        </td>
    </tr>
</table>
<form action="UserModify.do" method="post">
    <input type="hidden" name="cid" value="${cid}">
    <table>
        <tr>
            <td>ID</td>
            <td>${cid}</td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="cpw" value="${content_view.cpw}" size="10"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="cname" value="${content_view.cname}" size="10"></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="ctelno" value="${content_view.ctelno}" size="10"></td>
        </tr>
        <tr>
            <td>주소</td>
            <td><input type="text" name="caddress" value="${content_view.caddress}" size="10"></td>
        </tr>
        <tr>
            <td>전자우편</td>
            <td><input type="text" name="cemail" value="${content_view.cemail}" size="10"></td>
        </tr>
    </table>
    <br/>
    <table>
        <tr>
            <td>
                <input type="submit" value="수정">
            </td>
        </tr>
    </table>
</form>
<hr>
<form action="deleteaccount.do" method="post">
    <input type="submit" value="탈퇴">
</form>
<form action="userorderlist.do" method="post">
    <input type="submit" value="주문목록">
</form>
</body>
</html>