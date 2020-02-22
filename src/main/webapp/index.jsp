<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="Plane, Ticket">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Airlines</title>

    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&display=swap&subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">

    <style>

        body {
            margin: 0;
            background-color: #f5f5f5;
            color: #363636;
            font: 16px 'Roboto', Arial, sans-serif;
            min-width: 570px;
        }

        input, button {outline:none;}
        a,a:hover,a:link,a:visited,a:active {text-decoration: none;}

        h1, h2, h3 {font-size: 24px;}
        h3 {margin: 0; text-align: center;}

        h1 {
            text-align: center;
            margin: 0;
            padding: 10px 124px 10px 0;
            color: #fff;
        }

        h2 {
            color: #fff;
            font-weight: 400;
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
        }

        .nav_text_1 {padding: 1px 26px 0 0;}
        .nav_text_2 {padding-top: 1px;}

        .a_white {color: #fff;}
        .a_white:hover {color: #f5f5f5;}
        .a_white:active {color: #ededed;}

        .home_img_big {
            width: 100%;
            height: 60vh;
            background-image: url(https://imgclf.112.ua/original/2019/02/04/375677.jpg?timestamp=1549237452);
            background-position: center center;
            background-repeat: no-repeat;
            background-size: cover;
            text-align: center;
            min-width: 570px;
        }

        .home_text {
            width: 100%;
            margin-top: 35vh;
            position: absolute;
            text-align: center;
            min-width: 570px;
        }

        .enter_buttons {color: #fff;}

        .button_log {background-color: #2b7dcf;}
        .button_order {background-color: #2bcf57;}

        .button_log:hover {background-color: #2786e6;}
        .button_order:hover {background-color: #21de54;}

        .button_log:active {background-color: #389bff;}
        .button_order:active {background-color: #22e657;}

        .button_order,.button_log {
            border: none;
            border-radius: 6px;
            color: #fff;
            cursor: pointer;
            padding: 5px;
        }

        .text_shadow {
            text-shadow: 1px 1px 8px #000;
        }

        .shadow {
            box-shadow:         0px 6px 14px 0px rgba(0, 0, 0, 0.3);
            -webkit-box-shadow: 0px 6px 14px 0px rgba(0, 0, 0, 0.3);
            -moz-box-shadow:    0px 6px 14px 0px rgba(0, 0, 0, 0.3);
        }

        .content {
            width: calc(80% - 20px);
            margin: 0 10%;
            background-color: #fff;
            padding: 18px 10px;
        }

        section {
            padding: 6px;
            border: 1px solid #ccc;
            border-radius: 6px;
            max-width: 400px;
            margin: 10px auto 36px auto;
        }

        footer {
            width: 100%;
            background-color: #ededed;
            text-align: center;
        }

        .footer_text {
            padding: 14px 6px;
            margin: 0;
        }

    </style>
</head>
<body>
<header>
    <nav>
        <h1>Airlines Application</h1>
        <%
            if(request.getAttribute("isLoggedIn") != null){
                out.println("<p class=\"nav_text_1\"><a href=\"\" class=\"a_white\">Список билетов</a></p>");
                out.println("<p class=\"nav_text_2\"><a href=\"\" class=\"a_white\">Выход</a></p>");
            }
        %>
    </nav>
</header>

<div class="home_img_big">
    <div class="home_text">
        <h2 class="text_shadow">В полет без забот</h2>
        <div class="enter_buttons">
            <%
                if(request.getAttribute("isLoggedIn") == null){
                    out.println("<button class=\"button_log shadow\" onclick=\"location.href='/signup'\">Регистрация</button>");
                    out.println("<button class=\"button_log shadow\" onclick=\"location.href='/login'\">Вход</button>");
                }
            %>
            <%
                if(request.getAttribute("isLoggedIn") != null){
                    out.println("<div><p class=\"text_shadow\">Добро пожаловать, "+request.getAttribute("login") + "</p></div>");
                }
            %>
        </div>
    </div>
</div>


<div class="content">
    <h3>Направления:</h3>
    <c:forEach items="${planes}" var="plane">
        <section>
                <p>${plane.from} &#8594; ${plane.to};   ${plane.price} грн.; вылет: ${plane.date}</p>
                <form method="post" class="">
                    <button type="submit" class="button_order" name="id" value=${plane.id}>Заказать билет</button>
                </form>
        </section>
    </c:forEach>

</div>

<footer>
    <p class="footer_text">Курсова робота Бездушного Владислава</p>
</footer>
</body>
</html>