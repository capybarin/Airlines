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

    <link rel="shortcut icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRB9HFweS0fmrAKtV5kY6-cmKy_SicZQXe_18RH_NvEQ0EsrDaf">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&display=swap&subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
    <link rel="stylesheet" href="style/style.css">

</head>
<body class="body_full">

  <header>
      <h1 class="head_login">Airlines Application</h1>
  </header>

  <div class="log_text">
        <div>
            <h2 class="text_shadow">Вход</h2>
        </div>
        <%
            if(request.getAttribute("error") != null){
                out.println("<h2 class=\"text_shadow\">"+request.getAttribute("error")+"</h2>");
            }
        %>
        
            <form method="post">
              
              <div class="log_block">
                
                <p class="text_shadow">Логин:</p>
                <input type="text" name="name" class="input_text shadow">

                <p class="text_shadow">Пароль:</p>
                <input type="password" name="pass" class="input_text shadow"><br>
                
              </div>
              

                <button type="submit" class="search_button shadow button_enter">Подтвердить</button>
              
            </form>
      <button class="button_log button_back shadow" onclick="location.href='/'">Назад</button>

  </div>

</body>
</html>
