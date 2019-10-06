$(document).ready(function () {
    // alert('Person');
    var outUrl = "http://127.0.0.1:8080";
    $("form").on("submit", function (event) {
        var button = $(document.activeElement).attr('id');
        var formData = new FormData(document.getElementsByTagName('form')[0]);
        switch (button) {
            case "add":
                console.log(formData);
                add(outUrl + "/addProduct", formData, button);
                break;
            case "get":
                //alert('hi, my name Denis');
                fillTable();
                //alert('hi, my name Denis3');
                // getFindById(outUrl + "/getAll", formData);
                break;
            case "remove":
                remove(outUrl + "/removeProduct", formData);
                break;
            case "update":
                update(outUrl + "/updatePerson", formData);
                break;
        }
        event.preventDefault();
        console.log($(this).serialize());
    });


    function add(url, formData, button) {
        // alert('hi, my name Denis');
        var id = formData.get('id');
        var product = {
            position: formData.get('position'),
            name: formData.get('name')
        };
        //alert('dfdfdfdfd');
        //alert(product);
        // alert(JSON.stringify(product));
        // $.post( url, product).done(function() {
        //     fillTable();
        //
        // } );
        $.ajax({
            type: 'POST',
            url: url,
            data: JSON.stringify(product),
            contentType: "application/json; charset=utf-8",
            processData: false,
            success: function (data) {
                //alert(data);
                fillTable();
            },
            error: function (data) {
                alert(data);
            }
        });
    }


    function fillTable() {
        $.ajax({
            type: 'GET',
            url: outUrl + '/getAll',
            processData: false,
            success: function (data) {
                $('#names tbody').empty();
                for (var i = 0; i < data.length; i++) {
                    $('#names tbody').append('<tr></td>' + '<td>' + data[i]['position'] + '</td><td>' + data[i]['name'] + '</td><td><button type="submit" id="moveDown_' + i + '"" class="btn btn-primary">Переместить вниз</button>\n' +
                        '        <button type="submit" id="moveUp_' + i + '" class="btn btn-primary" >Переместить вверх</button>\n' +
                        '        <button type="submit" id="remove_' + i + '" class="btn btn-primary">Удалить</button></td></tr>')


                    $("#moveUp_" + i).click(function (event) {
                        console.log(event.target.id);
                        moveUp(event.target.id);
                    });
                    $("#moveDown_" + i).click(function (event) {
                        moveDown(event.target.id);
                        console.log(event.target.id);
                    });
                    $("#remove_" + i).click(function (event) {
                        console.log(event.target.id);
                        remove(event.target.id);
                    });
                }

            },
            error: function (data) {
                alert(data);
            }
        });


        // $.get(outUrl + "/getAll")
        //     .done(function (data) {
        //         $('#names tbody').empty();
        //         //alert('hi, my name Denis4');
        //         for (var i = 0; i < data.length; i++) {
        //             //alert(data[i]['position']);
        //             //var formated_date = new Date(data[i]['birthDate']).toLocaleDateString();
        //             $('#names tbody').append('<tr><td><input type="checkbox" id="blahA" value="1"/></td>' + '<td>' + data[i]['position'] + '</td><td>' + data[i]['name'] + '</td></tr>')
        //             // $('#names tbody').append('<tr><td>' + data[i]['position'] + '</td><td>' + data[i]['name'] + '</td></tr>')
        //         }
        //     })
    }

    // $("#moveUp_0").click(function () {
    //     alert('000000');
    // });
    //
    // $("#moveUp_1").click(function () {
    //     alert('1111111111');
    // });
    function moveDown(index) {
        $.ajax({
            url: outUrl + '/moveDownProduct',
            type: 'POST',
            data: JSON.stringify(index),
            contentType: 'application/json; charset=utf-8',
            async: true,
            success: function (msg) {
                fillTable();
            },
            error: function (data) {
                alert(data);
            }
        });
    }

    function moveUp(index) {
        $.ajax({
            url: outUrl + '/moveUpProduct',
            type: 'POST',
            data: JSON.stringify(index),
            contentType: 'application/json; charset=utf-8',
            async: true,
            success: function (msg) {
                fillTable();
            },
            error: function (data) {
                alert(data);
            }
        });
    }

    function remove(index) {
        $.ajax({
            url: outUrl + '/removeProduct',
            type: 'POST',
            data: JSON.stringify(index),
            contentType: 'application/json; charset=utf-8',
            async: true,
            success: function (msg) {
                fillTable();
            },
            error: function (data) {
                alert(data);
            }
        });
    }


});