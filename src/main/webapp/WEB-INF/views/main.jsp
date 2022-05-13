<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-13
  Time: 오후 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<div style="background: darkgray">
    <p style="text-align: right">
        <strong>${Data}</strong>님 환영합니다.<br>
        <input type="button" value="로그아웃" onclick="location.href='/member/logoutProc.do'"></input>
    </p>
</div>
<div class="wrapper">
    <div class="content">
        To Do This Week !
    </div>
</div>
</body>
</html>
