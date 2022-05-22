<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-13
  Time: 오후 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hi Planner</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style type="text/css">
        .wrapper {
            display: grid;
            place-items: center;
        }
        .content {
            font-family: system-ui, serif;
            font-size: 1rem;
            padding: 5px;
        }
    </style>
</head>
<body>
<div class="w3-dark-gray">
    <p style="text-align: right">
        <strong>${id}</strong>님 환영합니다.<br>
        <input type="button" value="내 정보" class="w3-blue" onclick="location.href='/members/${id}'"/>
        <input type="button" value="로그아웃" class="w3-red" onclick="location.href='/members/logout'"/>
    </p>
</div>
<div class="wrapper">
    <div class="content">
        <form method="get" action="/planners/${begin}">
            <input type="hidden" value="${begin}" />
            <input class="w3-center" type="submit" value="일정 보기" />
        </form>
    </div>
</div>
</body>
</html>
