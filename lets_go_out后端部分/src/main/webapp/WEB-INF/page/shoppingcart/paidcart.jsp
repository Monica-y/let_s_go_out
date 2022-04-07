<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2021/2/16
  Time: 23:01
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
    <title>已购商品</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-3.3.7/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap-3.3.7/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shoppingcart.css">
</head>
<body>
<jsp:include page="/head.jsp"></jsp:include>

<div class="container">
    <div class="car-headers-menu" style="height: 50px">
        <div class="row">
            <div class="col-md-1 good_menu">
                商品id
            </div>
            <div class="col-md-3 good_menu">图片</div>
            <div class="col-md-3 good_menu">商品信息</div>
            <div class="col-md-1 good_menu">单价</div>
            <div class="col-md-1 good_menu">数量</div>
            <div class="col-md-1 good_menu">金额</div>
            <div class="col-md-2 good_menu">操作</div>
        </div>
    </div>
    <c:forEach items="${shoppingcart}" var="item">
        <div class="row good_div">
            <div class="col-md-1 good_menu ">
                    ${item.id}
            </div>
            <div class="col-md-3 good_menu">
                <a href="${pageContext.request.contextPath}/good?gid=${item.gid}" target="_blank">
                    <img src="${pageContext.request.contextPath}/img/${item.imgPath}" style="height:90%">
                </a>
            </div>
            <div class="col-md-3 good_menu">
                <a class="a_hover" target="_blank" href="${pageContext.request.contextPath}/good?gid=${item.gid}">
                        ${item.goodName}
                </a>
            </div>
            <div class="col-md-1 good_menu show_price">
                ￥${item.goodPrice}
            </div>
            <div class="col-md-1 good_menu">${item.total}</div>
            <div class="col-md-1 good_menu show_price">￥<span>${item.total*item.goodPrice}</span></div>
            <div class="col-md-2 good_menu">
                <a href="${pageContext.request.contextPath}/shoppingcart/delete?id=${item.id}&action=paid"
                   class="btn btn-danger">
                    从列表中删除
                </a>
            </div>
        </div>
    </c:forEach>

</div>

<jsp:include page="/foot.jsp"></jsp:include>


</body>
</html>