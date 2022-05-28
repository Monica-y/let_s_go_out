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
            window.location.href = "index.html";
        },
    });
    if(admin_id===""){
        alert("管理员需要登陆！");
        window.location.href = "index.html";
    }


    var daoh = document.getElementById("daohang");
    if (denglu) {
        var hli0 = document.createElement("li");
        daoh.appendChild(hli0);
        var hp0 = document.createElement("a");
        hp0.innerHTML = yonghm + "，你好";
        hli0.classList.add("active");
        hp0.style.color = "white";
        hli0.appendChild(hp0);

        var hli1 = document.createElement("li");
        daoh.appendChild(hli1);
        var ha1 = document.createElement("a");
        ha1.href = "adminIndex.html";
        ha1.innerHTML = "用户管理";
        hli1.appendChild(ha1);
        var hli2 = document.createElement("li");
        daoh.appendChild(hli2);
        var ha2 = document.createElement("a");
        ha2.href = "adminSights.html";
        ha2.innerHTML = "景点管理";
        hli2.appendChild(ha2);
        var hli20 = document.createElement("li");
        daoh.appendChild(hli20);
        var ha20 = document.createElement("a");
        ha20.href = "adminHotel.html";
        ha20.innerHTML = "旅馆管理";
        hli20.appendChild(ha20);

        var hli3 = document.createElement("li");
        daoh.appendChild(hli3);

        var ha3 = document.createElement("a");
        ha3.style.cursor = "pointer";
        hli3.classList.add("booking");
        ha3.innerHTML = "注销";
        ha3.style.color = "white";
        ha3.onclick = zhuxiao;
        hli3.appendChild(ha3);
    } else {
        window.location.href = "login.html";
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
            window.location.href = "adminIndex.html";
        },
    });
    console.log("Hello Runoob!");
//跳转页面
}