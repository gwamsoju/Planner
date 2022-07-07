function loginCheck() {
    var id = document.getElementById("username");
    var pwd = document.getElementById("password");

    if (id.value == "") {
        alert("아이디를 입력해주세요.");
        return false;
    }
    if(pwd.value == ""){
        alert("비밀번호를 입력해주세요.");
        return false;
    }
    return true;
}

function passConfirm(){
    const pwd = document.getElementById("password");
    const pwd_re = document.getElementById("pwd_re");
    const message = document.getElementById("message");

    if(pwd.value == pwd_re.value){
        message.innerHTML = "비밀번호 일치";
        message.style.color = 'green';
    }else{
        message.innerHTML = "비밀번호 불일치";
        message.style.color = 'red';
    }
}

function joinConfirm(){
    var id = document.getElementById('username');
    var name = document.getElementById('name');
    var mail = document.getElementById('mail');
    var job = document.getElementById('job');
    var phone = document.getElementById('phone');
    var pwd = document.getElementById('password');
    var pwd_re = document.getElementById('pwd_re');
    var gender = $('input:radio[name=gender]').is(':checked');

    if(id.value == ""){
        alert('아이디를 입력해주세요.');
        id.focus();
        return false;
    }
    if(name.value == ""){
        alert('이름을 입력해주세요.');
        name.focus();
        return false;
    }
    if(mail.value ==""){
        alert('이메일을 입력해주세요.');
        return false;
    }
    if(job.value == ""){
        alert('직업을 선택해주세요.');
        return false;
    }
    if(phone.value == ""){
        alert('전화번호를 입력해주세요.');
        return false;
    }
    if(!gender){
        alert('성별 체크를 해주세요.');
        return false;
    }
    if($("#Confirm3").val() == ""){
        alert("이메일 인증을 해주세요.");
        return false;
    }
    if($("#idConfirm").val() == ""){
        alert("아이디 중복 체크를 해주세요.");
        return false;
    }
    if(pwd.value != pwd_re.value){
        alert("비밀번호가 다릅니다.");
        return false;
    }
    return true;
}

function idCheck(){


    if($("#username").val() == "" ){
        alert("아이디를 입력해주세요.");
    }else {
        $.ajax({
            url: "/id/check",
            type: "POST",
            dataType: "JSON",
            data: {"username": $("#username").val()},
            success: function (data) {
                if (data == 0) {
                    alert("사용가능한 아이디입니다.");
                    $("#idConfirm").attr("value","T");
                } else {
                    alert("이미 해당 ID가 존재합니다.");
                }
            }
        })
    }
}

function sendNumber(){

    if($("#mail").val() == ""){
        alert("이메일을 입력해주세요.");
        $("#mail").focus();
        return false;
    }else {
        $("#mailConfirm").css("display", "block");
        $.ajax({
            url: "/mailConfirm",
            type: "POST",
            dataType: "JSON",
            data: {"mail": $("#mail").val()},
            success: function (data) {
                alert("인증 번호를 발송했습니다.");
                $("#Confirm2").attr("value", data);
            }
        });
    }
}
function mailConfirm(){
    var mailConfirm = $("#Confirm").val();
    var mailConfirm2 = $("#Confirm2").val();

    if(mailConfirm == mailConfirm2){
        alert("인증되었습니다.");
        document.getElementById("mail").readOnly = true;
        document.getElementById("sendButton").hidden = true;
        $("#Confirm3").attr("value","T");
        $("#mailConfirm").css("display", "none");
    }else{
        alert("인증 번호가 다릅니다.");
    }
}

function passConfirm(){
    const pwd = document.getElementById('password');
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
function joinForm(){
    window.location="/join";
}
function deleteForm(){
    window.location="/members/delete";
}

function googleLogin(){
    window.location="/oauth2/authorization/google";
}

function changeURL(){
    $("input").click(function(){
        var value = $(this).attr("id");
        switch(value) {
            case 'lbtn':
                window.location="/";
                break;
        }
    });
}

