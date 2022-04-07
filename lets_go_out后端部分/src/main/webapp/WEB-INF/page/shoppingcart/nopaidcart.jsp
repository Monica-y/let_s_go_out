<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2021/2/16
  Time: 23:02
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
    <title>购物车</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-3.3.7/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap-3.3.7/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shoppingcart.css">
    <script src="${pageContext.request.contextPath}/js/shoppingcart.js"></script>
</head>
<body>
<jsp:include page="/head.jsp"></jsp:include>

<div class="container">
    <form action="${pageContext.request.contextPath}/shoppingcart/cartbuy" method="post" onsubmit="return isCartBuy()">
        <div class="car-headers-menu" style="height: 50px">
            <div class="row">
                <div class="col-md-1 good_menu">
                    <label>全选</label><input type="checkbox" name="check-goods-all"/>
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
                    <input type="checkbox" name="id" value="${item.id}"/>
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
                    <a href="${pageContext.request.contextPath}/shoppingcart/delete?id=${item.id}&action=nopaid"
                       class="btn btn-danger">
                        删除该商品
                    </a>
                </div>
            </div>
        </c:forEach>
        <div class="row good_end">
            <div class="col-md-1 good_menu">
                <label>全选</label><input type="checkbox" name="check-goods-all"/>
            </div>
            <div class="col-md-6 good_menu"></div>
            <div class="col-md-2 good_menu">
                已选商品：<span class="show_price" id="selectNumber">0</span>&nbsp;&nbsp;件
            </div>
            <div class="col-md-2 good_menu">合计&nbsp;&nbsp;<span class="show_price" id="price_end">0</span>&nbsp;&nbsp;元
            </div>
            <div class="col-md-1 good_menu">
                <input type="submit" class="btn-danger btn" style="height: 100%;width: 118%" value="购买">
            </div>
        </div>
    </form>
</div>

<jsp:include page="/foot.jsp"></jsp:include>

<script type="text/javascript">
    <%--  给多选框绑定事件  --%>
    $(function () {
        var box = $("input[name='id']");
        var price_end = $("#price_end");
        var number_end = $("#selectNumber");

        //当多选框被选中，背景变色，反之不变
        box.click(function () {
            var aBox = $(this);
            if (aBox.is(":checked")) {
                aBox.parent().parent().css("background", "#f9ff91");
                var goodTotalPrice = parseFloat(aBox.parent().next().next().next().next().next().children(":first").text());
                // alert();
                number_end.text(parseInt(number_end.text()) + 1);
                price_end.text(parseFloat(price_end.text()) + goodTotalPrice);
            } else {
                aBox.parent().parent().css("background", "white");
                var goodTotalPrice = parseFloat(aBox.parent().next().next().next().next().next().children(":first").text());
                // alert(goodTotalPrice);
                number_end.text(parseInt(number_end.text()) - 1);
                price_end.text(parseFloat(price_end.text()) - goodTotalPrice);
            }
        });

        var boxAll = $("input[name='check-goods-all']");
        boxAll.click(function () {
            if ($(this).is(":checked")) {
                $("input[name='id']:not(:checked)").click();
                $("input[name='check-goods-all']:not(:checked)").prop("checked", "checked");
                boxAll.prev().text("全不选");
            } else {
                $("input[name='id']:checked").click();
                $("input[name='check-goods-all']:checked").prop("checked", "");
                boxAll.prev().text("全选");
            }
        });

    })

    function isCartBuy() {
        if($("#selectNumber").text()=='0'){
            alert("未选择商品");
            return false;
        }

        alert("购买成功！");
        return true;
    }
</script>
</body>
</html>
