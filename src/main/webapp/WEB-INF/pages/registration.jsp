<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
</head>
<body>
<div id="page-wrapper">
    <div class="container">
        <div id="login-form">
            <p>Create an account</p>
            <form method="post" action="${contextPath}/signup">
                <input class="textfield" type="text" name="firstname" placeholder="Name...">
                <input class="textfield" type="text" name="lastname" placeholder="Surname...">
                <input class="textfield" type="text" name="login" placeholder="Login...">
                <input class="textfield" type="password" name="password" placeholder="Password...">
                <input class="textfield" type="password" name="repeat_password" placeholder="Password again...">
                <input class="submitBtn" type="submit" name="submit" value="Register">
            </form>
            <a id="registration-link" href="<c:url value="/login"/>">Back</a>
        <p style="color: darkred; font-size: 20px; text-align: center;">${error_msg}</p>
        </div>
    </div>
</div>
</body>
</html>
