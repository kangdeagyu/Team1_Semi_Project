<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function checkCustomer(){
	
	const regExpId = /^[a-zA-Z0-9]{5,12}$/ // 아이디는 영문자와 숫자로 이루어진 5~12자여야 함
	const regExpAdmin = /^(admin|root)$/
	const regExpPw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^&*])(?=.*[0-9]).{8,16}$/ // 비밀번호는 영문자, 숫자, 특수문자가 포함된 8~16자여야 함
	const regExpName = /^[가-힣|a-z|A-Z]*$/
	const regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/
	const regExpAddress = /^[가-힣|0-9| ]*$/
	const regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
	// *$ 다 포함한다
	
	const form = document.join
	const id = form.cid.value
	const pw = form.cpw.value
	const pwc = form.pwc.value
	const name = form.cname.value
	const telno = form.ctelno.value
	const address = form.caddress.value
	const email = form.cemail.value

	if(!regExpId.test(id)){
		alert("아이디는 영문자와 숫자로 이루어진 5~12자로 입력해주세요")
		form.cid.select()
		return
	}
	if(regExpAdmin.test(id)){
		alert("사용하실 수 없는 아이디 입니다.")
		form.cid.select()
		return
	}
	
	if(id.length == 0){
		alert("아이디를 입력해주세요")
		form.cid.select()
		return
	}
	
	if(!regExpPw.test(pw)){
		alert("비밀번호는 영문자, 숫자, 특수문자가 포함된 8~16자로 입력해주세요")
		form.cpw.select()
		return
	}
	
	if(pw.length == 0){
		alert("비밀번호를 입력해주세요")
		form.cpw.select()
		return
	}
	
	if(pwc.length == 0){
		alert("비밀번호를 재입력 해주세요")
		form.pwc.select()
		return
	}
	
	if(pw != pwc){
		alert("비밀번호가 일치하지 않습니다.")
		form.cpw.select()
		return
	}
	
	if(!regExpName.test(name)){
		alert("한글, 영문만 입력해 주세요")
		form.cname.select()
		return
	}
	
	if(name.length == 0){
		alert("이름을 입력해주세요")
		form.cname.select()
		return
	}
	
	if(!regExpPhone.test(telno)){
		alert("연락처 입력을 확인해 주세요")
		form.ctelno.select()
		return
	}
	
	if(telno.length == 0){
		alert("연락처를 입력해주세요")
		form.ctelno.select()
		return
	}
	
	if(!regExpAddress.test(address)){
		alert("주소는 한글과 숫자로 입력해주세요")
		form.caddress.select()
		return
	}
	if(address.length == 0){
		alert("주소를 입력해주세요")
		form.caddress.select()
		return
	}

	if(!regExpEmail.test(email)){
		alert("이메일 입력을 확인해 주세요")
		form.cemail.select()
		return
	}
	
	if(email.length == 0){
		alert("이메일을 입력해주세요")
		form.cemail.select()
		return
	}

	form.submit()
}
</script>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="join.do" method="post" name="join">
		<table>
			<tr>
				<td>ID :</td>
				<td><input type="text" name="cid" placeholder="아이디는 영문자와 숫자로 이루어진 5~12자로 입력해주세요"></td>
			</tr>
			<tr>
				<td>PASSWORD :</td>
				<td><input type="text" name="cpw" placeholder="비밀번호는 영문자, 숫자, 특수문자가 포함된 8~16자로 입력해주세요"></td>
			</tr>
			<tr>
				<td>비밀번호 확인 :</td>
				<td><input type="text" name="pwc" placeholder="비밀번호를 재입력 해주세요"></td>
			</tr>
			<tr>
				<td>이름 :</td>
				<td><input type="text" name="cname" placeholder="한글, 영문만 입력해 주세요"></td>
			</tr>
			<tr>
				<td>전화번호 :</td>
				<td><input type="text" name="ctelno" placeholder="휴대폰 번호를 '-'을 포함해서 입력해주세요" ></td>
			</tr>
			<tr>
				<td>주소 :</td>
				<td><input type="text" name="caddress" placeholder="주소는 한글과 숫자로 입력해주세요"></td>
			</tr>
			<tr>
				<td>이메일 :</td>
				<td><input type="text" name="cemail" placeholder="이메일 주소를 입려갷주세요"></td>
			</tr>
			<tr>
				<td><input type="button" value="등록" onclick="checkCustomer()" > </td>
			</tr>
		</table>
	</form>
</body>
</html>