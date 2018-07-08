<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
</head>

<body>
<header>
    <h1>Файловый менеджер</h1>
</header>

<div class="wrapper">
    <c:set var="dbSize" scope="session" value="${size}"/>

    <c:if test="${dbSize == 0}">
        <h2>База данных пуста. Загрузите файл.</h2>
    </c:if>
    <form action="uploadFile" method="post" enctype="multipart/form-data" class="login-form">

        <div class="content">
            <input type="text" name="description" class="input username" placeholder="Описание файла">
            <input type="file" name="file" style="display: none" id="fileUploadButton">
            <label for="fileUploadButton" class="button">Выбрать</label>
            <input type="submit" class="button" value="Загрузить">
        </div>

    </form>
</div>



<c:set var="dbSize" scope="session" value="${size}"/>

<table>
    <tr>
        <th>Имя файла</th>
        <th>Описание</th>
        <th>Скачать</th>
        <th>Удалить</th>
    </tr>

    <c:forEach var="record" items="${records}">
        <tr>
            <td><a href="${record.getPathForPage()}">${record.fileName}</a></td>
            <td>${record.description}</td>
            <td><a href="${record.getPathForPage()}" download><i class="fas fa-arrow-alt-circle-down"></i></a></td>
            <td>
                <form action="delete" method="post" enctype="multipart/form-data">
                    <input type="text" name="file_id"  value="${record.file_id}" style="display: none">
                    <input type="text" name="fileName"  value="${record.fileName}" style="display: none">
                    <input type="submit" id="deleteButton + ${record.file_id}" style="display: none">
                    <label for="deleteButton + ${record.file_id}"><i class="fas fa-times-circle"></i></label>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>




</body>
</html>
