<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 08.09.2016
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericpage>
    <jsp:attribute name="header">
        <h1>Товар</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="row">
            <h2>Велосипед ${param.name}</h2>
                <div class="col-md-6">
            <img src="${pageContext.request.contextPath}/images/${param.imgPath}"
                 width="600px"
                 height="350px">
            </div>
                <h4>Категория товара:</h4>
                <h5>${param.category} велосипеды </h5>
                <h4>Вес:</h4>
                <h5>${param.weight} кг</h5>
                <h4>Количество скоростей:</h4>
                <h5>${param.volume}</h5>
                <h4>Товаров на складе:</h4>
                <h5>${param.amount} шт</h5>
                <h4>Цена:</h4>
                <h5>${param.price} руб</h5>
                <br>
                <form action="${pageContext.request.contextPath}/shopping-cart" method="GET">
                    <input type="hidden" name="action" value="addItem">
                    <input type="hidden" name="name" value="${param.name}">
                    <input type="hidden" name="amount" value="1">
                    <input type="hidden" name="price" value="${param.price}">
                    <input type="hidden" name="id" value="${param.id}">
                    <input type="submit"
                           <c:if test="${param.amount==0}">
                            disabled title="Товар временно отсутствует"
                            </c:if>
                           class="btn btn-success" value="Добавить в корзину">
                </form>
                </div>
        </div>
    </jsp:body>
</t:genericpage>