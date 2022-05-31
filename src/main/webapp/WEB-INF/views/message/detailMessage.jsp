<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/js/Message.js"></script>
<script type="text/javascript">
  function deleteMessage(){
    window.location='/messages/${message.mesNo}/delete';
  }
</script>
<span class="w3-center"><h1>Message</h1></span>
<table class="w3-table-all">
  <tr class="w3-light-grey">
    <span id="mesNo" name="mesNo" style="display:none" >${message.mesNo}</span>
    <th>
      <span>보낸 사람</span>
      <span class="w3-right">작성일</span>
    </th>
  </tr>
  <tr class="w3-white">
    <td>
      <span>${message.sendId}</span>
      <span class="w3-right">${message.createdAt}</span>
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
<div class="w3-center ">
  <button class="w3-blue" id="rbtn" onclick="changeURL()">답장하기</button>
  <button class="w3-red" id="mdbtn" onclick="deleteMessage()">메시지 삭제</button>
</div>
<br>

