
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jstl</title>
</head>
<body>
    ${myVar}

<c:forEach var="num" items="${myVar}">
    <p>
            ${num.keyMap}
            ${num.valueMap}
            ${num.valueList}
    </p>
</c:forEach>
</body>
</html>
