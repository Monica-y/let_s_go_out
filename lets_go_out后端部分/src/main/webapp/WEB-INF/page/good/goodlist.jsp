<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2021/2/16
  Time: 12:25
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
    <title>商品列表</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-3.3.7/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap-3.3.7/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <style>

    </style>
</head>
<body>
<!--jsp:include 从自身位置出发找-->
<jsp:include page="/head.jsp"></jsp:include>

<jsp:include page="showGood.jsp"></jsp:include>

<jsp:include page="/foot.jsp"></jsp:include>
</body>
</html>
