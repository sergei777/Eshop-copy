<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 28.08.2016
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<link href="/css/product.css" rel="stylesheet">
<link href="/css/index.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<t:genericpage>
    <jsp:attribute name="header">
        <h1>Основная страница</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <%--<div class="row text-center">--%>
                <%--<div class="col-md-3" style="height:200px; text-align: center">--%>
        <div class="col-md-10 col-md-offset-1">
        <div class="bs-example">
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- Carousel indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <!-- Wrapper for carousel items -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="/images/main/4.jpg" alt="First Slide">
                        <div class="carousel-caption">
                            <h2>
                                <span><strong>Добро пожаловать!</strong></span>
                            </h2>
                            </div>
                    </div>
                    <div class="item">
                        <img src="/images/main/2.jpg" alt="Second Slide">
                        <div class="carousel-caption">
                            <h2>
                                <span><strong>Большой выбор товаров</strong></span>
                            </h2>
                        </div>
                    </div>
                    <div class="item">
                        <img src="/images/main/3.jpg" alt="Third Slide">
                        <div class="carousel-caption">
                            <h2>
                                <span><strong>Низкие цены</strong></span>
                            </h2>
                        </div>
                    </div>
                </div>
                <!-- Carousel controls -->
                <a class="carousel-control left" href="#myCarousel" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                <a class="carousel-control right" href="#myCarousel" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
            </div>
        </div>
        </div>
    </jsp:body>
</t:genericpage>
