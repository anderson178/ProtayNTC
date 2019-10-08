$(document).ready(function () {
    /**
     * адрес узла на котором запускается приложение
     * @type {string}
     */
    var outUrl = "http://127.0.0.1:8080";

    /**
     * обработка события кнопки add
     */
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
            success: function () {
                fillTable();
            },
            error: function (data) {
                alert(data);
                // alert('Недопустимое значение номера позиии, введите число не больше 2147483647');
            }
        });
        event.preventDefault();
    });

    /**
     * обработка события кнопки sort
     */
    $("#sort").click(function (event) {
        $.ajax({
            type: 'POST',
            url: outUrl + '/sortProduct',
            success: function () {
                fillTable();
            },
            error: function (data) {
                alert(data);
            }
        });
        event.preventDefault();
    });

    /**
     * метод заполняет таблицу данными запрошенным из бэкенда добавляя для каждой позиции кнопки перемещения и удаления
     */
    function fillTable() {
        $.ajax({
            type: 'GET',
            url: outUrl + '/getAll',
            success: function (data) {
                $('#names tbody').empty();
                for (var i = 0; i < data.length; i++) {
                    $('#names tbody').append('<tr></td>' + '<td>' + data[i]['position'] + '</td><td>' + data[i]['name']
                        + '</td><td><button type="submit" id="moveDown_' + i + '" class="btn btn-primary">Переместить вниз</button>\n'
                        + '<button type="submit" id="moveUp_' + i + '" class="btn btn-primary" >Переместить вверх</button>\n'
                        + '<button type="submit" id="remove_' + i + '" class="btn btn-primary">Удалить</button></td></tr>');
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

    /**
     * Метод перемещения позиции вниз
     * @param position - ячейка с номером позиции
     * @param name - ячейка с названием позиции
     */
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
            success: function () {
                fillTable();
            },
            error: function (data) {
                alert(data);
            }
        });
    }

    /**
     * Метод перемещения позиции вверх
     * @param position - ячейка с номером позиции
     * @param name - ячейка с названием позиции
     */
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
            success: function () {
                fillTable();
            },
            error: function (data) {
                alert(data);
            }
        });
    }

    /**
     * Метод удаления позиции
     * @param position - ячейка с номером позиции
     * @param name - ячейка с названием позиции
     */
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
            success: function () {
                fillTable();
            },
            error: function (data) {
                alert(data);
            }
        });
    }
});