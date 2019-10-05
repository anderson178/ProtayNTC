$(document).ready(function () {
    // alert('Person');
    var outUrl = "http://127.0.0.1:8080";
    $("form").on("submit", function (event) {
        var button = $(document.activeElement).attr('id');
        var formData = new FormData(document.getElementsByTagName('form')[0]);
        switch (button) {
            case "add":
                console.log(formData);
                add(outUrl + "/addPerson", formData, button);
                break;
            case "get":
                //alert('hi, my name Denis');
                fillTable();
                alert('hi, my name Denis3');
                // getFindById(outUrl + "/getAll", formData);
                break;
            case "remove":
                remove(outUrl + "/removePerson", formData);
                break;
            case "update":
                update(outUrl + "/updatePerson", formData);
                break;
        }
        event.preventDefault();
        console.log($(this).serialize());
    });

    function add(url, formData, button) {
        var id = formData.get('id');
        var person = {
            id: id,
            firstName: formData.get('position'),
            lastName: formData.get(name)
        };
        $.ajax({
            type: 'POST',
            url: url,
            data: JSON.stringify(person),
            contentType: "application/json; charset=utf-8",
            processData: false,
            success: function (data) {
                fillTable();
            },
            error: function (data) {
                alert(data);
            }
        });
    }


    function fillTable() {
        //alert('hi, my name Denis2');
        $.get(outUrl + "/getAll")
            .done(function (data) {
                $('#names tbody').empty();
                //alert('hi, my name Denis4');
                for (var i = 0; i < data.length; i++) {
                    //alert(data[i]['position']);
                    //var formated_date = new Date(data[i]['birthDate']).toLocaleDateString();
                    $('#names tbody').append('<tr><td>' + data[i]['position'] + '</td><td>' + data[i]['name'] + '</td></tr>')
                }
            })
    }


});