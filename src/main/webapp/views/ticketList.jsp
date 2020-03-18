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
  
    <link rel="shortcut icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRB9HFweS0fmrAKtV5kY6-cmKy_SicZQXe_18RH_NvEQ0EsrDaf">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&display=swap&subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
    <link rel="stylesheet" href="style/style.css">
  
</head>
<body>

<header>
        <p class="nav_text_3"><a href="/" class="a_white">Главная</a></p>
</header>

<div class="content list_ticket ticket_style_1">

    <h3>Список билетов:</h3>

    <c:forEach items="${tickets}" var="ticket">
        <section>
          
          <div class="section_1">
            <h1 class="in_section">Airlines Application</h1>
            <div class="head_line"><div class="line"></div></div>
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRB9HFweS0fmrAKtV5kY6-cmKy_SicZQXe_18RH_NvEQ0EsrDaf" class="img_headline">
          </div>
          
          <div class="section_1">
            <div class="section_2">
              
              <p>Вылет: ${ticket.dateOfBeg}. Прибытие: ${ticket.dateOfEnd}</p>
              <p>Терминал: ${ticket.terminal}.</p>
              <p>Ворота: ${ticket.gate}.</p>
              <p>Самолет: ${ticket.planeName}.</p>
              <p>Класс: ${ticket.planeType}.</p>
              <p>Билет на имя: ${ticket.userName} ${ticket.userSurname}.</p>
              
            </div>
            
            <p class="p_img_code">
              <img src="https://ru.seaicons.com/wp-content/uploads/2015/10/Bar-Code-icon.png" class="img_code">
            </p>
            
          </div>
          
        </section>
    </c:forEach>

</div>

<footer class="ticket_style_2">
    <p class="footer_text">Курсова робота Бездушного Владислава</p>
</footer>

</body>
</html>
