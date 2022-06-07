addEventListener("load", function () {
    setTimeout(hideURLbar, 0);
}, false);

function hideURLbar() {
    window.scrollTo(0, 1);
}

window.onload = pageLoad;
var denglu = true;

var yonghm = "管理员";

function pageLoad() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var context_path = pathName.substr(0, index + 1);
    //验证是否登陆
    var admin_id = "";
    var admin_name = "";
    $.ajax({
        url: context_path+"/admin/getMes",
        type: "get",
        async: false,
        dataType: "json",
        success: function (data, textStatus) {
            if(data.state == 50000){
                admin_id=data.admin_id;
                admin_name=data.admin_name;
            }

        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("在加载过程中出现了一些问题，请重试！");
            //window.location.href = "index.html";
        },
    });
    if(admin_id===""){
        alert("管理员需要登陆！");
        // window.location.href = "index.html";
    }


    var yh = document.getElementById("yonghu");
    var zx = document.getElementById("zhux");
    if (denglu) {
        yh.innerHTML = yonghm + "，你好";
        zx.onclick = zhuxiao;
    } else {
        // window.location.href = "login.html";
    }

}

function zhuxiao() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var context_path = pathName.substr(0, index + 1);
    $.ajax({
        url: context_path+"/logout",
        type: "post",
        async: true,
        data: {

        },
        dataType: "json",

        success: function (data, textStatus) {

            if (data.state == 50000) {
                alert("您已经退出登录");
                denglu = false;
                window.location.href = "index.html";
                //return false;
            } else if(data.state == 404){
                alert("退出失败");
                window.location.href = "adminIndex.html";
            } else {
                alert("退出失败！");
                window.location.href = "adminIndex.html";
                //return false;
            }

        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("发生错误，请返回");
            // window.location.href = "adminIndex.html";
        },
    });
    console.log("Hello Runoob!");
//跳转页面
}