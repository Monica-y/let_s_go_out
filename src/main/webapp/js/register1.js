//$(document).ready(function () {
    function regbt() {
        var temp;
        if (window.confirm("Are you sure?")) {
            console.log("Hello Runoob1!");
            var cpsw = document.getElementById("cpssw");
            var uname = document.getElementById("uname");
            var password = document.getElementById("pssw");
            if (cpsw.value !== password.value) {
                alert("两次密码不一致，请重新输入");
                return false;
            }
            if (uname.value === '' || password.value === '') {
                // $("#status").text("用户名或密码不能为空");
                alert('用户名或密码不能为空！');
                return false;
            }
            var pathName = document.location.pathname;
            var index = pathName.substr(1).indexOf("/");
            var context_path = pathName.substr(0, index + 1);
            $.ajax({
                url: context_path+"/user/register",
                type: "post",
                async: true,
                data: {
                    user_name: uname.value,
                    password: password.value
                },
                dataType: "json",
                success: function (data, textStatus) {
                    if (data.state  == 60001) {
                        alert("用户名已经被人注册过");
                        window.location.href = "register.html";
                        //return false;
                    } else if(data.state == 50000){
                        alert("注册成功！");
                        window.location.href = "login.html";
                    } else if(data.state==404) {
                        alert("出现错误");
                        window.location.href = "index.html";
                    } else {
                        alert("注册失败！");
                        window.location.href = "index.html";
                    }
                }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("发生错误，请返回");
                    window.location.href = "index.html";
                },
            });
        }
    }


//});