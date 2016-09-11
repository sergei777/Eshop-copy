<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>velosipedov.net</title>

    <!-- Bootstrap -->
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
                    <li class="active"><a href="/index.jsp">На главную</a></li>
                    <li><a href="/about/">О компании</a></li>
                    <li><a href="/products">Каталог товаров</a></li>
                    <li><a href="/AddressServlet">Адрес</a></li>
                    <li><a href="/contact/">Контакты</a></li>
                </ul>

                <div class="div-bucket-buttons div-button">
                    <div>
                        <c:if test="${empty sessionScope.first_name}">
                        <a href="/loginform.jsp" class="btn btn-default">Вход</a>
                        <a href="/registrationform.jsp" class="btn btn-default">Регистрация</a>
                        </c:if>
                        <c:if test="${!empty sessionScope.first_name}">
                            <div class="btn">
                                <a href="/settings">
                                    <div class="div-settings">
                                        <img src="http://s1.iconbird.com/ico/2014/1/567/w512h5121389807746applicationdefaulticon.png">
                                    </div>
                                </a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="div-bucket-element">
    <h5 class="text-center">Привет,${!empty sessionScope.first_name ? sessionScope.first_name : "гость"}!</h5>
    <a href="/bucket.jsp">
        <img src="http://iconspot.ru/files/287498.png"
             width="70%"
             height="70%"
        class="center-block">
    </a>
    <h5 class="text-center">Корзина : ${!empty sessionScope.shoppingCart ? sessionScope.shoppingCart.totalAmount : "0"} товаров</h5>
</div>
<jsp:doBody/>
<jsp:invoke fragment="footer"/>

</body>
</html>