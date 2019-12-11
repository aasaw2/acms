/*$( document ).ready(function() {
  alert("ready!!!");
});*/

$( "#accountSave" ).click(function() {
    location.href="/SingUp.ap";
});

/*$( "#accountAdd" ).click(function() {
    alert("등록");
    frm = $("#accountAddForm");
    frm.action = "/JoinMemberProcessing";
    frm.submit();
});*/

$("#accountAdd").click(function(e) {
    alert("등록");
    e.preventDefault();
  //  if(!confirm('정말로 삭제하시겠습니까?')) return;
    $('#accountAddForm')[0].submit();
});