<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<html>
<head>
    <meta charset="utf-8">
    <title>�������</title>
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
<c:forEach items="${planes}" var="plane">
    <h5>���: ${plane.name}</h5>
</c:forEach>
<div class="wall">
    <div class="wall_1">
        <button class="btn_st w3-btn w3-hover-green w3-round-large" onclick="location.href='/signup'">�����������</button>
        <button class="btn_st w3-btn w3-hover-green w3-round-large" onclick="location.href='/login'">����</button>
    </div>
</div>
</body>
</html>