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
</head>
<body>
<div class="w3-black w3-bar">
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
</div>
<div class="w3-display-container" style="height:100%">
    <div class="w3-padding w3-display-middle w3-border">
        <form method="get" action="/planners/${begin}">
            <input type="hidden" value="${begin}" />
            <input class="w3-center" type="submit" value="일정 보기" />
        </form>
    </div>
</div>
</body>
</html>