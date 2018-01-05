function testChe() {
    // var che = $("input[name='che']").attr("checked");
    $("input[name='che']:checked").each(function () {
        // alert($(this).val());
    });
    var sel=$("[name='opt']:checked").val();
    // alert(sel);

    // alert($("[name='sel']").attr("class","bb").val());
    // alert($("[name='sel']").val());
    // alert($("input[name='che'][value='two']").attr("checked"))

    // if($("input[name='che'][value='two']").attr("checked")=='checked'){
    //     alert(1);
    // }

    if($("input[name='che'][value='two']").attr("checked")){
        alert(1);
    }

}
