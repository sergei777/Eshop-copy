<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 07.09.2016
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericpage>
    <jsp:attribute name="header">
        <h1>Корзина</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
        <table class="table">
            <thead>
            <tr>
            <th>Название товара</th>
            <th>Цена</th>
            <th>Количество</th>
                </tr>
            </thead>
            <tbody>
        <c:forEach items="${sessionScope.shoppingCart.shoppingList}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.amount}</td>
                </tr>
        </c:forEach>
        <tr>
            <th>Итого: ${sessionScope.shoppingCart.totalPrice} рублей</th>
            <th></th>
            <th></th>
        </tr>
            </tbody>


        </table>
        <input type="button" value="Оформить заказ">
        </div>
    </jsp:body>
</t:genericpage>