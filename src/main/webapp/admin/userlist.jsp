<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 11.09.2016
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/user-list">
    <jsp:param name="operation" value="getUserList"/>
</jsp:include>

<t:genericadminpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div>
            <div class="container">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Имя пользователя</th>
                        <th>Логин пользователя</th>
                        <th>Дата рождения</th>
                        <th>E-mail</th>
                        <th>Тип пользователя</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.userList}" var="item">
                        <tr>

                            <td>${item.firstName} ${item.secondName}</td>
                            <td>${item.username}</td>
                            <td>${item.birthDate}</td>
                            <td>${item.email}</td>
                            <td>${item.userType}</td>
                            <td>
                                <form action="/user-list" method="get">
                                    <input type="hidden" name="operation" value="change">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <input type="submit" class="btn" value="Редактировать">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </jsp:body>
</t:genericadminpage>
