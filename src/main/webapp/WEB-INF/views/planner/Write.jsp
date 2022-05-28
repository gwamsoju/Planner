<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-16
  Time: 오후 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        <h1>Write Do!</h1>
        <form method="post" action="/planners/write">
            <div>
                <label for="begin">시작일</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                &nbsp&nbsp&nbsp<label for="end">종료일</label><br>
                <input type="date" id="begin" name="begin"/> ~  <input type="date" id="end" name="end"/><br><br>
            </div>
            <div>
                <label for="title">제목</label>
                <label for="content">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp내용</label><br>
                <input type="text" id="title" name="title"/>
                <input type="text" id="content" name="content"/>
            </div>
            <br><br>
            <input type="submit" class="w3-teal" value="작성"/>
            <input type="reset" class="w3-black" value="다시 작성"/>
        </form>
    </div>
</div>
</body>
</html>
