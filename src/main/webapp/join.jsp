<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원가입</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      margin: 0 auto;
      width: 500px;
    }
  </style>
</head>
<body onload="initializePage()" class="bg-light">
  <div class="container py-5">
    <h1 class="text-center mb-4">회원가입</h1>
    <form action="join.do" method="post" name="join" class="bg-white p-4 rounded shadow-sm">
      <div class="mb-3">
        <label for="cid" class="form-label">ID:</label>
        <input type="text" name="cid" id="cid" class="form-control" placeholder="아이디는 영문자와 숫자로 이루어진 5~12자로 입력해주세요">
      </div>
      <div class="mb-3">
        <label for="cpw" class="form-label">PASSWORD:</label>
        <input type="password" name="cpw" id="cpw" class="form-control" placeholder="비밀번호는 영문자, 숫자, 특수문자가 포함된 8~16자로 입력해주세요">
      </div>
      <div class="mb-3">
        <label for="pwc" class="form-label">비밀번호 확인:</label>
        <input type="password" name="pwc" id="pwc" class="form-control" placeholder="비밀번호를 재입력 해주세요">
      </div>
      <div class="mb-3">
        <label for="cname" class="form-label">이름:</label>
        <input type="text" name="cname" id="cname" class="form-control" placeholder="한글, 영문만 입력해 주세요">
      </div>
      <div class="mb-3">
        <label for="ctelno" class="form-label">전화번호:</label>
        <input type="text" name="ctelno" id="ctelno" class="form-control" placeholder="휴대폰 번호를 '-'을 포함해서 입력해주세요">
      </div>
      <div class="mb-3">
        <label for="caddress" class="form-label">주소:</label>
        <input type="text" name="caddress" id="caddress" class="form-control" placeholder="주소는 한글과 숫자로 입력해주세요">
      </div>
      <div class="mb-3">
        <label for="cemail" class="form-label">이메일:</label>
        <input type="text" name="cemail" id="cemail" class="form-control" placeholder="이메일 주소를 입력해주세요">
      </div>
      <div class="text-center">
        <button type="button" class="btn btn-primary" onclick="checkCustomer()">등록</button>
        <a href="loginview.do" class="btn btn-secondary">돌아가기</a>
      </div>
    </form>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  <script type="text/javascript">
    function initializePage() {
      const msg = '${msg}';

      if (msg.length !== 0) {
        alert(msg);
        document.join.cid.select();
      }
    }

    function checkCustomer() {
      const regExpId = /^[a-zA-Z0-9]{5,12}$/;
      const regExpAdmin = /^(admin|root|delete|insert|update|select)$/;
      const regExpPw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^&*])(?=.*[0-9]).{8,16}$/;
      const regExpName = /^[가-힣|a-z|A-Z]*$/;
      const regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/;
      const regExpAddress = /^[가-힣|0-9| ]*$/;
      const regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

      const form = document.join;
      const id = form.cid.value;
      const pw = form.cpw.value;
      const pwc = form.pwc.value;
      const name = form.cname.value;
      const telno = form.ctelno.value;
      const address = form.caddress.value;
      const email = form.cemail.value;

      if (!regExpId.test(id)) {
        alert("아이디는 영문자와 숫자로 이루어진 5~12자로 입력해주세요");
        form.cid.select();
        return;
      }
      if (regExpAdmin.test(id)) {
        alert("사용하실 수 없는 아이디입니다.");
        form.cid.select();
        return;
      }

      if (id.length === 0) {
        alert("아이디를 입력해주세요");
        form.cid.select();
        return;
      }

      if (!regExpPw.test(pw)) {
        alert("비밀번호는 영문자, 숫자, 특수문자가 포함된 8~16자로 입력해주세요");
        form.cpw.select();
        return;
      }

      if (pw.length === 0) {
        alert("비밀번호를 입력해주세요");
        form.cpw.select();
        return;
      }

      if (pwc.length === 0) {
        alert("비밀번호를 재입력 해주세요");
        form.pwc.select();
        return;
      }

      if (pw !== pwc) {
        alert("비밀번호가 일치하지 않습니다.");
        form.cpw.select();
        return;
      }

      if (!regExpName.test(name)) {
        alert("한글, 영문만 입력해 주세요");
        form.cname.select();
        return;
      }

      if (name.length === 0) {
        alert("이름을 입력해주세요");
        form.cname.select();
        return;
      }

      if (!regExpPhone.test(telno)) {
        alert("연락처 입력을 확인해 주세요");
        form.ctelno.select();
        return;
      }

      if (telno.length === 0) {
        alert("연락처를 입력해주세요");
        form.ctelno.select();
        return;
      }

      if (!regExpAddress.test(address)) {
        alert("주소는 한글과 숫자로 입력해주세요");
        form.caddress.select();
        return;
      }
      if (address.length === 0) {
        alert("주소를 입력해주세요");
        form.caddress.select();
        return;
      }

      if (!regExpEmail.test(email)) {
        alert("이메일 입력을 확인해 주세요");
        form.cemail.select();
        return;
      }

      if (email.length === 0) {
        alert("이메일을 입력해주세요");
        form.cemail.select();
        return;
      }

      form.submit();
    }
  </script>
</body>
</html>
