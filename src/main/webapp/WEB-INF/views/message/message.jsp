<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-27
  Time: 오후 5:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <title>Hi Planner</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
</head>
<body>
    <div class="w3-black w3-bar">
        <input type="button" value="로그아웃" class="w3-red w3-bar-item w3-right" onclick="location.href='/members/logout'"/>
        <input type="button" value="마이페이지" class="w3-blue w3-bar-item w3-right" onclick="location.href='/members/${id}'"/>
        <button type="button" class="w3-green w3-bar-item w3-left" onclick="location.href='/messages/message'">메시지</button>
    </div>
    <div class="w3-sidebar w3-bar-block w3-card" style="width:20%;left:0;">
        <h3 class="w3-bar-item">Message</h3>
        <div id="MessageList">

        </div>
    </div>
    <div class="wrapper">
        <div class="content" >
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
    </div>
</body>
</html>
