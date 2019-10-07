$(document).ready(function () {
    var outUrl = "http://127.0.0.1:8080";

    $("#add").click(function (event) {
        var formData = new FormData(document.getElementsByTagName('form')[0]);
        var product = {
            position: formData.get('position'),
            name: formData.get('name')
        };
        $.ajax({
            type: 'POST',
            url: outUrl + '/addProduct',
            data: JSON.stringify(product),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                fillTable();
            },
            error: function (data) {
                alert(data);
            }
        });
        event.preventDefault();
    });

    $("#sort").click(function (event) {
        $.ajax({
            type: 'POST',
            url: outUrl + '/sortProduct',
            success: function (data) {
                fillTable();
            },
            error: function (data) {
                alert(data);
            }
        });
        event.preventDefault();
    });

    function fillTable() {
        $.ajax({
            type: 'GET',
            url: outUrl + '/getAll',
            success: function (data) {
                $('#names tbody').empty();
                for (var i = 0; i < data.length; i++) {
                    $('#names tbody').append('<tr></td>' + '<td>' + data[i]['position'] + '</td><td>' + data[i]['name'] + '</td><td><button type="submit" id="moveDown_' + i + '"" class="btn btn-primary">Переместить вниз</button>\n' +
                        '        <button type="submit" id="moveUp_' + i + '" class="btn btn-primary" >Переместить вверх</button>\n' +
                        '        <button type="submit" id="remove_' + i + '" class="btn btn-primary">Удалить</button></td></tr>');
                    $("#moveUp_" + i).click(function (event) {
                        var tr = this.parentNode.parentNode;
                        var position = tr.getElementsByTagName("td")[0].innerHTML;
                        var name = tr.getElementsByTagName("td")[1].innerHTML;
                        moveUp(position, name);
                    });
                    $("#moveDown_" + i).click(function (event) {
                        var tr = this.parentNode.parentNode;
                        var position = tr.getElementsByTagName("td")[0].innerHTML;
                        var name = tr.getElementsByTagName("td")[1].innerHTML;
                        moveDown(position, name);
                    });
                    $("#remove_" + i).click(function (event) {
                        var tr = this.parentNode.parentNode;
                        var position = tr.getElementsByTagName("td")[0].innerHTML;
                        var name = tr.getElementsByTagName("td")[1].innerHTML;
                        remove(position, name);
                    });
                }

            },
            error: function (data) {
                alert(data);
            }
        });

    }

    function moveDown(position, name) {
        var product = {
            position: position,
            name: name
        };
        $.ajax({
            url: outUrl + '/moveDownProduct',
            type: 'POST',
            data: JSON.stringify(product),
            contentType: 'application/json; charset=utf-8',
            success: function (msg) {
                fillTable();
            },
            error: function (data) {
                alert(data);
            }
        });
    }

    function moveUp(position, name) {
        var product = {
            position: position,
            name: name
        };
        $.ajax({
            url: outUrl + '/moveUpProduct',
            type: 'POST',
            data: JSON.stringify(product),
            contentType: 'application/json; charset=utf-8',
            success: function (msg) {
                fillTable();
            },
            error: function (data) {
                alert(data);
            }
        });
    }

    function remove(position, name) {
        var product = {
            position: position,
            name: name
        };

        $.ajax({
            url: outUrl + '/removeProduct',
            type: 'POST',
            data: JSON.stringify(product),
            contentType: 'application/json; charset=utf-8',
            success: function (msg) {
                fillTable();
            },
            error: function (data) {
                alert(data);
            }
        });
    }


});