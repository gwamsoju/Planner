<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-16
  Time: 오후 1:29
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
<div style="background: darkgray">
    <p style="text-align: right">
        <strong>${Data}</strong>님 환영합니다.<br>
        <input type="button" value="로그아웃" onclick="location.href='/member/logoutProc.do'"></input>
    </p>
</div>

<div class="wrapper">
    <div class="content">
        <h1>Write Do!</h1>
        <form method="post" action="/planner/writeFinish.do">
            <div>
                <label for="title">제목</label>
                <input type="text" id="title" name="title"/><br><br>
            </div>
            <div>
                <label for="content">내용</label>
                <textarea  id="content" name="content" cols="30" rows="5" ></textarea>
            </div>
            <br><br>
            <input type="submit" value="작성"/>
            <input type="reset" value="다시 작성"/>
        </form>
    </div>
</div>
</body>
</html>
