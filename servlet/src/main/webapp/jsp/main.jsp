<%--
  Created by IntelliJ IDEA.
  User: МитькаКатька
  Date: 06.07.2018
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<c:forEach var="num" items="${myVar}">
    <p>
            ${num.keyMap}
            ${num.valueMap}
            ${num.valueList}
    </p>
</c:forEach>
</body>
</html>
