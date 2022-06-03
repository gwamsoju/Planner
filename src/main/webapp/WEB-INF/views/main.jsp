<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-13
  Time: 오후 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hi Planner</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="/js/Main.js"></script>
</head>
<body>
<div class="w3-black w3-bar">
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
</div>
    <div class="w3-center">
        <h1>What To Do Today !</h1>
        <form method="get">
            <input type="date" name="begin1" id="begin1" value="${begin}"/>&nbsp
            <button type="button" class="w3-pale-yellow" onclick="otherDay()" >보기</button>
            <input type="hidden" name="id" id="id" value="${id}"/>
        </form>
    </div>
    <div class="w3-display-container"  style="height:40%">
        <div class="w3-padding w3-display-middle w3-border" id="frm">
            <label for="begin">Date</label><br>
            <span name="begin" id="begin">${begin}</span><br>
            <hr>
            <c:if test="${memoList.size() eq 0}">
                등록된 일정이 없습니다.
            </c:if>
            <c:if test="${memoList.size() ne 0}">
                <c:forEach items="${memoList}" var="memo">
                    <a onclick="location.href='/planners/${memo.planno}/Detail'" >
                            ${memo.title}</a>&nbsp&nbsp ${memo.content}<br>
                    <hr>
                </c:forEach>
            </c:if>
            <div style="position:relative; width:300px; height: 60px;">
                <div style="position : absolute; clear:left; float:right; width:300px; height:50px; left:0; bottom:0px;">
                    <input type="button" id="wbtn" onclick="location.href='/planners/write'"
                           value="+" class="w3-button w3-circle w3-deep-orange w3-right"/>
                </div>
            </div>
         </div>
        <div class="w3-padding w3-display-middle w3-border" id="frm2" style="display:none">

        </div>
    </div>
</div>
</body>
</html>