$(".authority_btn").click(function (e) {
    e.preventDefault();

    var str_mpa = $('#mpa_html').html();

    var div = document.createElement('div');
    div.className = 'createList';
    div.innerHTML = str_mpa;
    document.getElementById('table-right').appendChild(div);
    // $('.table-right').html(str_mpa);
    // $('#mpa_table').remove();
    // var mpa = $('.mpa_html').val();
    // $('#mpa_table').html(mpa);
});

$('#authoritySave').click(function (e) {
    e.preventDefault();
    var check_array = new Array();
    var check_info = document.getElementsByName('chk_info');
    var int_j = 0;
    for (var i = 0; i < check_info.length; i++) {
        if (check_info[i].checked == true ) {
            check_array[int_j] = check_info[i].id;
            int_j++;
        }
    }

    for (var i = 0; i < check_array.length; i++) {
        console.log(check_array[i]);
    }

    var json_obj = {};
    json_obj.names = check_array;
    var url = "/custom/list";
    $.ajax({
        method : 'post',
        url : url,
        data : JSON.stringify(json_obj),
        contentType : 'application/json',
        error : function (xhr) {
            console.log(xhr);
            alert("error is working")
        }, success : function (data) {
            console.log(data);
            alert('success is working')
        }
    });
    alert("세이브 클릭")
});