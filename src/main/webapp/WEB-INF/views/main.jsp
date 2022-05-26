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
    <script type="text/javascript">
        function otherDay(){

            var id = $("#id").val();
            var begin = $("#begin1").val();

            $.ajax({
                type:"GET",
                url:"/planners/${begin}",
                data: {"id":id, "begin": begin},
                dataType: "text",
                success:function(result){
                    $("#frm").css("display","none");
                    $("#frm2").css("display","block");
                    $("#frm2").html(result);
                },
                error:function(request,status,error){
                    alert("code:" +request.status + "\n"+"message:" +request.responseText + "\n" + "error:" + error);
                }
            });
        }
    </script>
</head>
<body>
<div class="w3-dark-gray">
    <p style="text-align: right">
        <strong>${id}</strong>님 환영합니다.<br>
        <input type="button" value="내 정보" class="w3-blue" onclick="location.href='/members/${id}'"/>
        <input type="button" value="로그아웃" class="w3-red" onclick="location.href='/members/logout'"/>
    </p>
</div>
<div class="wrapper">
    <h1>What To Do Today !</h1><br>
    <form method="get">
        <input type="date" name="begin1" id="begin1" value="${begin}"/>&nbsp<button type="button" onclick="otherDay()" >보기</button>
        <input type="hidden" name="id" id="id" value="${id}"/>
    </form>
    <div class="content" name="frm" id="frm" style="border: 1px solid gray ">
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
                <input type="button" value="+" onclick="location.href='/planners/write'"
                       class="w3-button w3-circle w3-deep-orange w3-right">
            </div>
        </div>
    </div>
    <div class="content" id="frm2" name="frm2" style="display:none ;border: 1px solid gray ">

    </div>
</div>
</body>
</html>
