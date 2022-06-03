<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-27
  Time: 오후 5:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Hi Planner</title>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script type="text/javascript" src="/js/Message.js"></script>
  <script type="text/javascript">
    function SelectMessage(){

      $.ajax({
        type:"GET",
        url:"/messages/{message.mesNo}/message",
        data:{"mesNo" : $("#mesNo1").val()},
        dataType:"text",
        success:function(result){
          $("#MessageForm").css("display","none");
          $("#MessageBox").css("display","block");
          $("#MessageBox").html(result);
        },
        error:function(request,status,error){
          alert("code:" +request.status + "\n"+"message:" +request.responseText + "\n" + "error:" + error);
        }
      });
    }
  </script>
</head>
<body>
  <div class="w3-black w3-bar">
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
  </div>
  <div class="w3-sidebar w3-bar-block w3-card" style="width:20%;left:0;">
    <p class="w3-large w3-center">Message List
    <button type="button" class="w3-right w3-button w3-teal" onclick="messageForm()">메시지 작성</button></p>
    <hr>
    <div id="MessageList" >
      <c:if test="${messageList.size() eq 0}">
        <div class="w3-center w3-large">메시지가 없습니다.</div>
      </c:if>
      <c:if test="${messageList.size() ne 0}">
        <c:forEach items="${messageList}" var="message">
          <div class="w3-border w3-container w3-margin-top" >
                <input type="hidden" name="mesNo1" id="mesNo1" value="${message.mesNo}"/>
                 <a onclick="SelectMessage()">${message.sendId}님이 보낸 쪽지입니다.</a><br>
                ${message.createdAt}
          </div>
        </c:forEach>
      </c:if>
    </div>
  </div>
  <div class="w3-display-container" style="height:80%">
    <div class="w3-padding w3-display-middle ">
      <div id="MessageBox" name="MessageBox"  class="w3-border" style="display: none">
        <!-- detailMessage.jsp가 여기로 들어옴. -->
      </div>
      <div id="MessageForm" name="MessageForm" class="w3-border" style="display:none">
        <span class="w3-center"><h1>Message</h1></span>
        <form method="post" action="/messages/write" onsubmit="return MessageCheck()">
          <input type="hidden" name="sendId" id="sendId" value="${id}"/>
          <table class="w3-table-all">
            <tr class="w3-light-grey">
              <th>
                <label for="recvId">받는 사람</label>
              </th>
            </tr>
            <tr class="w3-white">
              <td>
                <input type="text" name="recvId" id="recvId" style="width:30%"/>
              </td>
            </tr>
            <tr class="w3-light-grey">
              <th>내용</th>
            </tr>
            <tr>
              <td class="w3-white">
                <textarea name="mesCon" id="mesCon" cols=40 rows=10></textarea>
              </td>
            </tr>
          </table>
          <br>
          <div class="w3-center">
            <input type="submit" class="w3-blue " value="보내기" />
            <input type="reset" class="w3-red " value="다시 작성"/>
          </div>
        </form>
      </div>
    </div>
  </div>
</body>
</html>
