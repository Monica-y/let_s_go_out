
function isVaildLogin() {
    var uname=$("#uanme").val();
    var password=$("#password").val();

    if(uname==''||password==''){
       // $("#status").text("用户名或密码不能为空");
        alert('用户名或密码不能为空！');
        return false;
    }
    return true;
}

function isRegisterVaild() {
    var uname=$("#uname").val();
    var password=$("#password").val();
    var confirmPassword=$("#confirmPassword").val();
    var address=$("#address").val();
    var sex=$("input[name='sex']:checked").val();
    var birthday=$("#birthday").val();
    var email=$("#email").val();
    var status=$("#status");

    // alert(uname+password+address+sex+birthday+email);
    if(uname==''){
        alert("用户名不能为空！");
        return false;
    }
    if(password==''){
        alert("密码不能为空！");
        return false;
    }
    if(confirmPassword==''){
        alert("确认密码不能为空！");
        return false;
    }
    if(address==''){
        alert("地址不能为空！");
        return false;
    }
    if(password!=confirmPassword){
        alert("密码与确认密码不一致！");
        return false;
    }


    $.ajax({
        url: "../user/registering",
        data:{
            uname:uname,
            password:password,
            sex:sex,
            birthday:birthday,
            address:address,
            email:email
        },
        async:false,
        type: "post",
        success: function (data){
            // alert("o");
            switch (data+"") {
                case "0":{
                    alert("已有用户使用该用户名");
                    return false;
                }
                case "-1":{
                    alert("已有用户使用该密码");
                    return false;
                }
                case "1":{
                    alert("注册成功！");
                    $("#uname1").val(uname);
                    $("#password1").val(password);
                    $("#goLogin").click();
                    return true;
                }
                default:{
                    alert("注册失败！");
                    return false;
                }
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert("发生错误，请返回");
        },
    });

}

function isupdateIdVaild() {
    var uid=$("#new_uid").val();
    if(uid==""){
        alert("更改id不能为空！");
        return false;
    }
    if(uid<=0){
        alert("更改id需要大于0！");
        return false;
    }
    return true;
}
// function hasKeyWord() {
//     if($("#keyWord").val()==''){
//         alert("您需要输入关键字");
//         return false;
//     }
//
//     $("#keyWordForm").prop("action","goodlist?keyWor="+$("#keyWord").val());
//     return true;
// }
