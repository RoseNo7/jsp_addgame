<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>덧셈 게임 - 메뉴</title>
    <link rel="stylesheet" href="css/main.css"/>
</head>
<body>
    <div class="header"></div>

    <div class="container">
        <div class="layout">
            <div class="user">
                <input type="text" class="info" value="${sessionScope.user} 님 환영합니다.">
                <input type="button" class="logout-btn" onclick="location.href='LogoutServlet'" value="로그 아웃"/>
            </div>

            <div class="blank"></div>

            <div class="menu">
                <input type="button" class="menu-btn" onclick="location.href='GameServlet'" value="게임 시작"/>
                <input type="button" class="menu-btn" onclick="location.href='GameInfoServlet'" value="게임 정보"/>
            </div>
        </div>
    </div>
</body>
</html>
