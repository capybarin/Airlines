<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 17.02.2020
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="Plane, Ticket">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Вход</title>

    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&display=swap&subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
    <link rel="stylesheet" href="style/style.css">


</head>
<body>

<header>
    <h1>Airlines Application</h1>
</header>

<div class="home_img_big">
    <div class="home_text">
        <div>
            <h2 class="text_shadow">Вход</h2>
        </div>
        <%
            if(request.getAttribute("error") != null){
                out.println("<h2 class=\"text_shadow\">"+request.getAttribute("error")+"</h2>");
            }
        %>
        <div class="log_block">
            <form method="post" class="">
                <p class="text_shadow">Логин:</p>
                <input type="text" name="name" class="input_text">

                <p class="text_shadow">Пароль:</p>
                <input type="password" name="pass" class="input_text"><br>

                <button type="submit" class="button_enter">Подтвердить</button>
            </form>
        </div>

        <button class="button_back" onclick="location.href='/'">Назад</button>

    </div>
</div>

</body>
</html>