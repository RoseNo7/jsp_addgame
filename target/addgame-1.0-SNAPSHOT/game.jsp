<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>게임 시작</title>
    <link rel="stylesheet" href="css/game.css"/>
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
</head>
<body>
    <script src="js/game.js"></script>

    <div class="header"></div>

    <div class="container">
        <div class="layout">
            <div class="content">
                <form class="input-answer" action="AssessServlet" onsubmit="return assess();">
                    <c:forEach items="${questions}" var="q">
                        <div class="question">
                            ${q.question} =
                            <input type="text" class="answer" name="answer"/>
                        </div>
                    </c:forEach>

                    <div class="content-bottom">
                        <input type="submit" class="assess-btn" value="제출"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
