<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 08.09.2016
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:attribute name="header">
        <h1>Товар</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <h1>${param.name}</h1>
            <p>${param.price}</p>
            <img src="${pageContext.request.contextPath}/images/${param.imgPath}"
                 width="60%"
                 height="60%">
            <form action="${pageContext.request.contextPath}/shopping-cart" method="GET">
                <input type="hidden" name="name" value="${param.name}">
                <input type="hidden" name="amount" value="1">
                <input type="hidden" name="price" value="${param.price}">
                <input type="hidden" name="id" value="${param.id}">
                <input type="submit" class="btn btn-default" value="Добавить в корзину">
            </form>
        </div>
    </jsp:body>
</t:genericpage>