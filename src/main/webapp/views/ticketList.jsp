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

    <style>

        body {
            margin: 0;
            background-image: url(https://imgclf.112.ua/original/2019/02/04/375677.jpg?timestamp=1549237452);
            background-position: center center;
            background-repeat: no-repeat;
            background-size: cover;
            background-attachment: fixed;
            background-color: #f5f5f5;
            color: #363636;
            font: 16px 'Roboto', Arial, sans-serif;
            min-width: 600px;
        }

        h1 {
            text-align: center;
            margin: 0;
            font-size: 24px;
            padding: 10px 124px 10px 0;
            color: #fff;
        }

        h2 {
            text-align: center;
            font-size: 24px;
            color: #fff;
        }

        header {
            width: 100%;
            position: fixed;
            background-color: rgba(40, 40, 40, 0.5);
            min-width: 570px;
        }

        nav {
            display: flex;
            flex-direction: row;
            justify-content: center;
            max-width: 600px;
            margin: auto;
            width: 80%;
        }

        .nav_b1,.nav_b2 {
            background-color: rgba(40, 40, 40, 0.5);
            width: 10%;
            height: 52px;
        }

        .nav_b1 {float: left;}
        .nav_b2 {float: right;}

        a,a:hover,a:link,a:visited,a:active {text-decoration: none;}

        .nav_text_1 {padding: 1px 26px 0 0;}
        .nav_text_2 {padding-top: 1px;}

        .a_white {color: #fff;}
        .a_white:hover {color: #f5f5f5;}
        .a_white:active {color: #ededed;}

        .content {
            width: calc(80% - 20px);
            margin: 0 10%;
            background-color: rgba(40, 40, 40, 0.5);
            padding: 60px 10px;
            min-height: calc(100vh - 120px);
        }

        .button_order{
            border: none;
            border-radius: 6px;
            color: #fff;
            cursor: pointer;
            padding: 5px;
        }

        section {
            padding: 6px;
            border: 1px solid #ccc;
            border-radius: 6px;
            max-width: 500px;
            margin: 10px auto 36px auto;
            background-color: #ffffffe5;
        }

        footer {
            width: 100%;
            background-color: rgba(40, 40, 40, 0.7);
            text-align: center;
        }

        .footer_text {
            padding: 14px 6px;
            margin: 0;
            color: #fff;
        }

    </style>
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
