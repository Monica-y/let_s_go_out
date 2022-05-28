//未审核旅馆的数量
var len = 5;
//n是每页个数
var n = 3;


// 显示每页的景点全部信息
function jdtp() {
    var jdxx = document.getElementById("jdxx");
    var yemao = parseInt(document.getElementById("yemao").innerHTML);
    var type = document.getElementById("type").innerHTML;

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var context_path = pathName.substr(0, index + 1);

    var admin_id = "";
    var admin_name = "";
    $.ajax({
        url: context_path + "/admin/getMes",
        type: "get",
        async: false,
        dataType: "json",
        success: function (data, textStatus) {
            if (data.state == 50000) {
                admin_id = data.admin_id;
                admin_name = data.admin_name;
            }

        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("在加载过程中出现了一些问题，请重试！");
            window.location.href = "index.html";
        },
    });


    $.ajax({
        url: context_path + "/admin/inf",
        type: "get",
        async: true,
        data: {
            admin_id: admin_id,
            admin_name: admin_name,
            type: type

        },
        dataType: "json",

        success: function (data, textStatus) {

            if (data.state == 50000) {
                var data_list=null;
                if(type=="hotel"){
                     data_list=data.hotel_list;
                }
                else if("sights"==type){
                     data_list=data.sights_list
                }
                len = data_list.length;
                var div1 = new Array(len);
                var div2 = new Array(len);
                var div3 = new Array(len);
                var div4 = new Array(len);
                var div5 = new Array(len);
                var div6 = new Array(len);
                var div7 = new Array(len);
                var div8 = new Array(len);
                var img1 = new Array(len);
                var hh3 = new Array(len);
                var pp1 = new Array(len);
                var pp2 = new Array(len);
                var pp3 = new Array(len);
                var butt1 = new Array(len);
                var butt2 = new Array(len);
                for (var i = yemao * n; i < len && i < yemao * n + n; i++) {
                    div1[i] = document.createElement("div");
                    div1[i].classList.add("tour-two__single");
                    div1[i].classList.add("tour-one__single");
                    jdxx.appendChild(div1[i]);

                    div2[i] = document.createElement("div");
                    div2[i].classList.add("tour-two__image-wrap");
                    div1[i].appendChild(div2[i]);

                    div3[i] = document.createElement("div");
                    div3[i].classList.add("tour-one__image");
                    div2[i].appendChild(div3[i]);
                    //加图片
                    img1[i] = document.createElement("img");
                    <!--                img1[i].src="assets/images/tour/tour-2-"+j+".jpg";-->
                    img1[i].alt = "";
                    div3[i].appendChild(img1[i]);

                    div4[i] = document.createElement("div");
                    div4[i].classList.add("tour-one__content");
                    div1[i].appendChild(div4[i]);

                    div5[i] = document.createElement("div");
                    div5[i].classList.add("tour-two__top");
                    div4[i].appendChild(div5[i]);

                    div6[i] = document.createElement("div");
                    div6[i].classList.add("tour-two__top-left");
                    div5[i].appendChild(div6[i]);
                    //加名称
                    hh3[i] = document.createElement("h3");
                    <!--                hh3[i].appendChild(document.createTextNode("旅馆名称"));-->
                    div6[i].appendChild(hh3[i]);

                    pp3[i] = document.createElement("p");
                    <!--                pp3[i].appendChild(document.createTextNode("旅馆id"));-->
                    div6[i].appendChild(pp3[i]);

                    div7[i] = document.createElement("div");
                    div7[i].classList.add("tour-two__text");
                    div4[i].appendChild(div7[i]);
                    // 加叙述
                    pp1[i] = document.createElement("p");
                    <!--                pp1[i].appendChild(document.createTextNode("Lorem"));-->
                    div7[i].appendChild(pp1[i]);
                    // 加地址
                    pp2[i] = document.createElement("p");
                    <!--                pp2[i].appendChild(document.createTextNode("某个地方"));-->
                    div7[i].appendChild(pp2[i]);

                    div8[i] = document.createElement("div");
                    div8[i].classList.add("tour-two__right");
                    div5[i].appendChild(div8[i]);
                    // 两个按钮删除推荐
                    butt1[i] = document.createElement("button");
                    butt1[i].classList.add("secondTableVRow");
                    butt1[i].innerHTML = "通过";
                    butt1[i].onclick = yes;
                    div8[i].appendChild(butt1[i]);

                    butt2[i] = document.createElement("button");
                    butt2[i].classList.add("secondTableVRow");
                    butt2[i].innerHTML = "删除";
                    butt2[i].onclick=no;
                    div8[i].appendChild(butt2[i]);
                }

                if("hotel"==type){
                    for (var k = yemao * n; k < i; k++) {
                        img1[k].src = data_list[k].housePho;
                        hh3[k].innerHTML = data_list[k].houseName;
                        pp3[k].innerHTML = data_list[k].houseID;
                        pp1[k].innerHTML = data_list[k].houseInfo;
                        pp2[k].innerHTML = data_list[k].houseAddress;
                    }
                }
                else if("sights"==type){
                    for(var k = yemao * n; k < i; k++){
                        img1[k].src=data_list[k].sightPho;
                        hh3[k].innerHTML = data_list[k].sightName;
                        pp3[k].innerHTML = data_list[k].sightID;
                        pp1[k].innerHTML = data_list[k].sightInfo;
                        pp2[k].innerHTML = data_list[k].sightAddress;
                    }
                }

                let show_num=document.getElementById("num");
                if(yemao * n+1<=i){
                    show_num.innerHTML=(yemao * n+1)+" to "+i+" "+type;
                }
                else {
                    show_num.innerHTML="no "+type;
                }
            } else {
                alert("在加载过程中出现了一些问题，请重试！");
                type = type[0].toUpperCase() + type.substr(1)
                window.location.href = "admin"+type+".html";
            }

        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("在加载过程中出现了一些问题，请重试！");
            type = type[0].toUpperCase() + type.substr(1)
            window.location.href = "admin"+type+".html";
        },

    });
}

function yes() {
    var id = this.parentNode.previousSibling.lastChild.innerHTML;
    var type = document.getElementById("type").innerHTML;

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var context_path = pathName.substr(0, index + 1);

    //验证是否登陆
    var admin_id = "";
    var admin_name = "";
    $.ajax({
        url: context_path + "/admin/getMes",
        type: "get",
        async: false,
        dataType: "json",
        success: function (data, textStatus) {
            if (data.state == 50000) {
                admin_id = data.admin_id;
                admin_name = data.admin_name;
            }

        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("在加载过程中出现了一些问题，请重试！");
            window.location.href = "index.html";
        },
    });

    $.ajax({
        url: context_path + "/admin/accept",
        type: "post",
        async: true,
        data: {
            admin_id: admin_id,
            admin_name: admin_name,
            id: id,
            type: type

        },
        dataType: "json",

        success: function (data, textStatus) {

            if (data.state == 50000) {
                alert("已通过");
                type = type[0].toUpperCase() + type.substr(1)
                window.location.href = "admin"+type+".html";

            } else {
                alert("在加载过程中出现了一些问题，请重试！");
                type = type[0].toUpperCase() + type.substr(1)
                window.location.href = "admin"+type+".html";
            }

        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("在加载过程中出现了一些问题，请重试！");
            type = type[0].toUpperCase() + type.substr(1)
            window.location.href = "admin"+type+".html";
        },

    });
}

function no() {
    var id = this.parentNode.previousSibling.lastChild.innerHTML;
    var type = document.getElementById("type").innerHTML;

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var context_path = pathName.substr(0, index + 1);

    //验证是否登陆
    var admin_id = "";
    var admin_name = "";
    $.ajax({
        url: context_path + "/admin/getMes",
        type: "get",
        async: false,
        dataType: "json",
        success: function (data, textStatus) {
            if (data.state == 50000) {
                admin_id = data.admin_id;
                admin_name = data.admin_name;
            }

        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("在加载过程中出现了一些问题，请重试！");
            window.location.href = "index.html";
        },
    });

    $.ajax({
        url: context_path + "/admin/delete",
        type: "post",
        async: true,
        data: {
            admin_id: admin_id,
            admin_name: admin_name,
            id: id,
            type: type

        },
        dataType: "json",
        success: function (data, textStatus) {
            if (data.state == 50000) {
                alert("已删除");
                type = type[0].toUpperCase() + type.substr(1)
                window.location.href = "admin"+type+".html";
            } else {
                alert("在加载过程中出现了一些问题，请重试！");
                type = type[0].toUpperCase() + type.substr(1)
                window.location.href = "admin"+type+".html";
            }

        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("在加载过程中出现了一些问题，请重试！");
            type = type[0].toUpperCase() + type.substr(1)
            window.location.href = "admin"+type+".html";
        },

    });
}

// 给页码编号，加左箭头右箭头
function inityemao() {
    var ymjd = document.getElementById("ymjd");
    var yemao = document.getElementById("yemao");
    //中间页码显示个数
    var zong = 1;
    console.log(yemao.innerHTML);
    console.log(zong);
    var aaa = new Array(zong + 2);
    var iii = new Array(2);
    //加左箭头
    aaa[zong] = document.createElement("a");
    aaa[zong].onclick = zuo;
    ymjd.appendChild(aaa[zong]);
    iii[0] = document.createElement("i");
    iii[0].classList.add("fa");
    iii[0].classList.add("fa-angle-left");
    aaa[zong].appendChild(iii[0]);
    //加数字

    var page_num=parseInt(yemao.innerHTML)+1;
    for (var i = 1; i <= zong; i++) {
        aaa[i] = document.createElement("a");
        aaa[i].classList.add("active");
        aaa[i].innerHTML = page_num;
        ymjd.appendChild(aaa[i]);
    }

    //加右箭头
    aaa[zong + 1] = document.createElement("a");
    aaa[zong + 1].onclick = you;
    ymjd.appendChild(aaa[zong + 1]);
    iii[1] = document.createElement("i");
    iii[1].classList.add("fa");
    iii[1].classList.add("fa-angle-right");
    aaa[zong + 1].appendChild(iii[1]);
}

// 点击左箭头，页面-1
function zuo() {
    var yemao = document.getElementById("yemao");
    if (parseInt(yemao.innerHTML) >= 1){
        yemao.innerHTML = parseInt(yemao.innerHTML) - 1;
        deleteChild();
        inityemao();
        jdtp();
    }
}

// 点击右箭头
function you() {
    var yemao = document.getElementById("yemao");
    if (parseInt(yemao.innerHTML) < parseInt((len-1)/3)){
        yemao.innerHTML = parseInt(yemao.innerHTML) + 1;
        deleteChild();
        inityemao();
        jdtp();
    }
}

// 删除节点，刷新用
function deleteChild() {
    var e = document.getElementById("ymjd");
    var first = e.firstElementChild;
    while (first) {
        first.remove();
        first = e.firstElementChild;
    }
    var e = document.getElementById("jdxx");
    var first = e.firstElementChild;
    while (first) {
        first.remove();
        first = e.firstElementChild;
    }
}