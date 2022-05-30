<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-21
  Time: 오후 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="w3-black w3-bar">
    <input type="button" value="로그아웃" class="w3-red w3-bar-item w3-right" onclick="location.href='/members/logout'"/>
    <input type="button" value="마이페이지" class="w3-blue w3-bar-item w3-right" onclick="location.href='/members/${id}'"/>
    <button type="button" class="w3-green w3-left  w3-bar-item" onclick="location.href='/messages'">메시지</button>
</div>
    <div  class="wrapper" >
        <div class="content" style="border: 1px solid gray">
            <form method="post" action="/members/${id}/delete">

                <h3>회원 탈퇴를 원하시면 아래에 비밀번호를 입력해주세요.</h3>
                <input type="password" id="pwd" name="pwd" placeholder="비밀번호 입력">
                &nbsp<input type="submit" class="w3-red" value="회원 탈퇴"/>
            </form>
        </div>
    </div>
</body>
</html>
