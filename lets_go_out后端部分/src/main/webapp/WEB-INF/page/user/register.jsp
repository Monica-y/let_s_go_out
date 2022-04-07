<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2021/2/15
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-3.3.7/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap-3.3.7/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <script src="../js/user.js" charset="UTF-8"></script>
</head>
<body>
<jsp:include page="/head.jsp"></jsp:include>

<div class="container1">

    <form class="form-horizontal" method="post" onsubmit="return isRegisterVaild()">

        <div class="form-group">
            <label for="uname" class="col-sm-2 control-label  inline-style font-position-right">用户名*</label>
            <div class="col-sm-9  inline-style">
                <input type="text" class="form-control" id="uname" name="uname"
<%--                       required oninvalid="setCustomValidity('用户名不能为空！');" oninput="setCustomValidity('');"--%>
                       placeholder="用户名">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label  inline-style font-position-right">密码*</label>
            <div class="col-sm-9  inline-style">
                <input type="password" class="form-control" id="password" name="password"
<%--                       required--%>
<%--                       oninvalid="setCustomValidity('密码不能为空！')"oninput="setCustomValidity('');"--%>
                       placeholder="密码">
            </div>
        </div>
        <div class="form-group">
            <label for="confirmPassword" class="col-sm-2 control-label  inline-style font-position-right">确认密码*</label>
            <div class="col-sm-9  inline-style">
                <input type="password" class="form-control" id="confirmPassword"
<%--                       required--%>
<%--                       oninvalid="setCustomValidity('确认密码不能为空！')"oninput="setCustomValidity('');"--%>
                       placeholder="确认密码">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label  inline-style font-position-right">邮箱</label>
            <div class="col-sm-9  inline-style">
                <input type="email" class="form-control" id="email" name="email" placeholder="邮箱">
            </div>
        </div>
        <div class="form-group">
            <label for="sex" class="col-sm-2 control-label  inline-style font-position-right">性别</label>
            <%--            <div class="col-sm-9  inline-style">--%>
            <%--                <input type="text" class="form-control" id="sex" placeholder="性别（只能为“男”或“女”）">--%>
            <%--            </div>--%>
            <div class="col-sm-9  inline-style">
                <label class="radio-inline" id="sex">
                    <input type="radio" name="sex"   value="男" checked>男
                </label>
                <label class="radio-inline">
                    <input type="radio" name="sex"  value="女"> 女
                </label>
            </div>

        </div>
        <div class="form-group">
            <label for="birthday" class="col-sm-2 control-label  inline-style font-position-right">生日</label>
            <div class="col-sm-9  inline-style">
                <input type="date" class="form-control" id="birthday" name="birthday" placeholder="生日">
            </div>
        </div>
        <div class="form-group">
            <label for="address" class="col-sm-2 control-label  inline-style font-position-right">地址*</label>
            <div class="col-sm-9  inline-style">
                <input type="text" class="form-control" id="address" name="address"
<%--                       required--%>
<%--                       oninvalid="setCustomValidity('地址不能为空！');" oninput="setCustomValidity('');"--%>
                       placeholder="地址">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-9">
<%--                <button class="btn btn-lg btn-primary btn-block register-btn" type="button"--%>
<%--                onclick="isRegisterVaild()">注册</button>--%>
                <input type="submit" class="btn btn-lg btn-primary btn-block register-btn" value="注册">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-12">
                <span style="color: red;text-align: center" class="col-sm-9" id="status">${status}</span>
            </div>
        </div>

    </form>

</div>
<form action="${pageContext.request.contextPath}/user/logining" method="post" style="display: none">
    <input type="text"  id="uname1" name="uname" />
    <input type="password" id="password1" name="password"/>
    <input type="submit" id="goLogin">
</form>
<jsp:include page="/foot.jsp"></jsp:include>
<script type="text/javascript">
    <%--function isRegisterVaild() {--%>
    <%--    var uname=$("#uname").val();--%>
    <%--    var password=$("#password").val();--%>
    <%--    var confirmPassword=$("#confirmPassword").val();--%>
    <%--    var address=$("#address").val();--%>
    <%--    var sex=$("input[name='sex']:checked").val();--%>
    <%--    var birthday=$("#birthday").val();--%>
    <%--    var email=$("#email").val();--%>
    <%--    var status=$("#status");--%>

    <%--    // alert(uname+password+address+sex+birthday+email);--%>
    <%--    if(uname==''){--%>
    <%--        alert("用户名不能为空！");--%>
    <%--        return false;--%>
    <%--    }--%>
    <%--    if(password==''){--%>
    <%--        alert("密码不能为空！");--%>
    <%--        return false;--%>
    <%--    }--%>
    <%--    if(confirmPassword==''){--%>
    <%--        alert("确认密码不能为空！");--%>
    <%--        return false;--%>
    <%--    }--%>
    <%--    if(address==''){--%>
    <%--        alert("地址不能为空！");--%>
    <%--        return false;--%>
    <%--    }--%>
    <%--    if(password!=confirmPassword){--%>
    <%--        alert("密码与确认密码不一致！");--%>
    <%--        return false;--%>
    <%--    }--%>


    <%--    $.ajax({--%>
    <%--        url: "${pageContext.request.contextPath }/user/registering",--%>
    <%--        data:{--%>
    <%--            uname:uname,--%>
    <%--            password:password,--%>
    <%--            sex:sex,--%>
    <%--            birthday:birthday,--%>
    <%--            address:address,--%>
    <%--            email:email--%>
    <%--        },--%>
    <%--        async:false,--%>
    <%--        type: "post",--%>
    <%--        success: function (data){--%>
    <%--            // alert("o");--%>
    <%--            switch (data+"") {--%>
    <%--                case "0":{--%>
    <%--                    alert("已有用户使用该用户名");--%>
    <%--                    return false;--%>
    <%--                }--%>
    <%--                case "-1":{--%>
    <%--                    alert("已有用户使用该密码");--%>
    <%--                    return false;--%>
    <%--                }--%>
    <%--                case "1":{--%>
    <%--                    alert("注册成功！");--%>
    <%--                    $("#uname1").val(uname);--%>
    <%--                    $("#password1").val(password);--%>
    <%--                    $("#goLogin").click();--%>
    <%--                    return true;--%>
    <%--                }--%>
    <%--                default:{--%>
    <%--                    alert("注册失败！");--%>
    <%--                    return false;--%>
    <%--                }--%>
    <%--            }--%>
    <%--        },--%>
    <%--        error: function(XMLHttpRequest, textStatus, errorThrown) {--%>
    <%--            alert("发生错误，请返回");--%>
    <%--        },--%>
    <%--    });--%>

    <%--}--%>

</script>
</body>
</html>
