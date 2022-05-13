<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-13
  Time: 오후 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="wrapper">
    <div class="content" style="border: 1px solid gray">
        <H1>회원 가입</H1><br>
        <form method="post" action="/member/joinProc.do">
            <div>
                <label for="name">이름</label>
                <input name="name" id="name" type="text" placeholder="이름을 입력해주세요."/>
            </div><br>
            <div>
                <label for="id">아이디</label>
                <input name="id" id="id" type="text" placeholder="아이디 입력"/>
                <input type="button" value="중복 체크"/>
            </div><br>
            <div>
                <label for="pwd">비밀번호</label>
                <input name="pwd" id="pwd" type="password" placeholder="비밀번호 입력"/>
            </div><br>
            <div>
                <label for="pwd_re">비밀번호 확인</label>
                <input name="pwd_re" id="pwd_re" type="password" placeholder="비밀번호 한 번 더 입력."/>
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
                <input name="phone" id="phone" type="text" placeholder="'-'도 입력"/>
            </div><br><br>
            <div>
                <input type="submit" value="가입하기"/>
                <input type="reset" value="다시 작성"/>
                <input type="button" value="로그인 화면으로" onclick="location.href='/'"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
