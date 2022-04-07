<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2021/2/17
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="linl" uri="/copyright-tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--展示商品的那一部分公共页面，可用于搜索后的商品页面和未搜索的商品页面-->

<div class="container">  <!-- 开加一个container的目的是为了让整体布局居中 -->
    <!-- 开始 -->
    <div class="row"><!-- 将要加入的略缩图放入row中 -->
        <c:forEach items="${goodList}" var="good">

            <div class="col-lg-3 col-md-4 col-sm-6 col-xs-6 div_hover"
                 style="height: 405px;"><!-- 大屏幕放3张略缩图，pc端放4张，平板和手机放6张-->
                <div style="height: 30px;visibility: hidden ">
                        <%--                    <input type="text" value="${good.gid}">--%>
                </div>
                <div >
                    <a target="_blank" title="" href="${pageContext.request.contextPath}/good?gid=${good.gid}">
                        <img width="220" height="220" data-img="1" data-lazy-img="done" src="${pageContext.request.contextPath}/img/${good.img}">
                    </a>
                </div>

                <div class="caption" style="height: 20px">
                    <strong class="" data-done="1" >
                        <em style="color: red;font-size: 15pt">售价：￥${good.price}</em><i></i>
                    </strong>
                </div>
                <div class="caption" style="height: 60px">
                    <a href="${pageContext.request.contextPath}/good?gid=${good.gid}" target="_blank" class="a_hover">
                        <h4>${good.gname}</h4>
                    </a>
                </div>
                <div >
                    <span>商品数量：${good.total}件</span>
                </div>

            </div>

        </c:forEach>

    </div>
    <!-- 结束 -->

</div>
