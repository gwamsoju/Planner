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
        }
        .content {
            font-family: system-ui, serif;
            font-size: 1rem;
            padding: 10px;

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

<div class="wrapper">
    <h1>What To Do Today !</h1>
    <div class="content" style="border: 1px solid gray ">

            <c:forEach items="${memoList}" var="memo" >
                <label for="begin">Date</label><br>
                <span name="begin" id="begin">${memo.begin}</span><br><br>
                <hr>
               ${memo.title}<br>
                <hr>
            </c:forEach>
        <div style="position:relative; width:300px; height:300px;">
            <div style="position : absolute; clear:left; float:right; width:300px; height:50px; left:0; bottom:0px;">
                <input type="button" value="일정 추가" onclick="location.href='/planner/writeFrom.do'">
                <input type="button" value="일정 수정" onclick="location.href=''">
                <input type="button" value="일정 삭제" onclick="location.href=''">
            </div>
        </div>
    </div>
</div>
</body>
</html>
