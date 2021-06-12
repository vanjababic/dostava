
var narudzbinaDodeljenaId = -1;
var dostavljacId = -1;
$(document).ready(function () {

    var obavestenjeDodeljenaNarudzbina = $(".obavestenjeDodeljenaNarudzbina");
    obavestenjeDodeljenaNarudzbina.hide();
    var obavestenjeNijeDodeljenaNarudzbina = $(".obavestenjeNijeDodeljenaNarudzbina");
    obavestenjeNijeDodeljenaNarudzbina.hide();

    $.ajax({
        type: "GET",
        url: "http://localhost:8081/dostavljaci/prijavljeniDostavljacId",
        dataType: "json",
        contentType: "application/json",
        beforeSend: function (xhr) {
            if (localStorage.token) {
                xhr.setRequestHeader('Authorization', 'Bearer ' + localStorage.token);
            }},
        success: function (data) {
            console.log("SUCCESS : ", data);
            dostavljacId = data['id'];
        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });


    $.ajax({
        type: "GET",
        url: "http://localhost:8081/ponude/dodeliDostavljaca",
        dataType: "json",
        contentType: "application/json",
        beforeSend: function (xhr) {
            if (localStorage.token) {
                xhr.setRequestHeader('Authorization', 'Bearer ' + localStorage.token);
            }},
        success: function (data) {
            console.log("SUCCESS : ", data);
            narudzbinaDodeljenaId = data['narudzbinaId'];
            if (dostavljacId == data['dostavljacId']){
                obavestenjeDodeljenaNarudzbina.show();
            }else {
                obavestenjeNijeDodeljenaNarudzbina.show();
            }
        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});