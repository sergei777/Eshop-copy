<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 02.09.2016
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:attribute name="header">
        <h1>Регистрация</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div id="login-overlay" class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title text-center" id="myModalLabel">Регистрация нового пользователя</h4>
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
                                               placeholder="Введите имя пользователя" required>
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-asterisk"></span></span>
                                    </div>
                                    <br>
                                    <label>Логин</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="username"
                                               placeholder="Введите логин" required>
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
                                               placeholder="Введите фамилию" required>
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
                                               placeholder="Введите дату рождения" required>
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
                                        <input type="email" class="form-control" name="email"
                                               placeholder="Введите e-mail" required>
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-asterisk"></span></span>
                                    </div>
                                    <!----------------------------break------------------------------------------------------------->
                                    <br>
                                </div>
                            </div>
                            <div class="modal-header">
                                <h4 class="modal-title text-center" id="myAdditionalInformationModalLabel">Контактная
                                    информация</h4>
                            </div>
                            <!----------------------------break------------------------------------------------------------->
                            <br>
                            <div class="col-xs-6">
                                <label>Страна</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" name="country" placeholder="Страна">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-globe"></span></span>
                                </div>
                                <br>
                                <label>Почтовый код</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" name="postcode"
                                           placeholder="Введите почтовый код">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-globe"></span></span>
                                </div>
                                <!--------------------------------------separator--------------------------------------------------------------->
                                <br>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label>Город</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="city" placeholder="Город">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                    </div>
                                    <br>
                                    <label>Улица</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="street"
                                               placeholder="Введите название улицы">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                    </div>
                                    <!--------------------------------------separator--------------------------------------------------------------->
                                    <br>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label>Дом</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="house_number"
                                               placeholder="Введите номер дома">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                    </div>
                                    <hr>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label>Квартира</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="float_number"
                                               placeholder="Введите номер квартиры">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                    </div>
                                    <hr>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="submit" form="registerForm" name="submit" id="submit"
                                       value="Зарегистироваться!" class="btn btn-success center-block">
                            </div>
                        </form>
                    </div><!---modal-body--->
                </div>
            </div>
            <script type="text/javascript">
            </script>
        </div>
    </jsp:body>
</t:genericpage>
