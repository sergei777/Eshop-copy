<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 13.09.2016
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericpage>
    <jsp:attribute name="header">
        <h1>Мои заказы</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th>Id заказа</th>
                    <th>Способ оплаты</th>
                    <th>Адрес</th>
                    <th>Статус заказа</th>
                    <th>Товары</th>
                        <%--<th>Адрес</th>--%>
                </tr>
                </thead>
                <c:forEach items="${sessionScope.user.orders}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.paymentType}</td>
                        <td>${item.addressEntity.streetName} ${item.addressEntity.houseNumber}, ${item.addressEntity.door}</td>
                        <td>${item.orderStatus}</td>
                            <td>
                                <ul class="list-group">
                                    <c:forEach items="${item.products}" var="tmp">

                                    <li class="list-group-item">${tmp.name}</li>
                                </ul>

                                </c:forEach>
                            </td>
                    </tr>
                </c:forEach>
                </tbody>


            </table>

        </div>




    </jsp:body>
</t:genericpage>
