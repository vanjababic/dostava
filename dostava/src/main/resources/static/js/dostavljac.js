//var narudzbinaId = -1;

$(document).ready(function () {

    var dajPonudu = $(".dajPonudu");
    dajPonudu.show();
    var unesiPonudu = $(".unesiPonudu");
    unesiPonudu.hide();

    $.ajax({
        type: "GET",
        url: "http://localhost:8081/dostavljaci/prikaziNarudzbineZaPonudu",
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
                row += "<td>" + data[i]['adresaKupca'] + "</td>";
                row += "<td>" + data[i]['adresaObjekta'] + "</td>";

                var btn = "<button class='btnDajPonuduDostavljac' id = " + data[i]['ponudaId'] + ">Daj ponudu</button>";


                row += "<td>" + btn + "</td>";

                $('#tablePodaciNarudzbine').append(row);
            }
        },
        error: function (data) {
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.btnDajPonuduDostavljac', function () {

    var narudzbinaId = this.id;

    var dajPonudu = $(".dajPonudu");
    dajPonudu.hide();
    var unesiPonudu = $(".unesiPonudu");
    unesiPonudu.show();

    $(document).on('click', '#btnDajPonudu', function () {
        var vreme = $("#chVreme").val();
        var myJSON = formToJSON(narudzbinaId, vreme);

        $.ajax({
            type: "POST",
            url: "http://localhost:8081/ponude/sacuvajPonudu",
            dataType: "json",
            contentType: "application/json",
            data: myJSON,
            beforeSend: function (xhr) {
                if (localStorage.token) {
                    xhr.setRequestHeader('Authorization', 'Bearer ' + localStorage.token);
                }
            },
            success: function (data) {
                console.log("SUCCESS : ", data);
                window.location.href = "dostavljac.html";
            },
            error: function (data) {
                console.log("ERROR : ", data);
            }
        });
    });

    $(document).on('click', '#btnCancle', function () {

        var dajPonudu = $(".dajPonudu");
        dajPonudu.show();
        var unesiPonudu = $(".unesiPonudu");
        unesiPonudu.hide();

    });
});

function formToJSON(narudzbinaId, vreme) {
    return JSON.stringify(
        {
            "narudzbinaId" : narudzbinaId,
            "vreme" : vreme
        }
    );
}
