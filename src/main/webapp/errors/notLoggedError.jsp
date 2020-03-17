<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 17.02.2020
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="Plane, Ticket">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Ошибка</title>

    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&display=swap&subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
    <link rel="stylesheet" href="style/style.css">

</head>
<body>

<header>
    <h1>Airlines Application</h1>
</header>

<div class="home_img_big">
    <div class="home_text">
        <div class="">
            <p class="text_shadow">Упс! Вы не вошли в систему, заказ билета невозможен!</p>
        </div>

        <div>
            <img class="img_error" src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Crystal_Clear_app_error.svg/1024px-Crystal_Clear_app_error.svg.png" alt="ERROR">
        </div>

        <button class="button_log" onclick="location.href='/'" >На главную</button>

    </div>
</div>

</body>
</html>
