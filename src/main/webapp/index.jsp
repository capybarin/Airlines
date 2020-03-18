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
    <link rel="stylesheet" href="style/style.css">
    
</head>
<body>
<header>
    <nav>
        <h1 class="app_name">Airlines Application</h1>
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
        <div class="p_white">
            <%
                if(request.getAttribute("isLoggedIn") == null){
                    out.println("<button class=\"button_log button_main shadow\" onclick=\"location.href='/signup'\">Регистрация</button>");
                    out.println("<button class=\"button_log button_main shadow\" onclick=\"location.href='/login'\">Вход</button>");
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
        <div class="in_top_search">
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
                    <input type="date" id="DateTodayFrom" name="dateOfBeg" class="date_selection">
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

    <script type="text/javascript" src='dateScript.js'></script>
    
</body>
</html>
