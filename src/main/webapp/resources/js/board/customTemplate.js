
$("#boardContentSave").click(function (e) {
    e.preventDefault();
    var id = $(this).attr('name');
    alert("click");
    alert(id);
    window.location.href = "/board/" + id + "/content";
});