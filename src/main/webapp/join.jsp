<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function checkCustomer(){
	
	const regExpId =
	const regExpPw =	
	const regExpName = /^[가-힣]*$/
	const regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/
	const regExpAddress = /^[가-힣|0-9| ]*$/
	const regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
	// *$ 다 포함한다
	
	const form = document.address
	const name = form.name.value
	const phone = form.phone.value
	const address = form.address.value
	const email = form.email.value

	
	
	if(!regExpName.test(name)){
		alert("이름은 한글만으로 입력해 주세요")
		form.name.select()
		return
	}
	
	if(!regExpPhone.test(phone)){
		alert("연락처 입력을 확인해 주세요")
		return
	}
	
	if(!regExpAddress.test(address)){
		alert("주소는 한글과 숫자로 입력해주세요")
		form.addr.select()
		return
	}
	if(address.length == 0){
		alert("주소를 입력해주세요")
		form.addr.select()
		return
	}

	if(!regExpEmail.test(email)){
		alert("이메일 입력을 확인해 주세요")
		form.email.select()
		return
	}

	
	form.submit()
}
</script>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="join.do" method="post">
		<table>
			<tr>
				<td>ID :</td>
				<td><input type="text" name="cid"></td>
			</tr>
			<tr>
				<td>PASSWORD :</td>
				<td><input type="text" name="cpw"></td>
			</tr>
			<tr>
				<td>비밀번호 확인 :</td>
				<td><input type="text" name="pwc"></td>
			</tr>
			<tr>
				<td>이름 :</td>
				<td><input type="text" name="cname"></td>
			</tr>
			<tr>
				<td>전화번호 :</td>
				<td><input type="text" name="ctelno"></td>
			</tr>
			<tr>
				<td>주소 :</td>
				<td><input type="text" name="caddress"></td>
			</tr>
			<tr>
				<td>이메일 :</td>
				<td><input type="text" name="cemail"></td>
			</tr>
			<tr>
				<td><input type="submit" value="등록"> </td>
			</tr>
		</table>
	</form>
</body>
</html>