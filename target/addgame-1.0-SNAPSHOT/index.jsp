<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>덧셈 게임</title>
    <link rel="stylesheet" href="css/index.css"/>
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
</head>
<body>
    <div class="header"></div>

    <div class="container">
        <div class="layout">
            <div class="content">
                <div class="square">덧셈</div>
                <div class="square">+</div>
                <div class="square">게임</div>

                <form class="login-box" method="post" action="LoginServlet">
                    <div class="login-area">
                        <input type="text" class="input" name="user_id" placeholder="아이디" maxlength="15"/>
                        <input type="password" class="input" name="user_pw" placeholder="비밀번호" maxlength="15"/>
                    </div>

                    <input type="submit" class="login-btn" value="로그인"/>
                </form>
            </div>

            <div class="content-bottom">
                <div>
                    <input type="button" class="sign-btn" onclick="location.href='SignupServlet'" value="회원가입"/>
                </div>
            </div>
        </div>
    </div>
</body>
</html>