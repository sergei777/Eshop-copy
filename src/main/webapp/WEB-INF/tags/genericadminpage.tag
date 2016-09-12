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
<link href="/css/style.css" rel="stylesheet">
<link href="/css/generictag.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>

<div class="container">
    <div id="pageheader">
        <jsp:invoke fragment="header"/>
        <nav class="navbar navbar-default">
            <div class="headerclass">
                <ul class="nav navbar-nav center-block">
                    <li><a href="/admin.jsp">На главную</a></li>
                    <li><a href="/admin/userlist.jsp">Пользователи</a></li>
                    <li><a href="/admin/orderlist.jsp">Заказы</a></li>
                    <li><a href="/admin/productlist.jsp">Управление товарами</a></li>
                    <li><a href="/admin/statistics.jsp">Статистика продаж</a></li>
                </ul>
            </div>
        </nav>
    </div>
</div>
<jsp:doBody/>
<jsp:invoke fragment="footer"/>

</body>
</html>