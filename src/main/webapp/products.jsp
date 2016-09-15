<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 04.09.2016
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE><html><head>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet">
<style>
    .post-content {
        bottom: 40px;
        left: 100px;
        position: absolute;
    }
</style>
<t:genericpage>
    <jsp:attribute name="header">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <h1>Товары</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="row ">
                <div class="col-md-10">
                    <c:forEach items="${productList}" var="item">
                        <div class="col-xs-4 col-md-4" style="height:200px;">
                            <div class="div-border">
                                <form action="${pageContext.request.contextPath}/item.jsp" method="get">
                                    <input type="hidden" name="name" value="${item.name}">
                                    <input type="hidden" name="weight" value="${item.weight}">
                                    <input type="hidden" name="volume" value="${item.volume}">
                                    <input type="hidden" name="amount" value="${item.amount}">
                                    <input type="hidden" name="category" value="${item.category}">
                                    <input type="hidden" name="price" value="${item.price}">
                                    <input type="hidden" name="imgPath" value="${item.imagePath}">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <input type="image" src="/images/${item.imagePath}"
                                           alt="picture not found"
                                           class="img-rounded"
                                           width="100%"
                                           height="80%">
                                    <h4 class="text-center">${item.name}</h4>
                                    <h5 class="text-center post-content">Цена: ${item.price}</h5>
                                </form>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="col-md-2">
                    <div class="form-group">
                        <label for="sel1">Выбрать категорию:</label>
                        <select class="form-control" id="sel1">
                            <option selected></option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                    </div>
                    <label for="sel1">Цена:</label>
                    <div class="brd">
                        <form id="updateProductByPriceRange" action="${pageContext.request.contextPath}/product-list"
                              method="get">
                            <div class="form-group">
                                <div class="input-group">
                                    <label for="minPriceId">От:</label>
                                    <input type="text" class="form-control" name="minPrice" id="minPriceId" required
                                           pattern="^[1-9]\d*$">
                                </div>
                                <div class="input-group">
                                    <label for="maxPriceId">До:</label>
                                    <input type="text" class="form-control" name="maxPrice" id="maxPriceId" required
                                           pattern="^[1-9]\d*$">
                                </div>
                            </div>
                            <div class="input-group center-block">
                                <input type="hidden" name="operation" value="updateProductsByPriceRange">
                                <input type="submit" id="updateProductButton" class="btn btn-default center-block"
                                       value="Показать">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</html>
