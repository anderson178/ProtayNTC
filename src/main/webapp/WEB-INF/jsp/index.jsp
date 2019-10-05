<!DOCTYPE HTML>
<html>
<head>
    <%@ page contentType="text/html;charset=utf-8" %>
    <%--<meta charset="UTF-8">--%>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <%--<script src="js/my.js"></script>--%>
    <script type="text/javascript">
        <%@include file="/WEB-INF/js/my.js"%>
    </script>
</head>
<body>
<div class="container">
    <h2>Bordered Table</h2>
    <p>The .table-bordered class adds borders on all sides of the table and the cells:</p>
    <table class="table table-bordered" id="names">
        <thead>
        <tr>
            <th>Позиция</th>
            <th>Название</th>
        </tr>
        </thead>
        <tbody>
        <tr>
        </tr>
        </tbody>
    </table>

    <form id="formPerson">
        <div class="form-group">
            <label for="id">Позиция</label>
            <input type="number" class="form-control" id="id" name="id">
            <label for="firstName">Название</label>
            <input type="text" class="form-control" id="firstName" pattern="[а-яА-ЯёЁ]+" title="Можно использовать только кириллицу" name="firstName">
        </div>
        <button type="submit" id="add" class="btn btn-primary">Добавить</button>
        <button type="submit" id="get" class="btn btn-primary">Получить</button>
        <button type="submit" id="remove" class="btn btn-primary">Удалить</button>
    </form>

</div>
</body>

</html>