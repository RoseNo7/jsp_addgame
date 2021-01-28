<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>덧셈 게임 - 게임 코드</title>
    <link rel="stylesheet" href="css/game_code_info.css"/>
</head>
<body>
    <div class="header"></div>

    <div class="container">
        <div class="layout">
            <div class="top"> 게임 정보 </div>
            <div class="content">
                <div class="column">
                    <div class="number"> 번호 </div>
                    <div class="code">게임 코드</div>
                    <div class="date">날짜</div>
                    <div class="select-btn"></div>
                </div>

                <c:forEach items="${games}" var="game" varStatus="status">
                    <form class="game-list" action="QuestionInfoServlet">
                        <div class="item">${status.index + 1}</div>
                        <div class="item">
                            <input type="hidden" name="game_code" value="${game.gameCode}">${game.gameCode}
                        </div>
                        <div class="item">${game.date}</div>
                        <div class="item">
                            <input type="submit" value="보기"/>
                        </div>
                    </form>
                </c:forEach>
            </div>
        </div>

        <div class="content-bottom">
            <input type="button" class="confirm-btn" onclick="location.href='game_code_info.jsp'" value="뒤로"/>
        </div>
    </div>
    </div>
</body>
</html>
