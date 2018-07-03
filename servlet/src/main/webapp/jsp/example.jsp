<%--@elvariable id="keyMap1" type=""--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/servlet/jsp" method="get" >
    <p>Map</p>
    <p>Key: <input type="text" name="keyMap" ></p>
    <p>Value: <input type="text" name="valueMap" ></p>
    <p>List</p>
    <p>Key: <input type="text" name="valueList" ></p>
    <input type="submit" value="Set data">

</form>

${keyMap1}
${test}
${test.keyMap}
${test.valueMap}
${test.valueList}


<h3>Create</h3>
<p>Загрузите файл в таблицу</p>

<form action="uploadFile" method="post" enctype="multipart/form-data">
    <input type="text" name="description">
    <input type="file" name="file">
    <input type="submit" name="button" value="Upload">
</form>
<h3>Read</h3>
<p>Скачайте файл (с определенным id) или все файлы из таблицы</p>

<form action="downloadFile" method="post" enctype="multipart/form-data">
    <input type="text" name="id">
    <select name="downloadType" required>
        <option value="id">id</option>
        <option value="all">all</option>
    </select>
    <input type="submit" name="button" value="Download">
</form>

<h3>Update</h3>
<p>Измените файл и описание с определенным id</p>
<form action="update" method="post" enctype="multipart/form-data" name="update">
    <input type="text" name="id" size="3">
    <input type="text" name="description">
    <input type="file" name="file">
    <input type="submit" name="button" value="Update">
</form>

</body>
</html>