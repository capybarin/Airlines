<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 15.03.2020
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  
    <meta charset="UTF-8">
    <meta name="keywords" content="Plane, Ticket">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Маршруты</title>
  
    <link rel="shortcut icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRB9HFweS0fmrAKtV5kY6-cmKy_SicZQXe_18RH_NvEQ0EsrDaf">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&display=swap&subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
    <link rel="stylesheet" href="style/style.css">
  
</head>
<body>
  
  <header>
    <h1 class="head_login">Airlines Application</h1>
  </header>
  
  <div class="content list_ticket routes">
    
    <div class="block_rout">
        <c:if test="${not empty dirList}">
            <p class="name_routes">Прямые перелеты:</p>
            <c:forEach items="${dirList}" var="dir">
              <p>Авиакомпания: ${dir.company}</p>
              <p>Воздушное судно: ${dir.name}</p>
              <p>Вылет: ${dir.date} Класс: ${dir.type}</p>
              <p>Маршрут: ${dir.from} --> ${dir.to}</p>
              <p>Цена: ${dir.price}; Посдаочных мест: ${dir.seats}</p>
            </c:forEach>
        </c:if>
    </div>

    <div class="block_rout">
        <c:if test="${not empty notDirList}">
            <p class="name_routes">Непрямые перелеты:</p>
            <c:forEach items="${notDirList}" var="ndir">
              <p>Авиакомпания: ${ndir.company}</p>
              <p>Воздушное судно: ${ndir.name}</p>
              <p>Вылет: ${ndir.date} Класс: ${ndir.type}</p>
              <p>Маршрут: ${ndir.from} --> ${ndir.tmpLoc} --> ${ndir.to}</p>
              <p>Цена: ${ndir.price}</p>
            </c:forEach>
        </c:if>
    </div>
    
  </div>
</body>
</html>
