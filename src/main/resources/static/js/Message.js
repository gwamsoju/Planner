function messageForm(){
    $("#MessageForm").css("display","block");
    $("#MessageBox").css("display","none");
}
function changeURL(){
    $("button").click(function(){
        var value = $(this).attr("id");
        switch(value) {
            case 'rbtn':
                $("#MessageForm").css("display","block");
                $("#MessageBox").css("display","none");
                break;
        }
    });
}

function MessageCheck(){
    var recvId = document.getElementById("recvId");
    var mesCon = document.getElementById("mesCon");

    if(recvId.value == ""){
        alert("받는 사람을 입력해주세요.");
        return false;
    }else if(mesCon.value == ""){
        alert("내용을 입력해주세요.");
        return false;
    }
}