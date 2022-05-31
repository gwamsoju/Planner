<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="/js/Memo.js"></script>
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
