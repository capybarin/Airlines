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
    <title>Title</title>
    <link rel="stylesheet" href="style/style.css">
</head>
<body>
<div>
    <c:if test="${not empty dirList}">
        Прямые перелеты:
        <c:forEach items="${dirList}" var="dir">
            <ul>
                <li>
                    <h5>Авиакомпания: ${dir.company}</h5>
                    <h5>Воздушное судно: ${dir.name}</h5>
                    <h5>Вылет: ${dir.date} Класс: ${dir.type}</h5>
                    <h5>Маршрут: ${dir.from} --> ${dir.to}</h5>
                    <h5>Цена: ${dir.price}; Посдаочных мест: ${dir.seats}</h5>
                </li>
            </ul>
        </c:forEach>
    </c:if>
</div>

<div>
    <c:if test="${not empty notDirList}">
        Непрямые перелеты:
        <c:forEach items="${notDirList}" var="ndir">
            <ul>
                <li>
                    <h5>Авиакомпания: ${ndir.company}</h5>
                    <h5>Воздушное судно: ${ndir.name}</h5>
                    <h5>Вылет: ${ndir.date} Класс: ${ndir.type}</h5>
                    <h5>Маршрут: ${ndir.from} --> ${ndir.tmpLoc} --> ${ndir.to}</h5>
                    <h5>Цена: ${ndir.price}</h5>
                </li>
            </ul>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
