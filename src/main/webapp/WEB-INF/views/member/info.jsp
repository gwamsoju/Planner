<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-16
  Time: 오후 8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hi Planner</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style type="text/css">
        .wrapper {
            display: grid;
            place-items: center;
            min-height: 80px;
        }

        .content {
            font-family: system-ui, serif;
            font-size: 1rem;
            padding: 1rem;
            border-radius: 2rem;
        }
    </style>
    <script type="text/javascript">
        function passConfirm(){
            const pwd = document.getElementById('pwd');
            const pwd_re = document.getElementById('pwd_re');
            const message = document.getElementById('message');

            if(pwd.value == pwd_re.value){
                message.innerHTML = "비밀번호 일치";
                message.style.color = 'green';
            }else{
                message.innerHTML = "비밀번호 불일치";
                message.style.color = 'red';
            }
        }
    </script>
</head>
<body>
<div class="w3-black w3-bar">
    <input type="button" value="로그아웃" class="w3-red w3-bar-item w3-right" onclick="location.href='/members/logout'"/>
    <button type="button" class="w3-green w3-left  w3-bar-item" onclick="location.href='/messages'">메시지</button>
</div>
<div class="wrapper">
    <div class="content" style="border: 1px solid gray">
        <h1 style="text-align: center">Member Info</h1>
        <form method="post" action="/members/${id}/update">
        <div>
            <label for="name">이&nbsp&nbsp 름 : </label>
            <input type="text" name="name" id="name" value="${member.name}" readonly="readonly"/>
        </div><br>
        <div>
            <label for="id">아이디 : </label>
            <input type="text" name="id" id="id" value="${member.id}" readonly="readonly"/>
        </div><br>
        <div>
            <label for="pwd">비밀번호 : </label>
            <input type="password" name="pwd" id="pwd"/>
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
                <input class="w3-red" type="button" value="회원 탈퇴" onclick="location.href='/members/delete'"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
