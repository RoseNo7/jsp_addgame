$(function () {
    $("#id").on("blur", function () {
        var id = $("#id").val();

        if (id == '') {
            $("#hiddenId").css("margin-bottom", "10px");
            $("#hiddenId").css("color", "red");
            $("#hiddenId").text("아이디를 입력하세요");

            return;
        }

        var regex = /^[a-z\d]{5,15}/
        var result = regex.exec(id);        // 정규식 내 입력값이 들어옴

        if (result != null) {
            checkID(id);
        } else {
            $("#hiddenId").css("margin-bottom", "10px");
            $("#hiddenId").css("color", "red");
            $("#hiddenId").text("5-15자의 소문자, 숫자만 가능합니다");
        }
    });


    $("#pw").on("focusin", function () {
        $("#hiddenPw").css("margin-bottom", "0");
        $("#hiddenPw").text("");
    });

    $("#pw").on("blur", function () {
        if ($("#pw").val() == '') {
            $("#hiddenPw").css("margin-bottom", "10px");
            $("#hiddenPw").text("비밀번호를 입력하세요");
        }
    });

    $("#pwCheck").on("blur", function () {
        if ($("#pwCheck").val() == '') {
            $("#hiddenPwCheck").css("margin-bottom", "10px");
            $("#hiddenPwCheck").css("color", "red");
            $("#hiddenPwCheck").text("비밀번호를 입력하세요");
        } else if ($("#pw").val() == $("#pwCheck").val()) {
            $("#hiddenPwCheck").css("margin-bottom", "10px");
            $("#hiddenPwCheck").css("color", "green");
            $("#hiddenPwCheck").text("비밀번호가 일치합니다");
        } else {
            $("#hiddenPwCheck").css("margin-bottom", "10px");
            $("#hiddenPwCheck").css("color", "red");
            $("#hiddenPwCheck").text("비밀번호가 일치하지 않습니다");
        }
    });


    $("#name").on("blur", function () {
        if ($("#name").val() == '') {
            $("#hiddenName").css("margin-bottom", "10px");
            $("#hiddenName").text("이름을 입력하세요");
        } else {
            $("#hiddenName").css("margin-bottom", "0");
            $("#hiddenName").text("");
        }
    });

    $("#email").on("blur", function () {
        if ($("#pw").val() == '') {
            $("#hiddenEmail").css("margin-bottom", "10px");
            $("#hiddenEmail").text("이메일을 입력하세요");
        } else {
            $("#hiddenEmail").css("margin-bottom", "0");
            $("#hiddenEmail").text("");
        }
    });
});

function checkID(id) {
    $.ajax({
        async: true,
        type: "post",
        url: "./CheckId.do",
        data: {"id": id},
        success: function (data) {
            if (data == "exist") {
                $("#hiddenId").css("margin-bottom", "10px");
                $("#hiddenId").css("color", "red");
                $("#hiddenId").text("이미 사용중인 아이디입니다");
            } else {
                $("#hiddenId").css("margin-bottom", "10px");
                $("#hiddenId").css("color", "green");
                $("#hiddenId").text("사용 가능한 아이디입니다");
            }
        },
        error: function (request) {
            alert("code:" + request.status);
        }
    });
}

function validate() {
    var regexID = /^[a-z\d]{5,15}/;
    var regexPW = /^[A-Za-z\d]{4,15}$/;

    if (!regexID.test($("#id").val())) {
        alert("아이디를 제대로 입력해주세요");
        $("#id").focus();
        return false;
    }

    // 아이디 중복 확인 해야함


    if (!regexPW.test($("#pw").val())) {
        alert("비밀번호를 제대로 입력해주세요");
        $("#pw").focus();
        return false;
    }

    if ($("#pw").val() != $("#pwCheck").val()) {
        alert("비밀번호가 다릅니다.")
        $("#pwCheck").focus();
        return false;
    }

    if ($("#name").val() == "") {
        alert("이름을 입력해주세요");
        $("#name").focus();
        return false;
    }

    if ($("#email").val() == "") {
        alert("이메일을 입력해주세요");
        $("#email").focus();
        return false;
    }

    return true
}