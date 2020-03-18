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
  
    <link rel="shortcut icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRB9HFweS0fmrAKtV5kY6-cmKy_SicZQXe_18RH_NvEQ0EsrDaf">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&display=swap&subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
    <link rel="stylesheet" href="style/style.css">

</head>
<body class="body_full">
  
  <header>
      <h1 class="head_login">Airlines Application</h1>
  </header>

    <div class="reg_text">
        <div>
            <h2 class="text_shadow">Регистрация</h2>
        </div>
            <%
            if(request.getAttribute("error") == null){
                if (request.getAttribute("userName") != null) {
                    if (request.getAttribute("userSurname") != null) {
                        out.println("<p class=\"text_shadow p_white\">Пользоватль '" + request.getAttribute("userName") + " "
                                + request.getAttribute("userSurname") + "' зарегистрирован!</p>");
                        out.println("<button class=\"button_log button_back shadow\" onclick=\"location.href='/login'\">Перейти на страницу входа</button>");
                    }
                }
            } else { out.println(request.getAttribute("error")); }
             %>
        
            <form method="post">
              <div class="log_block">
                
                <p class="text_shadow">Логин:</p>
                <input type="text" name="login" class="input_text" required>
                
                <p class="text_shadow">Почта:</p>
                <input type="text" name="mail" class="input_text" required>
                
                <p class="text_shadow">Имя:</p>
                <input type="text" name="name" class="input_text" required>

                <p class="text_shadow">Фамилия:</p>
                <input type="text" name="surname" class="input_text" required>
                
                <p class="text_shadow">Пароль:</p>
                <input type="password" name="pass" id="password1" class="input_text" required>
                
                <p class="text_shadow">Пароль повторно:</p>
                <input type="password" id="password2" class="input_text" required>

              </div>
              
                <button class="button_log button_back shadow" onclick="location.href='/'">Назад</button>
                <button type="submit" class="search_button shadow button_enter">Подтвердить</button>
              
            </form>

    </div>
  
  <script type="text/javascript" src='validationPassword.js'></script>

</body>
</html>
