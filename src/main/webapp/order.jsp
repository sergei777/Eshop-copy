<%--
  Created by IntelliJ IDEA.
  User: Sergei
  Date: 11.09.2016
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:attribute name="header">
        <h1>Товар</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div id="login-overlay" class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title text-center" id="makeOrder">Оформление заказа</h4>
                    </div>

                    <div class="modal-body">

                        <form id="order" action="${pageContext.request.contextPath}/make-order" method="POST">
                            <div class="col-xs-4">
                                <label>Страна</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" name="country" placeholder="Страна"
                                           required >
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-globe"></span></span>
                                </div>

                                <!--------------------------------------separator--------------------------------------------------------------->
                                <br>
                            </div>

                            <div class="col-xs-4">
                                <label>Почтовый индекс</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" name="postcode" placeholder="Индекс"
                                           required pattern="\d{6}">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-globe"></span></span>
                                </div>
                                <br>
                            </div>

                            <div class="col-xs-4">
                                <label>Город</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" name="city" placeholder="Город" required>
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-globe"></span></span>
                                </div>
                                <br>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-4">
                                    <label>Улица</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="street" placeholder="Улица"
                                               required pattern="^[1-9]\d*$">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-4">
                                    <label>Дом</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="house_number" placeholder="Дом"
                                               required pattern="^[1-9]\d*$">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-4">
                                    <label>Квартира</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="float_number"
                                               placeholder="Квартира" required pattern="^[1-9]\d*$">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-globe"></span></span>
                                    </div>
                                    <br>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-4">
                                    <label>Способ оплаты</label>
                                    <div class="input-group">
                                        <select class="form-control" name="payment_type" required id="paymentTypeId">
                                            <option>Картой</option>
                                            <option selected>Наличными</option>
                                        </select>
                                    </div>
                                    <br>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-6">
                                    <label>Способ доставки</label>
                                    <div class="input-group">
                                        <select class="form-control" name="delivery_type" required class="form-control"
                                                id="sel1">
                                            <option>Почтой</option>
                                            <option selected>Курьером</option>
                                            <option>Самовывоз</option>
                                        </select>
                                    </div>
                                </div>
                                <br>
                            </div>
                            <div class="row col-md-12"></div>
                            <div class="form-group">
                                <input type="hidden" name="payment_status" value="Не оплачен">
                                <input type="hidden" name="order_status" value="Не оплачен">

                                <input type="submit" form="order" name="submit" id="submit" value="Оформить заказ!"
                                       class="btn btn-success center-block">
                            </div>

                        </form>
                    </div><!---modal-body--->
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>
