$('.create-content-btn').click(function (e) {
    e.preventDefault();
    var id = $(this).attr('id');
    window.location.href = '/user/content/' + id;
});
