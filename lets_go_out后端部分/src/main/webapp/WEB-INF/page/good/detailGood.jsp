<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2021/2/16
  Time: 14:34
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
    <title>商品详情</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-3.3.7/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap-3.3.7/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<%--    <script src="${pageContext.request.contextPath}/js/user.js" charset="UTF-8"></script>--%>
    <script src="${pageContext.request.contextPath}/js/good.js" charset="UTF-8"></script>
</head>
<body>
<!--jsp:include 从自身位置出发找-->
<jsp:include page="/head.jsp"></jsp:include>

<div class="container">

    <div class="row" style="padding-top: 40px;padding-bottom: 40px">

        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 " style="height: 405px;">
            <img height="400" data-img="1" data-lazy-img="done" src="${pageContext.request.contextPath}/img/${good.img}">
        </div>
        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 " style="height: 405px;">
            <div style="padding-bottom: 40px">
                <div style="padding-bottom: 20px"><span class="good_title">${good.gname}</span></div>
                <div style="padding-bottom: 40px"><span style="color: #9e9e9e">${good.detail}</span></div>
                <div style="background:#e3e3e3;border-radius: 15px">
                    <span style="color: red;font-size: 20pt">&nbsp;售价：￥${good.price}</span>
                </div>
                <div style="padding-top: 20px">
                    <span style="font-size: 15pt">商品数量：${good.total}件</span>
                </div>
                <div style="padding-top: 20px">
                    <span style="font-size: 15pt">销售额：${sell_cnt}</span>
                </div>
            </div>
            <form action="${pageContext.request.contextPath}/shoppingcart/buy" method="post" onsubmit="return isBuyVaild()">
                <input type="text" style="display: none" id="status" name="status">
                <input type="text" style="display: none" name="gid" value="${good.gid}">
                <input type="text" style="display: none" name="uid" value="${user.uid}">
                数量：
                <%--                <span  style="border: 2px solid #9e9e9e;height:40px;text-align: center;font-size: 20pt" >+</span>--%>
                <span style="width: 25px;height: 25px;padding: 1px 10px" class="btn btn-default"
                      onclick="subtract()">
                    -
                </span>
                <%--                <span " border: 1px solid blackid="number">1</span>--%>
                <input type="text" style="width: 50px;text-align: center;" name="number" id="number" readonly value="1" >
                <%--                <button style="width: 25px;" onclick="add(${good.total})">+</button>--%>
                <span style="width: 25px;height: 25px;padding:2px 8px" class="btn btn-default"
                      onclick="add(${good.total})">
                    +
                </span>
                <br>
                <div style="padding-top: 20px;text-align: center">
                        <input type="submit" class="btn btn-danger" value="加入购物车"
                               onclick="addShoppingCart()">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input  type="submit" class="btn btn-danger"  style="width: 100px" value="立即购买"
                                onclick="buyGood()">
                </div>


            </form>
        </div>
    </div>

</div>

<jsp:include page="/foot.jsp"></jsp:include>
<script type="text/javascript">

    function isBuyVaild() {
        if ($("#status").val() == 'true'){
            alert("购买成功！");
            return true;
        }
        if($("#status").val() == 'false'){
            alert("添加购物车成功！");
            return true;
        }

        return false;
    }

</script>
</body>
</html>
