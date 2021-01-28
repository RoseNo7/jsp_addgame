<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>덧셈 게임 - 회원 가입</title>
    <link rel="stylesheet" href="css/signup_form.css"/>
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
</head>

<body>
    <script src="js/signup_form.js"></script>
    <div class="header">
        <!-- 그림 -->
    </div>

    <div class="container">
        <div class="layout">
            <div class="blank"></div>

            <form class="content" method="post" action="SignupServlet" autocomplete="off" onsubmit="return validate();">
                <input type="text" class="input-info" name="user_id" id="id" placeholder="*아이디" maxlength="15"/>
                <span class="hidden-text" id="hiddenId"></span>

                <input type="password" class="input-info" name="user_pw" id="pw" placeholder="*비밀번호" maxlength="15"/>
                <span class="hidden-text" id="hiddenPw"></span>

                <input type="password" class="input-info" id="pwCheck" placeholder="*비밀번호 확인" maxlength="15"/>
                <span class="hidden-text" id="hiddenPwCheck"></span>

                <input type="text" class="input-info" name="user_name" id="name" placeholder="*이름"/>
                <span class="hidden-text" id="hiddenName"></span>

                <input type="email" class="input-info" name="user_email" id="email" placeholder="*이메일"/>
                <span class="hidden-text" id="hiddenEmail"></span>

                <input type="submit" class="sign-btn" value="가입하기"/>
            </form>
        </div>
    </div>
</body>
</html>
