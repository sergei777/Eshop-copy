<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 07.09.2016
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:attribute name="header">
        <h1>Настройки пользователя</h1>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">

        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#main-information">Основная информация</a></li>
            <li><a data-toggle="tab" href="#additional-information">Дополнительная информация</a></li>
        </ul>

        <div class="tab-content">
            <div id="main-information" class="tab-pane fade in active">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title text-center">Изменение информации</h4>
                        </div>

                        <div class="modal-body">


                            <form id="registerForm" action="${pageContext.request.contextPath}/sign-up" method="POST">
                                <!---form--->
                                <div class="form-group">
                                    <!---input width--->
                                    <div class="col-xs-6">
                                        <label>Имя</label>
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="first_name"
                                                   value="${user.firstName}" placeholder="Введите имя пользователья"
                                                   required>
                                            <span class="input-group-addon"><span
                                                    class="glyphicon glyphicon-asterisk"></span></span>
                                        </div>
                                        <br>
                                        <label>Логин</label>
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="username"
                                                   value="${user.username}" placeholder="Введите логин" required>
                                            <span class="input-group-addon"><span
                                                    class="glyphicon glyphicon-asterisk"></span></span>
                                        </div>
                                        <!--------------------------------------separator--------------------------------------------------------------->
                                        <hr>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-6">
                                        <label>Фамилия</label>
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="last_name"
                                                   value="${user.secondName}" placeholder="Введите фамилию" required>
                                            <span class="input-group-addon"><span
                                                    class="glyphicon glyphicon-asterisk"></span></span>
                                        </div>

                                        <br>
                                        <label>Пароль</label>
                                        <div class="input-group">
                                            <input type="password" class="form-control" name="password"
                                                   placeholder="Введите пароль" required>
                                            <span class="input-group-addon"><span
                                                    class="glyphicon glyphicon-asterisk"></span></span>
                                        </div>
                                        <!--------------------------------------separator--------------------------------------------------------------->
                                        <hr>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <label>Дата рождения</label>
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="birth_date"
                                                   value="${user.birthDate}" placeholder="Введите дату рождения"
                                                   required>
                                            <span class="input-group-addon"><span
                                                    class="glyphicon glyphicon-asterisk"></span></span>
                                        </div>
                                        <!----------------------------break------------------------------------------------------------->
                                        <br>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <label>E-mail</label>
                                        <div class="input-group">
                                            <input type="email" class="form-control" name="email" value="${user.email}"
                                                   placeholder="Введите e-mail" required>
                                            <span class="input-group-addon"><span
                                                    class="glyphicon glyphicon-asterisk"></span></span>
                                        </div>
                                        <!----------------------------break------------------------------------------------------------->
                                        <br>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <input type="submit" form="registerForm" name="submit" id="submit"
                                           value="Сохранить изменения" class="btn btn-success center-block">
                                </div>
                            </form>
                        </div><!---modal-body--->
                    </div>
                </div>
            </div>
            <div id="additional-information" class="tab-pane fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title text-center">Изменение информации</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>