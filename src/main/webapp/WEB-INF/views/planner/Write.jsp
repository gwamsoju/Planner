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
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style type="text/css">
        .wrapper {
            display: grid;
            place-items: center;
            min-height: 50vh;
        }

        .content {
            font-family: system-ui, serif;
            font-size: 1rem;
            padding: 1rem;

        }
    </style>
</head>
<body>
<div class="w3-dark-gray">
    <p style="text-align: right">
        <strong>${Data}</strong>님 환영합니다.<br>
        <input type="button" value="로그아웃" class="w3-red" onclick="location.href='/members/logout'"></input>
    </p>
</div>

<div class="wrapper" >
    <div class="content" style="border: 1px solid gray">
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
