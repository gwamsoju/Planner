<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-21
  Time: 오후 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Hi Planner</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<div class="w3-black w3-bar">
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
</div>
<div class="w3-display-container" style="height:30%">
    <div class="w3-padding w3-display-middle w3-border">
        <form method="post" action="/members/${id}/delete">
            <h3>회원 탈퇴를 원하시면 아래에 비밀번호를 입력해주세요.</h3>
            <input type="password" id="pwd" name="pwd" placeholder="비밀번호 입력">
            &nbsp<input type="submit" class="w3-red" value="회원 탈퇴"/>
        </form>
    </div>
</div>
</body>
</html>
