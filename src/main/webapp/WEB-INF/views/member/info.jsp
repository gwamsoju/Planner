<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-16
  Time: 오후 8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hi Planner</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="/js/Member.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-black w3-bar">
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
</div>
<div class="w3-display-container" style="height:80%">
    <div class="w3-padding w3-display-middle w3-border">
        <h1 style="text-align: center">Member Info</h1>
        <form method="post" action="/members/${member.username}/update">
            <div>
                <label for="name">이&nbsp&nbsp 름 : </label>
                <input type="text" name="name" id="name" value="${member.name}" readonly="readonly"/>
            </div><br>
            <div>
                <label for="id">아이디 : </label>
                <input type="text" name="id" id="id" value="${member.username}" readonly="readonly"/>
            </div><br>
            <div>
                <label for="password">비밀번호 : </label>
                <input type="password" name="password" id="password"/>
            </div><br>
            <div>
                <label for="pwd_re">비밀번호 확인 : </label>
                <input type="password" name="pwd_re" id="pwd_re" onchange="passConfirm()"/><br>
                <span id="message"></span>
            </div><br>
            <div>
                <label for="job">직&nbsp&nbsp 업 : </label>
                <input type="text" value="${member.job}" readonly="readonly"/>
                <select name="job" id="job">
                    <option value="학생">학생</option>
                    <option value="직장인">직장인</option>
                    <option value="취업준비생">취업준비생</option>
                    <option value="공시생">공시생</option>
                    <option value="직접 입력">직접입력</option>
                </select>
            </div><br>
            <div>
                <label for="mail">메&nbsp&nbsp 일 : </label>
                <input type="text" name="mail" id="mail" value="${member.mail}" />
            </div><br>
            <div>
                <label for="phone">전화번호 : </label>
                <input type="tel" name="phone" id="phone" value="${member.phone}" />
            </div><br>
            <div>
                <label for="gender">성&nbsp&nbsp 별 : </label>
                <c:if test="${member.gender eq 'M'}">
                    <input type="text" name="gender" id="gender" value="남자" readonly="readonly"/>
                </c:if>
                <c:if test="${member.gender eq 'F'}">
                    <input type="text" name="gender" id="gender" value="여자" readonly="readonly"/>
                </c:if>
            </div>
            <br><br>
            <div class="w3-center">
                <input class="w3-gray" type="submit" value="정보 수정"/>
                <input class="w3-red" type="button" id="dbtn" value="회원 탈퇴" onclick="deleteForm()"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>