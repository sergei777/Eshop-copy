<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 12.09.2016
  Time: 7:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/order-list"/>
<t:genericadminpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th>id заказа</th>
                    <th>Пользователь</th>
                    <th>Статус оплаты</th>
                    <th>Способ оплаты</th>
                    <th>Статус заказа</th>
                    <th>Товары</th>
                        <%--<th>Адрес</th>--%>
                </tr>
                </thead>
                <c:forEach items="${requestScope.orderList}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.user.username}</td>
                        <td>${item.paymentType}</td>
                        <td>${item.paymentType}</td>
                        <form action="/order-list" method="get">
                            <td>

                                <select name="orderStatusUpdate" class="form-control">
                                    <option
                                            <c:if test="${item.orderStatus == 'Не оплачен'}"> selected </c:if>
                                            value="Не оплачен">Не оплачен
                                    </option>
                                    <option
                                            <c:if test="${item.orderStatus == 'Ожидает отгрузки'}"> selected </c:if>
                                            value="Ожидает отгрузки">Ожидает отгрузки
                                    </option>
                                    <option
                                            <c:if test="${item.orderStatus == 'Отгружен'}"> selected </c:if>
                                            value="Отгружен">Отгружен
                                    </option>
                                    <option
                                            <c:if test="${item.orderStatus == 'Доставлен'}"> selected </c:if>
                                            value="Доставлен">Доставлен
                                    </option>
                                </select>
                            </td>
                                <%--<c:forEach items="${item.products}" var="tmp">--%>
                            <td>
                                <ul class="list-group">
                                    <c:forEach items="${item.products}" var="tmp">

                                    <li class="list-group-item">${tmp.name}</li>
                                </ul>

                                </c:forEach>
                            </td>
                            <td>
                                <input type="hidden" name="id" value="${item.id}" >
                                <input type="submit" class="btn btn-default" value="Сохранить изменения">
                            </td>

                            </form>


                    </tr>
                </c:forEach>
                </tbody>


            </table>

        </div>
    </jsp:body>
</t:genericadminpage>
