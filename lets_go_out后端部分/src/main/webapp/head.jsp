<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2021/2/15
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="linl" uri="/copyright-tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--页头-->
<nav class="navbar navbar-default">
    <ul class="nav navbar-nav">
        <li ><a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">
            <img  src="${pageContext.request.contextPath}/img/image/logo1.jpg"  style="position:relative; top:-10px" width="210">
        </a></li>
        <li name="tabbar"><a href="${pageContext.request.contextPath}/index.jsp">首页 <img src="${pageContext.request.contextPath}/img/image/homelogo.jpg"></a></li>
        <li name="tabbar"><a href="${pageContext.request.contextPath}/goodlist">我要买</a></li>
        <li name="tabbar"><a href="${pageContext.request.contextPath}/shoppingcart?action=nopaid">购物车<img src="${pageContext.request.contextPath}/img/image/buslogo.jpg"></a></li>
        <li name="tabbar"><a href="${pageContext.request.contextPath}/shoppingcart?action=paid">已购买</a></li>
    </ul>
    <form id="keyWordForm" class="navbar-form navbar-left" method="post" action="" onsubmit="return hasKeyWord()">
        <p class="form-group">
            <input type="text" class="form-control" name="keyWord" id="keyWord" placeholder="关键字">
        </p>
        <button type="submit" class="btn btn-default">搜索</button>
    </form>
    <ul class="nav navbar-nav navbar-right">
        <c:choose>
            <c:when test="${user==null}">
                <li><a href="${pageContext.request.contextPath}/user/login">登录</a></li>
                <li><a href="${pageContext.request.contextPath}/user/register">注册</a></li>
            </c:when>
            <c:otherwise>
                <li>
                    <a href="${pageContext.request.contextPath}/user/myinf">欢迎您，${user.uname}</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/user/logout">注销</a>
                </li>
            </c:otherwise>
        </c:choose>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
               aria-haspopup="true" aria-expanded="false">
                友情链接<span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li><a href="mailto:liutao25@baidu.com">联系我</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="https://www.taobao.com/" target="_blank">淘宝</a></li>
                <li><a href="https://www.pinduoduo.com/">拼多多</a></li>
                <li><a href="https://www.vip.com/?wxsdk=1" target="_blank">唯品会</a></li>
                <li role="separator" class="pider"></li>
                <li><a href="http://nn.ganji.com/" target="_blank">赶集网</a></li>
            </ul>
        </li>
    </ul>
</nav>

<script type="text/javascript">
    function hasKeyWord() {
        if($("#keyWord").val()==''){
            alert("您需要输入关键字");
            return false;
        }

        $("#keyWordForm").prop("action","${pageContext.request.contextPath}/goodlist?keyWor="+$("#keyWord").val());
        return true;
    }
    // $(document).ready(function(){
    //     $("li[name='tabbar']").click(function(){
    //         var rm=$(".active");
    //         var add=$(this);
    //         rm.removeClass('active');
    //         add.addClass('active');
    //         alert(rm==add);
    //     });
    // });
</script>