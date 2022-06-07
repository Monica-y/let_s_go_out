function loginbt() {
    var temp;
    if (window.confirm("Are you sure?")) {
        // console.log("Hello Runoob1!");
        var shenfen = document.getElementById("shenf");
        // console.log(shenfen.value);
        var uname = document.getElementById("uname").value;
        // console.log(unm.value);
        var password = document.getElementById("pssw").value;
        // console.log(psw.value);

        var pathName = document.location.pathname;
        var index = pathName.substr(1).indexOf("/");
        var context_path = pathName.substr(0, index + 1);

        if (uname === '' || password === '') {
            // $("#status").text("用户名或密码不能为空");
            alert('用户名或密码不能为空！');
            return false;
        }

        if (shenfen.value === "管理员") {
            $.ajax({
                url: context_path + "/admin/login",
                data: {
                    admin_name: uname,
                    password: password,
                },
                async: true,
                type: "post",
                dataType: "json",
                success: function (data, textStatus) {
                    if (data.state == 60002) {
                        alert("登录时用户名与密码不匹配");
                        window.location.href = "index.html";
                        //return false;
                    } else if (data.state == 50000) {
                        alert("登录成功");
                        window.location.href = "adminIndex.html";
                    } else if (data.state == 404) {

                        alert("出现错误");
                        window.location.href = "index.html";

                    } else {
                        alert("出现错误");
                        window.location.href = "index.html";
                        //return false;
                    }

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("发生错误，请返回");
                    window.location.href = "index.html";
                },
            });

        }
        if (shenfen.value === "用户") {
            $.ajax({
                url: context_path + "/user/login",
                data: {
                    user_name: uname,
                    password: password,
                },
                async: true,
                type: "post",
                dataType: "json",
                success: function (data, textStatus) {
                    if (data.state == 60002) {
                        alert("登录时用户名与密码不匹配");
                    } else if (data.state == 50000) {
                        alert("登录成功");
                        window.location.href = "index.html";
                    } else if (data.state == 404) {

                        alert("出现错误");
                        //window.location.href = "index.html";

                    } else {
                        alert("出现错误");
                        //window.location.href = "index.html";
                        //return false;
                    }

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("发生错误，请返回");
                    //window.location.href = "index.html";
                },
            });


        }
    }
}



