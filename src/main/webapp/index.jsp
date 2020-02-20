<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<html>
<head>
    <meta charset="utf-8">
    <title>Главная</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        h1 {text-align: right;}

        footer {
            margin-top: 21%;
            padding: 20px 50px;
            background-color: #9aabb4;
            color: #fff;
        }

    </style>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Airlines application</h1>
</div>
<div class="wall">
    <div class="wall_1">
        <button class="btn_st w3-btn w3-hover-green w3-round-large" onclick="location.href='/signup'">Регистрация</button>
        <button class="btn_st w3-btn w3-hover-green w3-round-large" onclick="location.href='/login'">Вход</button>
    </div>
</div>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Направления:</h2>
        </div>
        <c:forEach items="${planes}" var="plane">
            <ul class="w3-ul">
                <li class="w3-hover-sand">
                    <h5>${plane.from} --> ${plane.to};   ${plane.price} грн.; вылет: ${plane.date}</h5>
                    <form method="post" class="w3-hover-sand">
                        <button type="submit" name="id" class="w3-btn w3-green w3-round-large w3-margin-bottom" value=${plane.id}>Заказать билет</button>
                    </form>
                </li>
            </ul>
        </c:forEach>
    </div>
</div>
</body>
</html>