function otherDay(){

    var id = $("#id").val();
    var begin = $("#begin1").val();

    $.ajax({

        type:"GET",
        url:"/planners/${begin}",
        data: {"id":id, "begin": begin},
        dataType: "text",
        success:function(result){
            $("#frm").css("display","none");
            $("#frm2").css("display","block");
            $("#frm2").html(result);
        },
        error:function(request,status,error){
            alert("code:" +request.status + "\n"+"message:" +request.responseText + "\n" + "error:" + error);
        }
    });
}

function changeURL(){
    $("button").click(function(){
        var value = $(this).attr("id");
        switch(value) {
            case 'obtn':
                window.location = "/members/logout";
                break;
            case 'ibtn':
                window.location = "/members/${id}";
                break;
            case 'mebtn':
                window.location = "/messages/list";
                break;

        }
    });
}
