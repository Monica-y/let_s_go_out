var box = [];


// post删除用户
function deleteyh() {

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var context_path = pathName.substr(0, index + 1);

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

    if (window.confirm("Are you sure?")) {
        var flag=true;
        for (var i = 0; i < box.length; i++) {
            if (box[i].checked) {
                let temp = box[i].parentNode.previousSibling.previousSibling.previousSibling.textContent;
                $.ajax({
                    url: context_path+"/admin/deleteUser",
                    type: "post",
                    async: false,
                    data: {
                        admin_id: admin_id,
                        admin_name: admin_name,
                        user_id: temp
                    },
                    dataType: "json",
                    success: function (data, textStatus) {
                        if(data.state != 50000){
                            flag=false;
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        flag=false;
                    },
                });
            }
        }
        if(flag){
            alert("删除成功！");
        }
        else {
            alert("在加载过程中出现了一些问题，请重试！");
        }
        window.location.href = "adminIndex.html";
    }
}

$(document).ready(function(){
    var area = document.getElementById("yonghb");
    var admin_id = "";
    var admin_name = "";

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var context_path = pathName.substr(0, index + 1);
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

    $.ajax({
        url: context_path+"/admin/userInf",
        type: "get",
        async: true,
        data: {
            admin_id: admin_id,
            admin_name: admin_name
        },
        dataType: "json",

        success: function (data, textStatus) {

            if(data.state == 50000){
                var n = data.user_list.length;
                var trh = new Array(n);
                var trd = new Array(n * 4);
                box = new Array(n);
                for (var i = 0; i < n; i++) {
                    trh[i] = document.createElement("tr");
                    area.appendChild(trh[i]);

                    trd[i * 4] = document.createElement("td");
                    //trd[i * 4].innerHTML = i;                   //用户id
                    trh[i].appendChild(trd[i * 4]);

                    trd[i * 4 + 1] = document.createElement("td");
                    //trd[i * 4 + 1].innerHTML = "阿波罗";           //用户名
                    trh[i].appendChild(trd[i * 4 + 1]);

                    trd[i * 4 + 2] = document.createElement("td");
                    //trd[i * 4 + 2].innerHTML = "666";               //用户密码
                    trh[i].appendChild(trd[i * 4 + 2]);

                    trd[i * 4 + 3] = document.createElement("td");
                    trh[i].appendChild(trd[i * 4 + 3]);

                    box[i] = document.createElement("input");
                    box[i].type = "checkbox";
                    trd[i * 4 + 3].appendChild(box[i]);
                }

                for(var i=0;i<n;i++){
                    trd[i * 4].innerHTML = data.user_list[i].userID;
                    trd[i * 4 + 1].innerHTML = data.user_list[i].name;
                    trd[i * 4 + 2].innerHTML = data.user_list[i].password;

                }
            }else{
                alert("在加载过程中出现了一些问题，请重试！");
                window.location.href = "adminIndex.html";
            }

        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("在加载过程中出现了一些问题，请重试！");
            window.location.href = "adminIndex.html";
        },


    });

});