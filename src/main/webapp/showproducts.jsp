<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 04.09.2016
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/css/product.css" rel="stylesheet">
<t:genericpage>
    <jsp:attribute name="header">
        <h1>Товары</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="row col-md-10">
                <c:forEach items="${products}" var="item">
                    <div class="col-xs-4 col-md-4" style="height:200px;">
                        <div class="div-border">
                            <form action="/item.jsp"  method="POST">
                                <input type="hidden" name="name" value="${item.name}">
                                <input type="hidden" name="amount" value="1">
                                <input type="hidden" name="price" value="${item.price}">
                                <input type="hidden" name="imgPath" value="${item.imagePath}">
                                <input type="image" src="/images/${item.imagePath}"
                                                         alt="picture not found"
                                                         class="img-rounded"
                                                         width="100%"
                                                         height="80%" />
                                <h4 class="text-center">${item.name}</h4>
                            </a>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </jsp:body>
</t:genericpage>
