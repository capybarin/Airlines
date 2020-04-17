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
    <p class="nav_text_3"><a href="/" class="a_white">Главная</a></p>
  </header>
  
  <div class="block_rout">
    
        <c:if test="${not empty dirList}">
          
            <p class="name_routes">Прямые перелеты:</p>
          
            <main>
              
               <div class="t_compa">Авиакомпания</div>
               <div class="t_plane">Воздушное судно</div>
               <div class="t_class">Класс</div>
               <div class="t_depar">Дата</div>
               <div class="t_f_rou">Вылет</div>
               <div class="t_t_rou">Прибытие</div>
               <div class="t_seats">Посадочные места</div>
               <div class="t_price">Цена</div>
          
              <c:forEach items="${dirList}" var="dir">
                  <div class="c_compa">${dir.company}</div>
                  <div class="c_plane">${dir.name}</div>
                  <div class="c_class">${dir.type}</div>
                  <div class="c_depar">${dir.date}</div>
                  <div class="c_f_rou">${dir.from}</div>
                  <div class="c_t_rou">${dir.to}</div>
                  <div class="c_seats">${dir.seats}</div>
                  <div class="c_price">${dir.price} грн.</div>
              </c:forEach>
              
             </main>
        </c:if>

        <c:if test="${not empty notDirList}">
          
            <p class="name_routes">Непрямые перелеты:</p>
          
            <main>
                <div class="t_compa">Авиакомпания</div>
                <div class="t_plane">Воздушное судно</div>
                <div class="t_class">Класс</div>
                <div class="t_depar">Дата</div>
                <div class="t_f_rou">Вылет</div>
                <div class="t_t_rou">Пересадка</div>
                <div class="t_seats">Прибытие</div>
                <div class="t_price">Цена</div>
              
                <c:forEach items="${notDirList}" var="ndir">
                    <div class="c_compa">${ndir.company}</div>
                    <div class="c_plane">${ndir.name}</div>
                    <div class="c_class">${ndir.type}</div>
                    <div class="c_depar">${ndir.date}</div>
                    <div class="c_f_rou">${ndir.from}</div>
                    <div class="c_t_rou">${ndir.tmpLoc}</div>
                    <div class="c_seats">${ndir.to}</div>
                    <div class="c_price">${ndir.price} грн.</div>
                </c:forEach>
              
             </main>
        </c:if>
    
  </div>
</body>
</html>
