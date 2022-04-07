<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="linl" uri="/copyright-tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>淘淘网—开心淘！</title>
<%--    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>--%>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-3.3.7/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/css/bootstrap-3.3.7/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
<!--页头-->
<jsp:include page="/head.jsp"></jsp:include>

<!--轮播图-->
<div id="carousel-example-generic" class="carousel slide " data-ride="carousel" data-interval="3000"
     style="bottom: 10px;height: 300px" >
    <!-- Indicators轮播指标 -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides 轮播项目-->
    <div class="carousel-inner" role="listbox" >
        <div class="item active" style="height: 100%">
            <a href="${pageContext.request.contextPath}/good?gid=1" target="_blank">
                <img src="${pageContext.request.contextPath}/img/image\elec\huaweip20.png" class="img-responsive center-block" style="height: 300px">
            </a>
            <div class="carousel-caption">
                华为P20是华为公司旗下一款智能手机，搭载麒麟970处理器+6GB内存，采用5.8英寸显示屏，分辨率2240x1080，后置徕卡双摄镜头，通过AI技术实现场景识别模式适配。
            </div>
        </div>
        <div class="item">
            <a href="${pageContext.request.contextPath}/good?gid=2" target="_blank">
                <img src="${pageContext.request.contextPath}/img/image\elec\huipu-jingling.png" class="img-responsive center-block" style="height: 300px">
            </a>
            <div class="carousel-caption">
                相比上一代，惠普OMEN暗影精灵6肉眼可见的变化，在于更换了全新的模具。
            </div>
        </div>
        <div class="item">
            <a href="${pageContext.request.contextPath}/good?gid=3" target="_blank">
                <img src="${pageContext.request.contextPath}/img/image\elec\sony-ilce.png" class="img-responsive center-block" style="height: 300px">
            </a>
            <div class="carousel-caption">
                Alpha 6000L APS-C体积小，外观设计独特，看上去很精致的一款，价格偏低，运动型的数码相机，光学防抖的设计很实用，长焦效果优良。
            </div>
        </div>
        <div class="item">
            <a href="${pageContext.request.contextPath}/good?gid=4" target="_blank">
                <img src="${pageContext.request.contextPath}/img/image\elec\dell-7000.png" class="img-responsive center-block" style="height: 300px">
            </a>
            <div class="carousel-caption">
                戴尔DELL灵越7000 15.6英寸轻薄本设计师高性能商务笔记本电脑(i7 16G 512G GTX1650Ti高色域全面屏办公)
            </div>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<!--页尾-->
<jsp:include page="/foot.jsp"></jsp:include>

<script type="text/javascript">
</script>
</body>
</html>