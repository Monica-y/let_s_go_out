function Uprecommend(){
    var type = document.getElementById("selecttype").value;
    var user_id = "";
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
                user_id=data.user_id;
            }
        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("在加载过程中出现了一些问题，请重试！");
            window.location.href = "index.html";
        },
    });
    if(user_id===""){
        alert("需要进行登陆！");
        return;
    }
    var img = document.getElementById("fileField").files[0];
    var name = document.getElementById("recommendName").value;
    var inf = document.getElementById("recommendInf").value;
    var address = document.getElementById("recommendAddress").value;
    var data = new FormData();

    data.append("user_id",user_id);
    data.append("img",img);
    data.append("name",name);
    data.append("inf",inf);
    data.append("address",address);
    if(type == "sights"){
        $.ajax({

            url: context_path+"/sights/recommend",
            type: "post",
            async: true,
            data: data,
            dataType: "json",
            processData:false,
            contentType:false,
            // contentType:"multipart/form-data",
            success: function (data, textStatus) {
                if (data.state  == 50000) {
                    alert("提交成功");
                    window.location.href = "recommend.html";
                    //return false;
                } else {
                    alert("提交失败！");
                    window.location.href = "recommend.html";
                }
            }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("发生错误，请返回");
                window.location.href = "recommend.html";
            },

        });
    }else if(type == "hotel"){
        $.ajax({
            url: context_path+"/hotel/recommend",
            type: "post",
            async: true,
            data: data,
            dataType: "json",
            contentType:false,
            processData: false,
            success: function (data, textStatus) {
                if (data.state  == 50000) {
                    alert("提交成功");
                    window.location.href = "recommend.html";
                    //return false;
                } else {
                    alert("提交失败！");
                    window.location.href = "recommend.html";
                }
            }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("发生错误，请返回");
                window.location.href = "recommend.html";
            },

        });


    }




}