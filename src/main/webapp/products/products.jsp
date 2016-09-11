<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 28.08.2016
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:attribute name="header">
        <h1>Список товаров</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <table>
            <tr>
                <td>${clientAddressCountry}<td/>
        </table>
    </jsp:body>
</t:genericpage>
