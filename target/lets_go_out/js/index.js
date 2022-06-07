var denglu = false;

var yonghm="";


function hideURLbar() {window.scrollTo(0,1);}


$(document).ready(function () {
    setTimeout(hideURLbar,0);
    pageLoad();
});

//这两句应该是让每次加载页面的时候回到最顶端，但是网上说$(document).ready(function(){});和window.onload最好必要一起使用
//查资料https://blog.csdn.net/daponi/article/details/94734683进行了修改
//addEventListener("load",function () {setTimeout(hideURLbar,0);},false);
//function hideURLbar() {window.scrollTo(0,1);}

function deleteChild() {
    //每次要判断Index是否是登陆状态，要把之前的标签节点删除掉
    var e = document.getElementById("daohang");
    var first = e.firstElementChild;
    while (first) {
        first.remove();
        first = e.firstElementChild;
    }
}

function zhuxiao() {
//如果注销的格式
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
            } else if(data.state == 404){
                alert("退出失败");
                window.location.href = "index.html";
            } else {
                alert("退出失败！");
                window.location.href = "index.html";
            }

        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("发生错误，请返回");
            window.location.href = "index.html";
        },
    });

    console.log("a" + denglu);
    deleteChild();
    pageLoad();
    //控制台输出信息
    console.log("b" + denglu);
    console.log("Hello Runoob!");
}


function pageLoad() {
    //导航栏设置
    //获取导航的div
    var daoh = document.getElementById("daohang");
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var context_path = pathName.substr(0, index + 1);
    $.ajax({
        url: context_path+"/usr/getMes",
        type: "get",
        async: false,
        dataType: "json",
        success: function (data, textStatus) {
            if(data.state == 50000){
                yonghm=data.user_name;
                denglu=true;
            }

        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("在加载过程中出现了一些问题，请重试！");
            window.location.href = "index.html";
        },
    });

    if (denglu) {
    //如果是登陆状态，这个要在修改
    //在导航的div下加入用户名的节点
        var hli0 = document.createElement("li");
        daoh.appendChild(hli0);
        hli0.classList.add("active");
        var hp0 = document.createElement("a");
        hp0.innerHTML = yonghm + "，你好";
        hp0.style.color = "white";
        hli0.appendChild(hp0);

        //在导航的div下加入首页的节点
        var hli1 = document.createElement("li");
        daoh.appendChild(hli1);
        //在首页li的节点下加入链接节点
        var ha1 = document.createElement("a");
        ha1.href = "index.html";
        ha1.innerHTML = "首页";
        hli1.appendChild(ha1);

        //在导航的div下加入用户推荐的节点
        var hli2 = document.createElement("li");
        daoh.appendChild(hli2);
        var ha2 = document.createElement("a");
        ha2.href = "recommend.html";
        ha2.innerHTML = "用户推荐";
        hli2.appendChild(ha2);

        //在导航的div下加入注销的节点
        var hli3 = document.createElement("li");
        daoh.appendChild(hli3);
        hli3.classList.add("booking");
        var ha3 = document.createElement("a");
        ha3.style.cursor = "pointer";
        ha3.innerHTML = "注销";
        ha3.style.color = "white";
        ha3.onclick = zhuxiao;
        hli3.appendChild(ha3);
    } else {
        //没有登陆的时候导航栏的状态，使用的方法是DOM树
        var hli1 = document.createElement("li");
        daoh.appendChild(hli1);
        var ha1 = document.createElement("a");
        ha1.href = "index.html";
        ha1.innerHTML = "首页";
        hli1.appendChild(ha1);

        var hli2 = document.createElement("li");
        daoh.appendChild(hli2);
        var ha2 = document.createElement("a");
        ha2.href = "register.html";
        ha2.innerHTML = "注册";
        hli2.appendChild(ha2);

        var hli3 = document.createElement("li");
        hli3.classList.add("booking");
        daoh.appendChild(hli3);
        var ha3 = document.createElement("a");
        ha3.href = "login.html";
        ha3.innerHTML = "登陆";
        hli3.appendChild(ha3);
    }
}

//}




