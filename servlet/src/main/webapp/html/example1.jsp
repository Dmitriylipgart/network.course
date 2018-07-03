<%--@elvariable id="keyMap1" type=""--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/jsp" method="get" >
    <p>Map</p>
    <p>Key: <input type="text" name="keyMap" ></p>
    <p>Value: <input type="text" name="valueMap" ></p>
    <p>List</p>
    <p>Key: <input type="text" name="valueList" ></p>
    <input type="submit" value="Set data">


    ${keyMap1}
    ${test}
    ${test.keyMap}
    ${test.valueMap}
    ${test.valueList}
</form>

</body>
</html>