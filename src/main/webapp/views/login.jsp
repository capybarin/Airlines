<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 17.02.2020
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Вход</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Airlines application</h1>
</div>
<div class="w3-card-4">
    <div class="w3-container w3-center w3-green">
        <h2>Вход</h2>
    </div>
    <form method="post" class="w3-selection w3-light-grey w3-padding">
        <label>Логин:
            <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
        </label>
        <label>Пароль:
            <input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
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
