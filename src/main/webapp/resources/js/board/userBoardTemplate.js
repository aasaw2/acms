$("#boardContentSave").on('click', function (e) {
    var idx = $(this).attr("idx");
    alert(idx);
    window.location.href = "/user/board/content/" + idx;
});


$(".showDetail").click(function() {
    alert("click");
    // var str = "";
    // var tdArr = new Array();    // 배열 선언

    // 현재 클릭된 Row(<tr>)
    // var tr = $(this);
    // var td = tr.children();
    // tr.text()는 클릭된 Row 즉 tr에 있는 모든 값을 가져온다.
    //   console.log("클릭한 Row의 모든 데이터 : "+tr.text());
    //  console.log("클릭한 Row의 모든 데이터 : "+tr.attr("idx"));
    //console.log("클릭한 Row의 idx 데이터 : "+td.eq(1).text());
    //  console.log("클릭한 Row의 idx 데이터 : "+td.eq(0).text());

    // 반복문을 이용해서 배열에 값을 담아 사용할 수 도 있다.
    // td.each(function(i){
    //     tdArr.push(td.eq(i).text());
    // });

    //  console.log("배열에 담긴 값 : "+tdArr);
    //   console.log("배열에 담긴 값 : "+tdArr);

    var idx = $(this).attr("idx");
    alert(idx);
    location.href="/user/board/contents/detail/" + idx;
});