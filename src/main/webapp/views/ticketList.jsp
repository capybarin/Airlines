<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 22.02.2020
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="Plane, Ticket">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Билеты</title>

    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&display=swap&subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
    <link rel="stylesheet" href="style/style.css">
</head>
<body>

<header>

    <div class="nav_b1"></div>
    <div class="nav_b2"></div>

    <nav>

        <h1>Airlines Application</h1>

        <p class="nav_text_1"><a href="/" class="a_white">Главная</a></p>

    </nav>

</header>

<div class="content">

    <h2>Список билетов:</h2>

    <c:forEach items="${tickets}" var="ticket">
        <section>
            <p>Вылет: ${ticket.dateOfBeg}. Прибытие: ${ticket.dateOfEnd}</p>
            <p>Терминал: ${ticket.terminal}.</p>
            <p>Выход: ${ticket.gate}.</p>
            <p>Самолет: ${ticket.planeName}.</p>
            <p>Класс: ${ticket.planeType}.</p>
            <p>Билет на имя: ${ticket.userName} ${ticket.userSurname}.</p>
        </section>
    </c:forEach>

</div>

<footer>
    <p class="footer_text">Курсова робота Бездушного Владислава</p>
</footer>

</body>
</html>
