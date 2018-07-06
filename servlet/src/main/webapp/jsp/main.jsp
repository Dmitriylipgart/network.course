<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>

<%--<c:set var="size" scope="session" value="${size}"/>--%>



<form action="uploadFile" method="post" enctype="multipart/form-data">
    <p>Описание файла</p>
    <input type="text" name="description">
    <input type="file" name="file">
    <input type="submit" name="button" value="Upload">
</form>

<p>${uploadFileResp}</p>

<c:set var="dbSize" scope="session" value="${size}"/>

<c:if test="${dbSize == 0}">
    <h2>База данных пуста. Загрузите файл.</h2>
</c:if>

    <c:forEach var="record" items="${records}">



        <p>${record.file_id}</p>
        <p>${record.file.getPath()}</p>
        <p>${record.description}</p>
        <p>${record.fileName}</p>






    </c:forEach>


</body>
</html>
