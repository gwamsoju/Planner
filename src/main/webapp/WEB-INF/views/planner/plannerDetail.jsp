<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-19
  Time: 오후 4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hi Planner</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-dark-gray">
    <p style="text-align: right">
        <strong>${id}</strong>님 환영합니다.<br>
        <input type="button" value="내 정보" class="w3-blue" onclick="location.href='/member/getInfo.do?id=${id}'"/>
        <input type="button" value="로그아웃" class="w3-red" onclick="location.href='/member/logoutProc.do'"/>
    </p>
</div>
${memoDetail.title}
</body>
</html>
