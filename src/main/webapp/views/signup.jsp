<%@ page import="com.airlines.app.validators.EmailValidator" %><%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 17.02.2020
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="Plane, Ticket">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Регистрация</title>

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
            <h2 class="text_shadow">Регистрация</h2>
        </div>
            <%
            if(request.getAttribute("error") == null){
                if (request.getAttribute("userName") != null) {
                    if (request.getAttribute("userSurname") != null) {
                        out.println("<p class=\"text_shadow\">Пользоватль '" + request.getAttribute("userName") + " "
                                + request.getAttribute("userSurname") + "' зарегистрирован!</p>");
                        out.println("<button class=\"button_enter\" onclick=\"location.href='/login'\">Перейти на страницу входа</button>");
                    }
                }
            } else { out.println(request.getAttribute("error")); }
             %>
        <div class="log_block">
            <form method="post">
                <p class="text_shadow">Логин:</p>
                <input type="text" name="login" class="input_text">

                <p class="text_shadow">Пароль:</p>
                <input type="password" name="pass" class="input_text">

                <p class="text_shadow">Почта:</p>
                <input type="text" name="mail" class="input_text">

                <p class="text_shadow">Имя:</p>
                <input type="text" name="name" class="input_text">

                <p class="text_shadow">Фамилия:</p>
                <input type="text" name="surname" class="input_text"><br>

                <button type="submit" class="button_enter">Подтвердить</button>
            </form>
        </div>

        <button class="button_back" onclick="location.href='/'">Назад</button>

    </div>
</div>

</body>
</html>
