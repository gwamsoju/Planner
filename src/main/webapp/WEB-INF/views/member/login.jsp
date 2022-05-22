<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-13
  Time: 오후 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hi Planner</title>
    <script type="text/javascript" src=""></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style type="text/css">
        .wrapper {
            display: grid;
            place-items: center;
            min-height: 90vh;
        }

        .content {
            font-family: system-ui, serif;
            font-size: 1rem;
            padding: 1rem;
            border-radius: 2rem;
        }
    </style>
    <script type="text/javascript">
        function loginCheck() {
            var id = document.getElementById("id");
            var pwd = document.getElementById("pwd");

            if (id.value == "") {
                alert("아이디를 입력해주세요.");
                return false;
            }else if(pwd.value == ""){
                alert("비밀번호를 입력해주세요.");
                return false;
            }
            return true;

        }
    </script>
</head>
<body>
    <div  class="wrapper" >
        <div class="content" style="border: 1px solid gray">
            <form method="post" action="/members/login">
                <h1>Login</h1>
                <label for="id">ID</label><br>
                    <input type="text" id="id" name="id" placeholder="아이디 입력"><br>
                <label for="pwd">Password</label><br>
                <input type="password" id="pwd" name="pwd" placeholder="비밀번호 입력">&nbsp<input type="submit" class="w3-button w3-blue" value="로그인" onclick="loginCheck()"><br><br>
                <input type="button" value="회원 가입" class="w3-button w3-black" onclick="location.href='/members/join'">
            </form>
        </div>
    </div>
</body>
</html>

