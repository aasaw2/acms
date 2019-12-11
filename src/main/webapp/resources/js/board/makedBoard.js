$('#a_link').click(function () {
    var value = "";
    value = 'https://www.google.com';
    $('#a_link').val(value);
    var modify = $('#a_link').val();
    console.log(modify);
    alert("a_link success");
    window.location.href = value;
});

$('#button').click(function () {
    alert("버튼을 클릭하셨습니다.");
});