<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-27
  Time: 오후 5:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Hi Planner</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <style type="text/css">
        .wrapper {
            display: grid;
            place-items: center;
            min-height: 80vh;
        }
        .content {
            font-family: system-ui, serif;
            font-size: 1rem;
            padding: 5px;
        }
    </style>
    <script type="text/javascript">
        function messageForm(){
            $("#messageForm").css("display","block");
        }
    </script>
</head>
<body>
    <div class="w3-black w3-bar">
        <input type="button" value="로그아웃" class="w3-red w3-bar-item w3-right" onclick="location.href='/members/logout'"/>
        <input type="button" value="마이페이지" class="w3-blue w3-bar-item w3-right" onclick="location.href='/members/${id}'"/>
        <button type="button" class="w3-green w3-bar-item w3-left" onclick="location.href='/messages/message'">메시지</button>
    </div>
    <div class="w3-sidebar w3-bar-block w3-card" style="width:20%;left:0;">
        <p class="w3-large w3-center">Message List</p>
        <hr>
        <div id="MessageList" >
            <c:forEach items="${messageList}" var="message">
               <div class="w3-border w3-container w3-margin-top" >
               </div>
            </c:forEach>
        </div>
        <button type="button" class="w3-right w3-button w3-teal" onclick="messageForm()">메시지 작성</button>
    </div>
    <div class="wrapper">
        <div class="content" >
            <div id="messageBox"  style="display: none">
               <span class="w3-center"><h1>Message</h1></span>
                <table class="w3-table-all">
                    <tr class="w3-light-grey">
                        <th>
                            <span>보낸 사람</span>
                            <span class="w3-right">작성일</span>
                        </th>
                    </tr>
                    <tr class="w3-white">
                        <td>
                            <span>wodud</span>
                            <span class="w3-right">2022-05-27</span>
                        </td>
                    </tr>
                    <tr class="w3-light-grey">
                        <th>내용</th>
                    </tr>
                    <tr>
                        <td class="w3-white">
                            <textarea cols=40 rows=10></textarea>
                        </td>
                    </tr>
                </table>
                <br>
                <div class="w3-center w3-bar">
                    <button class="w3-blue w3-bar-item" onclick>답장하기</button>
                    <button class="w3-black w3-bar-item" onclick="location.href=''">메인 화면으로 이동</button>
                    <button class="w3-red w3-bar-item" onclick="location.href=''">메시지 삭제</button>
                </div>
            </div>
            <div id="messageForm" name="messageForm" style="display: none">
                <span class="w3-center"><h1>Message</h1></span>
                <form method="post" action="/messages/write">
                    <input type="hidden" name="send_id" id="send_id" value="${id}"/>
                    <table class="w3-table-all">
                            <tr class="w3-light-grey">
                                <th>
                                    <label for="recv_id">받는 사람</label>
                                </th>
                            </tr>
                            <tr class="w3-white">
                                <td>
                                    <input type="text" name="recv_id" id="recv_id" style="width:30%"/>
                                </td>
                            </tr>
                            <tr class="w3-light-grey">
                                <th>내용</th>
                            </tr>
                            <tr>
                                <td class="w3-white">
                                    <textarea name="mes_con" id="mes_con" cols=40 rows=10></textarea>
                                </td>
                            </tr>
                    </table>
                    <br>
                    <div class="w3-center ">
                        <input type="submit" class="w3-blue " value="보내기"/>
                        <button type="button" class="w3-black ">뒤로 가기</button>
                        <input type="reset" class="w3-red " value="다시 작성"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
