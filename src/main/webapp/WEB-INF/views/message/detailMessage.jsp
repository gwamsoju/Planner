<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
            <span>${message.sendId}</span>
            <span class="w3-right">${message.createAt}</span>
        </td>
    </tr>
    <tr class="w3-light-grey">
        <th>내용</th>
    </tr>
    <tr>
        <td class="w3-white">
            <textarea cols=40 rows=10 readonly="readonly">${message.mesCon}</textarea>
        </td>
    </tr>
</table>
<br>
<div class="w3-center w3-bar">
    <button class="w3-blue w3-bar-item" onclick>답장하기</button>
    <button class="w3-black w3-bar-item" onclick="location.href=''">메인 화면으로 이동</button>
    <button class="w3-red w3-bar-item" onclick="location.href=''">메시지 삭제</button>
</div>
</body>
</html>
