
var narudzbinaDodeljenaId = -1;
var dostavljacId = -1;
$(document).ready(function () {

    var obavestenjeDodeljenaNarudzbina = $(".obavestenjeDodeljenaNarudzbina");
    obavestenjeDodeljenaNarudzbina.hide();
    var obavestenjeNijeDodeljenaNarudzbina = $(".obavestenjeNijeDodeljenaNarudzbina");
    obavestenjeNijeDodeljenaNarudzbina.hide();
    var podaciONarudzbini = $(".podaciONarudzbini");
    podaciONarudzbini.hide();

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


$(document).on('click', '#btnPodaci', function () {

    var obavestenjeDodeljenaNarudzbina = $(".obavestenjeDodeljenaNarudzbina");
    obavestenjeDodeljenaNarudzbina.hide();
    var obavestenjeNijeDodeljenaNarudzbina = $(".obavestenjeNijeDodeljenaNarudzbina");
    obavestenjeNijeDodeljenaNarudzbina.hide();
    var podaciONarudzbini = $(".podaciONarudzbini");
    podaciONarudzbini.show();
    var preuzeta = $(".preuzeta");
    preuzeta.hide();
    var dostavljena = $(".dostavljena");
    dostavljena.hide();

    $(document).on('click', '#btnPreuzetoIzRestorana', function () {

        var obavestenjeDodeljenaNarudzbina = $(".obavestenjeDodeljenaNarudzbina");
        obavestenjeDodeljenaNarudzbina.hide();
        var obavestenjeNijeDodeljenaNarudzbina = $(".obavestenjeNijeDodeljenaNarudzbina");
        obavestenjeNijeDodeljenaNarudzbina.hide();
        var podaciONarudzbini = $(".podaciONarudzbini");
        podaciONarudzbini.show();
        var preuzeta = $(".preuzeta");
        preuzeta.hide();
        var dostavljena = $(".dostavljena");
        dostavljena.hide();

        var nar = JSON.stringify({"id":narudzbinaDodeljenaId});

        $.ajax({
            type: "POST",
            url: "http://localhost:8081/narudzbine/preuzetaIzRestorana",
            dataType: "json",
            contentType: "application/json",
            data:nar,
            beforeSend: function (xhr) {
                if (localStorage.token) {
                    xhr.setRequestHeader('Authorization', 'Bearer ' + localStorage.token);
                }},
            success: function (data) {
                console.log("SUCCESS : ", data);
                preuzeta.show();
            },
            error: function (data) {
                console.log("ERROR : ", data);
            }
        });



    });

    $(document).on('click', '#btnDostavljenoKorisniku', function () {

        var obavestenjeDodeljenaNarudzbina = $(".obavestenjeDodeljenaNarudzbina");
        obavestenjeDodeljenaNarudzbina.hide();
        var obavestenjeNijeDodeljenaNarudzbina = $(".obavestenjeNijeDodeljenaNarudzbina");
        obavestenjeNijeDodeljenaNarudzbina.hide();
        var podaciONarudzbini = $(".podaciONarudzbini");
        podaciONarudzbini.show();
        var preuzeta = $(".preuzeta");
        preuzeta.hide();
        var dostavljena = $(".dostavljena");
        dostavljena.hide();

        var nar = JSON.stringify({"id":narudzbinaDodeljenaId});

        $.ajax({
            type: "POST",
            url: "http://localhost:8081/narudzbine/dostavljenaKorisniku",
            dataType: "json",
            contentType: "application/json",
            data:nar,
            beforeSend: function (xhr) {
                if (localStorage.token) {
                    xhr.setRequestHeader('Authorization', 'Bearer ' + localStorage.token);
                }},
            success: function (data) {
                console.log("SUCCESS : ", data);
                dostavljena.show();
            },
            error: function (data) {
                console.log("ERROR : ", data);
            }
        });



    });


});


