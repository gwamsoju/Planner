<%--
  Created by IntelliJ IDEA.
  User: LEE Jaeyeong
  Date: 2022-05-13
  Time: 오후 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hi Planner</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style type="text/css">
        .wrapper {
            display: grid;
            place-items: center;
            min-height: 100vh;
        }

        .content {
            font-family: system-ui, serif;
            font-size: 1rem;
            padding: 1rem;
            border-radius: 2rem;
        }
    </style>
    <script type="text/javascript">

        function passConfirm(){
            const pwd = document.getElementById('pwd');
            const pwd_re = document.getElementById('pwd_re');
            const message = document.getElementById('message');

            if(pwd.value == pwd_re.value){
                message.innerHTML = "비밀번호 일치";
                message.style.color = 'green';
            }else{
                message.innerHTML = "비밀번호 불일치";
                message.style.color = 'red';
            }
        }

        function joinConfirm(){
            var id = document.getElementById('id');
            var name = document.getElementById('name');
            var mail = document.getElementById('mail');
            var job = document.getElementById('job');
            var phone = document.getElementById('phone');
            var gender = document.getElementById('gender');

           if(id.value == ""){
               alert('아이디를 입력해주세요.');
               id.focus();
               return false;
           }else if(name.value == ""){
               alert('이름을 입력해주세요.');
               name.focus();
               return false;
           }else if(mail.value ==""){
               alert('이메일을 입력해주세요.');
               return false;
           }else if(job.value == ""){
               alert('직업을 선택 혹은 직접 입력해주세요.');
               return false;
           }else if(phone.value == ""){
               alert('전화번호를 입력해주세요.');
               return false;
           }
           return true;
        }

        function idCheck(){
            if($("#id").val() == "" ){
                alert("아이디를 입력해주세요.");
            }else {
                $.ajax({
                    url: "/members/id/check",
                    type: "POST",
                    dataType: "JSON",
                    data: {"id": $("#id").val()},
                    success: function (data) {
                        if (data == 1) {
                            alert("중복된 아이디입니다.");
                        } else if (data == 0) {
                            alert("사용가능한 아이디입니다.");
                        }
                    }
                })
            }
        }
    </script>
</head>
<body>
<div class="wrapper">
    <div class="content" style="border: 1px solid gray">
        <h1>회원 가입</h1><br>
        <form method="post" action="/members/join" onsubmit="return joinConfirm()">
            <div>
                <label for="id">아이디</label>
                <input name="id" id="id" type="text" placeholder="아이디 입력"/>
                <input type="button" class="w3-teal" value="중복 체크" onclick="idCheck()"/>
            </div><br>
            <div>
                <label for="name">이름</label>
                <input name="name" id="name" type="text" placeholder="이름을 입력해주세요."/>
            </div><br>

            <div>
                <label for="pwd">비밀번호</label>
                <input name="pwd" id="pwd" type="password" placeholder="비밀번호 입력"/>
            </div><br>
            <div>
                <label for="pwd_re">비밀번호 확인</label>
                <input name="pwd_re" id="pwd_re" type="password" placeholder="비밀번호 한 번 더 입력." onchange="passConfirm()"/><br>
                <span id="message"></span>
            </div><br>
            <div>
                <label for="mail">이메일</label>
                <input name="mail" id="mail" type="text" placeholder="이메일 입력"/>
            </div><br>
            <div>
                <label for="job">직업</label>
                <select name="job" id="job">
                    <option value="학생">학생</option>
                    <option value="직장인">직장인</option>
                    <option value="취업준비생">취업준비생</option>
                    <option value="공시생">공시생</option>
                    <option value="직접 입력">직접입력</option>
                </select>
            </div><br>
            <div>
                <label for="phone">전화번호</label>
                <input name="phone" id="phone" type="tel" placeholder="'-'도 입력"/>
            </div><br>
            <div>
                성별
                <input type="radio" name="gender" value="M"/>남자
                <input type="radio" name="gender" value="W"/>여자
            </div><br><br>
            <div class="w3-center">
                <input type="submit" class="w3-button w3-teal" value="가입하기" />
                <input type="reset" class="w3-button w3-black" value="다시 작성"/>
                <input type="button" class="w3-button w3-gray" value="로그인 화면으로" onclick="location.href='/'"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
