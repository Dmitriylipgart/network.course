<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/css/login.css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
</head>
<body>

<div id="wrapper">
    <div class="user-icon"></div>
    <div class="pass-icon"></div>

    <form action="login" name="login-form" class="login-form" method="get">

        <div class="header">
            <h1>Авторизация</h1>
            <span>Введите ваши регистрационные данные для входа. </span>
            <p>
                <span>Подсказка: Пока это - Login и Password. )) </span>
            </p>
            <p ><span style="color: red">${AuthError}</span></p>

        </div>

        <div class="content">
            <input name="name" type="text" class="input username" placeholder="Введите Логин" />
            <input name="password" type="password" class="input password" placeholder="Введите Пароль" />
        </div>

        <div class="footer">
            <input type="submit" name="submit" value="ВОЙТИ" class="button" />
            <input type="submit" name="submit" value="Регистрация" class="register" />
        </div>

    </form>
</div>


<script type="text/javascript">
    $(document).ready(function() {
        $(".username").focus(function() {
            $(".user-icon").css("left","-48px");
        });
        $(".username").blur(function() {
            $(".user-icon").css("left","0px");
        });

        $(".password").focus(function() {
            $(".pass-icon").css("left","-48px");
        });
        $(".password").blur(function() {
            $(".pass-icon").css("left","0px");
        });
    });
</script>

</div>



</body>
</html>
