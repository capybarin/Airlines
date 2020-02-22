<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 17.02.2020
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="Plane, Ticket">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Ошибка</title>

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
            margin: 0;
            padding: 10px 0;
            font-size: 24px;
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
            margin-top: calc(24vh + 48px);
            position: absolute;
            text-align: center;
            min-width: 570px;
        }

        .text_shadow {
            text-shadow: 1px 1px 8px #000;
        }

        .img_error {height: 26vh;}

        .button_log {
            border: none;
            border-radius: 6px;
            color: #fff;
            cursor: pointer;
            padding: 5px;
            background-color: #2b7dcf;
            margin-top: 30px;
            box-shadow:         0px 6px 14px 0px rgba(0, 0, 0, 0.3);
            -webkit-box-shadow: 0px 6px 14px 0px rgba(0, 0, 0, 0.3);
            -moz-box-shadow:    0px 6px 14px 0px rgba(0, 0, 0, 0.3);
        }

        .img_error {height: 26vh;}
        .button_log:hover {background-color: #2786e6;}
        .button_log:active {background-color: #389bff;}

    </style>

</head>
<body>

<header>
    <h1>Airlines Application</h1>
</header>

<div class="home_img_big">
    <div class="home_text">
        <div class="">
            <p class="text_shadow">Упс! Вы не вошли в систему, заказ билета невозможен!</p>
        </div>

        <div>
            <img class="img_error" src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Crystal_Clear_app_error.svg/1024px-Crystal_Clear_app_error.svg.png" alt="ERROR">
        </div>

        <button class="button_log" onclick="location.href='/'" >На главную</button>

    </div>
</div>

</body>
</html>
