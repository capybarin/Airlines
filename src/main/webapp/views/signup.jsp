<%@ page import="com.airlines.app.helpers.EmailValidator" %><%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 17.02.2020
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Airlines application</h1>
</div>

<div class="w3-container w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Регистрация</h2>
        </div>
        <%
            if(request.getAttribute("error") == null){
                if (request.getAttribute("userName") != null) {
                    if (request.getAttribute("userSurname") != null) {
                        out.println("<p>Пользоватль '" + request.getAttribute("userName") + " "
                                + request.getAttribute("userSurname") + "' зарегистрирован!</p>");
                        out.println("<button class=\"btn_st w3-btn w3-hover-green w3-round-large\" onclick=\"location.href='/login'\">Перейти на страницу входа</button>");
                    }
                }
            } else { out.println(request.getAttribute("error")); }
        %>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Логин:
                <input type="text" name="login" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Пароль:
                <input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Почта:
                <input type="text" name="mail" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Имя:
                <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Фамилия:
                <input type="text" name="surname" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Подтвердить</button>
        </form>
    </div>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Назад</button>
</div>
</body>
</html>
