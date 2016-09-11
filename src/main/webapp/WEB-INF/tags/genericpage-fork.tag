<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
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
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<style>
    .headerclass {
        height: 200px;
        position: relative;
    }

    .div-bucket {
        float: right;
        padding-right: 15px;
        width: 200px;
    }

    .div2 {
        position: absolute;
        bottom: 0;
    }

    .div-bucket-buttons {
        position: absolute;
        bottom: 0;
    }

    a.button {
        -webkit-appearance: button;
        -moz-appearance: button;
        appearance: button;

        text-decoration: none;
        color: initial;
    }

    .div-bucket-element {
        position: relative;
        top: 25px;
        height: 160px;
    }

    .div-paragraph {
        position: absolute;
        padding-top: 10px;
    }
    h4 {
        margin-top: 0px;
        margin-bottom: 5px;
    }

    .navbar-default{
        background-color: #fbfbff;W
    }
</style>
<body>
<div id="pageheader">
    <jsp:invoke fragment="header"/>
    <nav class="navbar navbar-default">
        <div class="headerclass">
            <div class="div2">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/index.jsp">На главную</a></li>
                    <li><a href="/about/">О компании</a></li>
                    <li><a href="/products">Каталог товаров</a></li>
                    <li><a href="/contact/">Контакты</a></li>
                </ul>
            </div>
            <div class="div-bucket">
                <div class="div-paragraph">
                    <div style="position: relative; left: 30%">Привет, ${!empty sessionScope.username ? sessionScope.username : "гость"}!</div>
                </div>
                <a href="http://example.com">
                    <div class="div-bucket-element">
                        <img src="http://iconspot.ru/files/287498.png"
                             width="70%"
                             height="70%">
                        <h4 class="text-center">Корзина пуста</h4>
                    </div>
                </a>
                <div class="div-bucket-buttons">
                    <a href="/loginform.jsp" class="btn btn-default">Вход</a>
                    <a href="/registrationform.jsp" class="btn btn-default">Регистрация</a>
                </div>
            </div>
        </div>
    </nav>
</div>
<div id="body">
    <jsp:doBody/>
</div>
<div id="pagefooter">
    <jsp:invoke fragment="footer"/>
</div>

</body>
</html>