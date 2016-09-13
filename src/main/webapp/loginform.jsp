<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 02.09.2016
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:attribute name="header">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function(){
                $(document).on('click', '#loginbutton', function (evt) {
                    evt.preventDefault();
            //$("#sign-in-form").onclick(function() {
                var url = "/checkuser"; // the script where you handle the form input.
                var smt = $("#sign-in-form");
                $.ajax({
                    type: "POST",
                    url: url,
                    data: smt.serialize(), // serializes the form's elements.
                    success: function(text)
                    {
                        //alert("hi! " + text); // show response from the script.
                        window.location.href = text;
                        //alert('form was submitted');
                    },
                    error : function() {
                        alert ('Неверный имя пользователя или пароль');
                    }
                });

                //e.preventDefault(); // avoid to execute the actual submit of the form.
            })});
        </script>
        <h1>Вход</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <link href="css/loginform.css" rel="stylesheet">
        <body>
        <div class="container" style="margin-top:40px">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <strong> Вход в аккаунт</strong>
                        </div>
                        <div class="panel-body">
                            <form id = "sign-in-form" method="POST">
                                <fieldset>
                                    <div class="row">
                                        <div class="center-block">
                                            <img class="profile-img"
                                                 src="http://vonknsb-unwe.org/Content/images/unknown.png" alt="">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <form class="col-sm-12 col-md-10  col-md-offset-1">
                                            <div class="form-group">
                                                <div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-user"></i>
												</span>
                                                    <input class="form-control" placeholder="Имя пользователя" name="login" type="text" autofocus>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-lock"></i>
												</span>
                                                    <input class="form-control" placeholder="Пароль" name="password" type="password">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <input type="submit" id="loginbutton" class="btn btn-lg btn-primary btn-block" value="Войти">
                                            </div>
                                            </form>
                                        </div>
                                </fieldset>
                            </form>
                        </div>
                        <div class="panel-footer ">
                            Нет аккаунта? <a href="/registrationform.jsp" onClick=""> Зарегистрироваться здесь </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </body>
    </jsp:body>
</t:genericpage>