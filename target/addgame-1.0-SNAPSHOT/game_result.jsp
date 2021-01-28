<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>덧셈 게임 - 결과</title>
    <link rel="stylesheet" href="css/game_result.css"/>
</head>
<body>
    <div class="header"></div>

    <div class="container">
        <div class="layout">
            <div class="top"> 게임 결과 </div>

            <div class="content">
                <div class="result">
                    총 ${score} 문제를 맞췄습니다.
                </div>

                <c:forEach items="${questions}" var="question" varStatus="status">
                    <div class="item">
                        <div class="question">${question.question} = </div>
                        <div class="input-answer">${input_ans.get("answer")[status.index]}</div>
                        <div class="text">정답 :</div>
                        <div class="answer">${question.answer}</div>
                    </div>
                </c:forEach>
            </div>

            <div class="content-bottom">
                <input type="button" class="confirm-btn" onclick="location.href='ReturnServlet'" value="확인"/>
            </div>
        </div>
    </div>
</body>
</html>
