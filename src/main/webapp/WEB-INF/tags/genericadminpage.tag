<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
      crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/generictag.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div id="pageheader">
        <jsp:invoke fragment="header"/>
        <nav class="navbar navbar-default">
            <div class="headerclass">
                <ul class="nav navbar-nav center-block">
                    <li><a href="${pageContext.request.contextPath}/admin.jsp">На главную</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/userlist.jsp">Пользователи</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/orderlist.jsp">Заказы</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/productlist.jsp">Управление товарами</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/statistics.jsp">Статистика продаж</a></li>
                </ul>
            </div>
        </nav>
    </div>
</div>
<jsp:doBody/>
<jsp:invoke fragment="footer"/>

</body>
</html>