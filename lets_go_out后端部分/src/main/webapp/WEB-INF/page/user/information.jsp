<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2021/2/18
  Time: 13:47
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
    <title>个人信息</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-3.3.7/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap-3.3.7/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <script src="${pageContext.request.contextPath}/js/user.js"></script>
</head>
<body >
<jsp:include page="/head.jsp"></jsp:include>

<div class="container" style="background-color: #e3e3e3;width: 100%;border-radius: 10px">
<div style="margin: 10px 10px;background-color: white;">
    <div class="row" style="padding-top: 20px">
        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
            用户ID：
        </div>
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 " style="border: 2px solid #6d6767">
            <span >
                <c:if test="${user.uid==''}">
                    无信息
                </c:if>
                ${user.uid}
            </span>
        </div>
    </div>
    <div class="row" style="padding-top: 20px">
        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
            用户名：
        </div>
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 " style="border: 2px solid #6d6767">
             <span >
                <c:if test="${user.uname==''}">
                    无信息
                </c:if>
                ${user.uname}
            </span>
        </div>
    </div>
    <div class="row" style="padding-top: 20px">
        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
            电子邮箱：
        </div>
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 " style="border: 2px solid #6d6767">
             <span >
                <c:if test="${user.email==''}">
                    无信息
                </c:if>
                ${user.email}
            </span>
        </div>
    </div>
    <div class="row" style="padding-top: 20px">
        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
            生日：
        </div>
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 " style="border: 2px solid #6d6767">
            <span id="birthday">
                <c:if test="${user.birthday==''}">
                    无信息
                </c:if>
                <fmt:formatDate value='${user.birthday}' pattern='yyyy-MM-dd'/>
            </span>
        </div>
    </div>
    <div class="row" style="padding-top: 20px">
        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
            性别：
        </div>
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 " style="border: 2px solid #6d6767">
             <span >
                <c:if test="${user.sex==''}">
                    无信息
                </c:if>
                ${user.sex}
            </span>
        </div>
    </div>
    <div class="row" style="padding-top: 20px">
        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
            地址：
        </div>
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 " style="border: 2px solid #6d6767">
            <span >
                <c:if test="${user.address==''}">
                    无信息
                </c:if>
                ${user.address}
            </span>
        </div>
    </div>
    <div class="row" style="padding-top: 20px">
        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 ">
            更改id：
        </div>
        <form action="${pageContext.request.contextPath}/user/updateName"
              onsubmit="return isupdateIdVaild()"
              method="post">
            <input style="display: none;" name="old_uid" id="old_uid" value="${user.uid}">
            <input type="text" name="new_uid" id="new_uid">
            <button type="submit">更改</button>
        </form>
    </div>
</div>
</div>

<jsp:include page="/foot.jsp"></jsp:include>

<script type="text/javascript">
</script>
</body>
</html>
