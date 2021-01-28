function assess() {
    var regex = /^[0-9]{1,3}/;

    $(".answer").each( function() {
        if (!regex.test($(this).val())) {
            alert("문제를 다 풀지 않았습니다.");
            return false;
        }
    });
}
