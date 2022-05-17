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
        <strong>${id}</strong>님 환영합니다.<br>
        <input type="button" value="내 정보" onclick="location.href='/member/getInfo.do?id=${id}'"/>
        <input type="button" value="로그아웃" onclick="location.href='/member/logoutProc.do'"/>
    </p>
</div>
<h1>To Do This Week !</h1>
<input type="button" value="일정 추가" onclick="location.href='/planner/writeFrom.do'">
<input type="button" value="일정 수정" onclick="location.href=''">
<input type="button" value="일정 삭제" onclick="location.href=''">
<div class="wrapper">
    <div class="content">
        <c:forEach items="${memoList}" var="memo" >
            ${memo.title}<br>
            ${memo.content}
        </c:forEach>
    </div>
</div>
</body>
</html>
