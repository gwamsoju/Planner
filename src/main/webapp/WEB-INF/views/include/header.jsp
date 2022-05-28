<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-30
  Time: 오후 4:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <button type="button" class="w3-red w3-bar-item w3-right" onclick="location.href='/members/logout'"/>로그아웃</button>
    <button type="button" class="w3-blue w3-bar-item w3-right" onclick="location.href='/members/${id}'"/>마이페이지</button>
    <button type="button" class="w3-green w3-left w3-bar-item" onclick="location.href='/messages'">메시지</button>
</body>
</html>
