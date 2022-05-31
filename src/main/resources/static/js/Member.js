function loginCheck() {
    var id = document.getElementById("id");
    var pwd = document.getElementById("pwd");

    if (id.value == "") {
        alert("아이디를 입력해주세요.");
        return false;
    }else if(pwd.value == ""){
        alert("비밀번호를 입력해주세요.");
        return false;
    }
    return true;
}

function passConfirm(){
    const pwd = document.getElementById("pwd");
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
function joinForm(){
    window.location="/members/join";
}

function changeURL(){
    $("input").click(function(){
        var value = $(this).attr("id");
        switch(value) {
            case 'dbtn':
                window.location = "/members/delete" ;
                break;
            case 'lbtn':
                window.location = "/" ;
                break;
        }
    });
}