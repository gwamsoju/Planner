<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-13
  Time: 오후 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Hi Planner</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="/js/Member.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-display-container" style="height:100%">
    <div class="w3-padding w3-display-middle w3-border">
        <h1>회원 가입</h1><br>
        <form method="post" action="/members/join" onsubmit="return joinConfirm()">
            <div>
                <label for="id">아이디</label>
                <input name="id" id="id" type="text" placeholder="아이디 입력"/>
                <input type="button" class="w3-teal" value="중복 체크" onclick="idCheck()"/>
            </div><br>
            <div>
                <label for="name">이름</label>
                <input name="name" id="name" type="text" placeholder="이름을 입력해주세요."/>
            </div><br>

            <div>
                <label for="pwd">비밀번호</label>
                <input name="pwd" id="pwd" type="password" placeholder="비밀번호 입력"/>
            </div><br>
            <div>
                <label for="pwd_re">비밀번호 확인</label>
                <input name="pwd_re" id="pwd_re" type="password" placeholder="비밀번호 한 번 더 입력." onchange="passConfirm()"/><br>
                <span id="message"></span>
            </div><br>
            <div>
                <label for="mail">이메일</label>
                <input name="mail" id="mail" type="text" placeholder="이메일 입력"/>
            </div><br>
            <div>
                <label for="job">직업</label>
                <select name="job" id="job">
                    <option value="학생">학생</option>
                    <option value="직장인">직장인</option>
                    <option value="취업준비생">취업준비생</option>
                    <option value="공시생">공시생</option>
                    <option value="직접 입력">직접입력</option>
                </select>
            </div><br>
            <div>
                <label for="phone">전화번호</label>
                <input name="phone" id="phone" type="tel" placeholder="'-'도 입력"/>
            </div><br>
            <div>
                성별
                <input type="radio" name="gender" value="M"/>남자
                <input type="radio" name="gender" value="W"/>여자
            </div><br><br>
            <div class="w3-center">
                <input type="submit" class="w3-button w3-teal" value="가입하기" />
                <input type="reset" class="w3-button w3-black" value="다시 작성"/>
                <input type="button" class="w3-button w3-blue" value="로그인 화면으로" id="lbtn" onclick="changeURL()"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
