<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="Plane, Ticket">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Airlines</title>
    <link rel="shortcut icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRB9HFweS0fmrAKtV5kY6-cmKy_SicZQXe_18RH_NvEQ0EsrDaf">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&display=swap&subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">

    <style>

        body {
            margin: 0;
            background-color: #fff;
            color: #363636;
            font: 16px 'Roboto', Arial, sans-serif;
            min-width: 570px;
        }

        input, button, select {outline:none;}
        a,a:hover,a:link,a:visited,a:active {text-decoration: none;}

        h1, h2, h3 {font-size: 24px;}
        h3 {margin: 0; text-align: center;}

        h1 {
            text-align: center;
            margin: 0;
            padding: 10px 0;
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
            justify-content: space-between;
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

        .top_search {
            margin: 0 auto;
            width: 70%;
            text-align: center;
        }

        .search_text, .search_button {
            border-radius: 8px;
            height: 25px;
            font: 16px 'Roboto', Helvetica, Arial, sans-serif;
        }

        .search_text {
            height: 25px;
            padding: 0 6px;
            width: 200px;
            border: 1px solid #d1d1d1;
            color: #363636;
        }

        .search_text::-webkit-input-placeholder {color: #878787;}
        .search_text::-moz-placeholder          {color: #878787;}
        .search_text:-moz-placeholder           {color: #878787;}
        .search_text:-ms-input-placeholder      {color: #878787;}

        .search_button {
            background-color: #2bcf57;
            border: 1px solid #2bcf57;
            color: #fff;
            cursor: pointer;
        }

        .search_button:hover {background-color: #21de54; border: 1px solid #21de54;}
        .search_button:active {background-color: #22e657; border: 1px solid #22e657;}

        .date_selection {
            border: 1px solid #d1d1d1;
            border-radius: 8px;
            padding: 0 6px;
            height: 25px;
            font: 14px 'Roboto', Helvetica, Arial, sans-serif;
            width: 200px;
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

        @media (max-width: 870px) {
            .content {
                width: calc(100% - 20px);
                margin: 0;
            }
        }

        @media (max-width: 615px) {
            .search_text,.date_selection {
                margin-top: 10px;
            }
        }

    </style>
</head>
<body>
<header>
    <nav>
        <h1>Airlines Application</h1>
        <%
            if(request.getAttribute("isLoggedIn") != null){
                out.println("<p class=\"nav_text_1\"><a href=\"/tickets\" class=\"a_white\">Список билетов</a></p>");
                out.println("<p class=\"nav_text_2\"><a href=\"/logout\" class=\"a_white\">Выход</a></p>");
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
    <h3>Поиск билетов</h3>
    <div class="top_search">
        <div>
            <form method="post">

                <p>Откуда - Куда</p>

                <p>
                    <input list="CityFrom" name="from" placeholder="Откуда" class="search_text" required>
                    <datalist id="CityFrom">
                        <option value="Vinnitsya">
                        <option value="Kyiv">
                    </datalist>

                    <input list="CityTill" name="destination" placeholder="Куда" class="search_text" required>
                    <datalist id="CityTill">
                        <option value="Odessa">
                        <option value="Kyiv">
                    </datalist>
                </p>

                <p>Вылет</p>

                <p>
                    <input type="date" id="DateTodayFrom" name="dateOfBeg" value="2020-01-26" class="date_selection" required>
                </p>

                <p>Класс</p>

                <p>
                    <input list="ClassTicket" name="planeClass" placeholder="Класс" class="search_text">
                    <datalist id="ClassTicket">
                        <option value="Business">
                        <option value="Economy">
                    </datalist>
                </p>

                <p><input type="submit" value="Поиск" class="search_button"></p>

            </form>
        </div>
    </div>

</div>

<footer>
    <p class="footer_text">Курсова робота Бездушного Владислава</p>
</footer>

<script type="text/javascript">

    var date = new Date();

    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    var hours = date.getHours();
    var minutes = date.getMinutes();

    if (month < 10) month = "0" + month;
    if (day < 10) day = "0" + day;

    if (hours < 10) hours = "0" + hours;
    if (minutes < 10) minutes = "0" + minutes;

    var today = year + "-" + month + "-" + day;

    var TimeG = hours + ":" + minutes;

    document.getElementById("DateTodayFrom").value = today;
    document.getElementById("DateTodayTill").value = today;

    document.getElementById("TimeNow1").value = TimeG;
    document.getElementById("TimeNow2").value = TimeG;

</script>
</body>
</html>