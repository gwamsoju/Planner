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
            <h3>회원 탈퇴를 하시겠습니까? ('회원 탈퇴' 클릭시 바로 탈퇴, '아니요' 클릭시 이전 화면으로 이동)</h3><br>
            <div class="w3-center">
            <input type="submit" class="w3-button w3-red" value="회원 탈퇴" />
            <input type="reset" class="w3-button w3-blue" value="아니요" onclick="history.go(-1)"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
