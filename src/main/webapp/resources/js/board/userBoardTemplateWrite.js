$('#boardContentDelete').click(function (e) {
    alert("fuck you");
});

$('#boardContentSave').on('click', function (e) {
    alert("please....");
    var name = $('#boardContentName').val();
    var comment = $('#boardContentComment').val();

    var obj = {};
    obj.name = name;
    obj.comment = comment;

    $.ajax({
        type : "POST",
        url : '/user/board/content/${id}',
        data : JSON.stringify(obj),
        contentType : 'application/json',
        success : function () {
            alert("등록 되었습니다.");
            window.location.href = '/user/board/${id}';
        },
        error : function (xhr) {
            alert("error");
            console.log(xhr);
        }
    })
});
