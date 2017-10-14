<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
 <html lang="en">
 <head>
     <meta charset="UTF-8">
     <title>Document</title>
     <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
 </head>
 <body>
 <div id="page-wrapper">
     <div class="container">
         <div id="login-form">
             <p>Log In</p>
             <form action="${contextPath}/login" method="post">
                 <input class="textfield" type="text" name="login" placeholder="Username...">
                 <input class="textfield" type="password" name="password" placeholder="Password...">
                 <input class="submitBtn" type="submit" name="submit" value="Log in">
             </form>
             <a id="registration-link" href="<c:url value="/signup"/>">Create an account</a>
             <p style="color: darkred; font-size: 20px; text-align: center;">${error_msg}</p>
         </div>
     </div>
 </div>
 </body>
 </html>
