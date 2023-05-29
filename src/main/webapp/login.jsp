<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>로그인 화면</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body onload="initializePage()" class="bg-light">
  <div class="container py-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <h1 class="text-center mb-4">로그인</h1>
        <form action="login.do" method="post" name="login" class="bg-white p-4 rounded shadow-sm">
          <div class="mb-3">
            <label for="cid" class="form-label">ID:</label>
            <input type="text" name="cid" id="cid" class="form-control">
          </div>
          <div class="mb-3">
            <label for="cpw" class="form-label">Password:</label>
            <input type="password" name="cpw" id="cpw" class="form-control">
          </div>
          <div class="text-center">
            <button type="button" class="btn btn-primary" onclick="checklogin()">Login</button>
          </div>
          <div class="text-center mt-3">
            아직 회원이 아니신가요? <a href="joinview.do">회원가입</a>
          </div>
        </form>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  <script type="text/javascript">
    function initializePage() {
      const msg = '${msg}';
      
      if (msg.length !== 0) {
        alert(msg);
        document.login.cid.select();
      }
    }

    function checklogin() {
      const form = document.login;
      const id = form.cid.value;
      const pw = form.cpw.value;
      
      if (id.length === 0) {
        alert("아이디를 입력해주세요");
        form.cid.select();
        return;
      }
      
      if (pw.length === 0) {
        alert("비밀번호를 입력해주세요");
        form.cpw.select();
        return;
      }
      
      form.submit();
    }
  </script>
</body>
</html>
