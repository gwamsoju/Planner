function messageForm(){
    $("#messageForm").css("display","block");
}
function changeURL(){
    $("button").click(function(){
        var value = $(this).attr("id");
        switch(value) {
            //TODO: 메시지 페이지에서 메인화면으로 이동 기능 구현 예정
            case 'mbtn':
                window.location = "" ;
                break;
            //TODO: 메시지 페이지에서 메시지 삭제 기능 구현 예정
            case 'mdbtn':
                window.location = "" ;
                break;
        }
    });
}