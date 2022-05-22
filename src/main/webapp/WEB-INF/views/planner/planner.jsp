<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-19
  Time: 오후 10:53
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
    <h1>What To Do Today !</h1><br>
    <form method="get" action="/planners/">
        <input type="date" name="begin"/> <input type="submit" value="보기"/>
    </form>
    <div class="content " style="border: 1px solid gray ">
        <c:forEach items="${memoList}" var="memo" begin="1" end="1" step="1">
             <label for="begin">Date</label><br>
            <span name="begin" id="begin">${memo.begin}</span><br>
            <hr>
        </c:forEach>
        <c:forEach items="${memoList}" var="memo">
            <a onclick="location.href='/planners/${do_num}/Detail'" >${memo.do_num} ${memo.title}</a>&nbsp&nbsp ${memo.content}<br>
            <hr>
        </c:forEach>
        <div style="position:relative; width:300px; height: 60px;">
            <div style="position : absolute; clear:left; float:right; width:300px; height:50px; left:0; bottom:0px;">
                <input type="button" value="+" onclick="location.href='/planners/write'"
                       class="w3-button w3-circle w3-deep-orange w3-right">
            </div>
        </div>
    </div>
</div>
</body>
</html>

