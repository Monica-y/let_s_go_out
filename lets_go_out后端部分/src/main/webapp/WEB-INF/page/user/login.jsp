<%--
    用户登录
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2021/2/15
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="linl" uri="/copyright-tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>用户登录</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-3.3.7/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap-3.3.7/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/user.js"></script>
</head>
<body>
<!--jsp:include 从自身位置出发找-->
<jsp:include page="/head.jsp"></jsp:include>

<div style="position: center">
    <form style="margin-left:39%;margin-top:100px;margin-bottom: 100px"
          action="${pageContext.request.contextPath}/user/logining" onsubmit="return isVaildLogin()" method="post">
        <!--用来记录登录状态，比如密码为空，密码错误之类的-->
        <span style="color: red;text-align: center;display:block;width: 340px" id="status">${status}</span>
        <div style="display: inline;" id="message"></div>
        <div class="form-group">
            <label for="uanme" stype="display:inline;">用户名：</label>
            <input type="text" class="form-control" id="uanme" name="uname" style="display:inline;width:200px;" autocomplete="off"
            value="${uname}"/>
        </div>
        <div class="form-group">
            <label for="password"  style="display:inline;">密码：</label>
            &nbsp;&nbsp;&nbsp;
            <input type="password" class="form-control" id="password" name="password" style="display:inline;width:200px;"
                   autocomplete="off" value="${password}" />
        </div>
        <button type="submit" class="btn btn-primary"  style="margin-left: 16%;width: 70px">登&nbsp;&nbsp;录</button>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <a href="${pageContext.request.contextPath}/user/register">免费注册</a>
    </form>
</div>

<jsp:include page="/foot.jsp"></jsp:include>

<script type="text/javascript">
    // 页面加载完后,从session中把status,uname,password移除
   $(function () {
        // alert('ok');
        <%
        session.removeAttribute("status");
        session.removeAttribute("password");
        session.removeAttribute("uname");
        %>
    })

</script>
</body>
</html>
