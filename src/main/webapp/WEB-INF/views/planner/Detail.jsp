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
            border-radius: 2rem;
        }
    </style>
</head>
<body>
    <div class="w3-dark-gray">
        <p style="text-align: right">
            <strong>${id}</strong>님 환영합니다.<br>
            <input type="button" value="내 정보" class="w3-blue" onclick="location.href='/members/${id}'"/>
            <input type="button" value="로그아웃" class="w3-red" onclick="location.href='/members/logout'"/>
        </p>
    </div>
    <div  class="wrapper" >
        <div class="content" style="border: 1px solid gray">
            <form method="post" action="/planner/edit">
                <h3>메모 상세보기</h3>
                <label for="date">Date</label><br>
                <input type="text" id="date" name="date" value="${memoDetail.begin}" readonly="readonly"><hr>
                <label for="title">제목</label><br>
                <input type="text" id="title" name="title" value="${memoDetail.title}"/><br>
                <label for="content">내용</label><br>
                <input type="text" id="content" name="content" value="${memoDetail.content}"/><br><br>
                <input type="hidden" id="planno" name="planno" value="${memoDetail.planno}"/>
                <div class="w3-center">
                    <input type="submit" class="w3-teal" value="수정"/>
                    <input type="reset" class="w3-black" value="다시 작성"/>
                    <input type="button" class="w3-red" value="일정 삭제" onclick="location.href='/planners/${memoDetail.planno}/delete'"/>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
