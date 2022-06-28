<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-13
  Time: 오후 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Hi Planner</title>
    <script type="text/javascript" src="/js/Member.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-display-container" style="height:100%">
    <div class="w3-padding w3-display-middle w3-border">
        <form method="post" action="/login/result">
            <h1>Login</h1>
            <label for="username">ID</label><br>
            <input type="text" id="username" name="username" placeholder="아이디 입력"><br>
            <label for="password">Password</label><br>
            <input type="password" id="password" name="password" placeholder="비밀번호 입력">&nbsp
            <input type="submit" class="w3-button w3-blue" value="로그인" onclick="loginCheck()"><br><br>
            <input type="button" value="회원 가입" class="w3-button w3-black" id="jbtn" onclick="joinForm()">
        </form>
    </div>
</div>
</body>
</html>

