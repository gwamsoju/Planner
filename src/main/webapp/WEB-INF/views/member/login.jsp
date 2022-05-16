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
    <style type="text/css">
        .wrapper {
            display: grid;
            place-items: center;
            min-height: 100vh;
        }

        .content {
            font-family: system-ui, serif;
            font-size: 1rem;
            padding: 1rem;
            border-radius: 2rem;
        }
    </style>
</head>
<body>
<div  class="wrapper" >
    <div class="content" style="border: 1px solid gray">
        <form method="post" action="/member/loginProc.do">
            <h1>Login</h1>
            <label for="id">ID</label><br>
                <input type="text" id="id" name="id" placeholder="아이디 입력"><br>
            <label for="pwd">Password</label><br>
            <input type="password" id="pwd" name="pwd" placeholder="비밀번호 입력">&nbsp<input type="submit" value="로그인"><br><br>
            <input type="button" value="회원 가입" onclick="location.href='/member/join.do'">
        </form>
    </div>
</div>
</body>
</html>

