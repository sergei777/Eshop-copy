<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 11.09.2016
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="statistics"></jsp:include>
<t:genericadminpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <table class="table">
        <h3>Самые покупаемые товары:</h3>
        <tr>
            <th>Наименование</th>
            <th>Количество</th>
        </tr>
            <c:forEach items="${map}" var="entry">
                <tr>
                    <td>${entry.key}</td>
                    <td>${entry.value}</td>
                </tr>
            </c:forEach>
                </table>
        </div>
    </jsp:body>
</t:genericadminpage>
