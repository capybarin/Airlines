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

    <style>

        body {
            margin: 0;
            background-color: #f5f5f5;
            color: #fff;
            font: 16px 'Roboto', Arial, sans-serif;
            min-width: 570px;
        }

        input, button {outline:none;}
        a,a:hover,a:link,a:visited,a:active {text-decoration: none;}

        header {
            width: 100%;
            position: fixed;
            background-color: rgba(40, 40, 40, 0.5);
            min-width: 570px;
        }

        h1 {
            text-align: center;
            padding: 10px 0;
        }

        h2, h1 {
            margin: 0;
            font-size: 24px;
        }

        .text_shadow {
            text-shadow: 1px 1px 8px #000;
        }

        .home_img_big {
            width: 100%;
            height: 100vh;
            background-image: url(https://imgclf.112.ua/original/2019/02/04/375677.jpg?timestamp=1549237452);
            background-position: center center;
            background-repeat: no-repeat;
            background-size: cover;
            text-align: center;
            min-width: 570px;
        }

        .home_text {
            width: 100%;
            margin-top: calc(26vh + 48px);
            position: absolute;
            text-align: center;
            min-width: 570px;
        }

        .log_block {
            width: 200px;
            margin: 0 auto;
            text-align: left;
        }

        .button_enter,.button_back {
            background-color: #2bcf57;
            border: none;
            border-radius: 6px;
            color: #fff;
            cursor: pointer;
            padding: 5px;
            box-shadow:         0px 6px 14px 0px rgba(0, 0, 0, 0.3);
            -webkit-box-shadow: 0px 6px 14px 0px rgba(0, 0, 0, 0.3);
            -moz-box-shadow:    0px 6px 14px 0px rgba(0, 0, 0, 0.3);
        }

        .button_enter {background-color: #2bcf57; margin-top: 30px;}
        .button_back {background-color: #2b7dcf; margin-top: 60px;}

        .button_enter:hover {background-color: #21de54;}
        .button_back:hover {background-color: #2786e6;}

        .button_enter:active {background-color: #22e657;}
        .button_back:active {background-color: #389bff;}

        .input_text {
            border: 1px solid #474747;
            border-radius: 6px;
            padding: 2px;
            background-color: rgba(40, 40, 40, 0.5);
            color: #fff;
            width: 200px;
        }

    </style>


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