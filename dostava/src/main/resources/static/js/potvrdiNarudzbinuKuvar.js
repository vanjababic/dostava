var narudzbinaId = -1;

$(document).ready(function () {
    //$('#tableSadrzajNarudzbine').empty();
    $.ajax({
        type: "GET",
        url: "http://localhost:8081/kuvari/prikaziNarudzbinuZaPotvrdu",
        dataType: "json",
        beforeSend: function(xhr) {
            if (localStorage.token) {
                xhr.setRequestHeader('Authorization', 'Bearer ' + localStorage.token);
            }
        },
        success: function (data) {
            console.log("SUCCESS : ", data);
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['naziv'] + "</td>";
                row += "<td>" + data[i]['kolicina'] + "</td>";
                row += "<td>" + data[i]['cena'] + "</td>";
                narudzbinaId = data[i]['narudzbinaId']

                $('#tableSadrzajNarudzbine').append(row);
            }
        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '#btnPotvrdiKuvar', function () {

    var nar = JSON.stringify({"id":narudzbinaId});

    $.ajax({
        type: "POST",
        url: "http://localhost:8081/kuvari/potvrdiNarudzbinu",
        dataType: "json",
        contentType: "application/json",
        data: nar,
        beforeSend: function (xhr) {
            if (localStorage.token) {
                xhr.setRequestHeader('Authorization', 'Bearer ' + localStorage.token);
            }},
        success: function (data) {
            console.log("SUCCESS : ", data);
        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '#btnOdbijKuvar', function () {

    var nar = JSON.stringify({"id":narudzbinaId});

    $.ajax({
        type: "POST",
        url: "http://localhost:8081/kuvari/odbijNarudzbinu",
        dataType: "json",
        contentType: "application/json",
        data: nar,
        beforeSend: function (xhr) {
            if (localStorage.token) {
                xhr.setRequestHeader('Authorization', 'Bearer ' + localStorage.token);
            }},
        success: function (data) {
            console.log("SUCCESS : ", data);
        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});