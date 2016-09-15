<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 12.09.2016
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericadminpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title text-center">Изменение информации</h4>
        </div>

        <div class="modal-body">


            <form id="update" action="/user-list" method="POST">
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
                    <input type="hidden" name="operation" value="updateUserMainInformation">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="hidden" name="userType" value="admin">
                    <input type="submit" form="update" name="submit" id="submit"
                           value="Сохранить изменения" class="btn btn-success center-block">
                </div>
            </form>
        </div><!---modal-body--->
    </div>
</div>


    </jsp:body>
</t:genericadminpage>
