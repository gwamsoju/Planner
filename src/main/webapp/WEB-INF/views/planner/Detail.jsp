<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-19
  Time: 오후 4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Hi Planner</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script type="text/javascript">
        function deletePlan(){
            window.location='/planners/${memoDetail.planno}/delete';
        }
    </script>
</head>
<body>
<div class="w3-black w3-bar">
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
</div>
<div class="w3-display-container" style="height:50%">
    <div class="w3-padding w3-display-middle w3-border">
        <form method="post" action="/planners/${memoDetail.planno}/edit">
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
                <input type="button" class="w3-red" value="일정 삭제" onclick="deletePlan()"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
