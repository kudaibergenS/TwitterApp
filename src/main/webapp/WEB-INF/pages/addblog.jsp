<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Profile</title>
    <meta charset=utf-8>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.0.0.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/script.js"/>"></script>
</head>

<body>
<div id="page-wrapper">
    <div id="content-wrapper" class="container">

        <jsp:include page="profile_header.jsp" />

        <div id="blogs-block">
            <div id="blogs-menu">
                <span class="left-side">
                    <a href="${contextPath}/blogs/add">Add Blog</a>
                </span>
                <span class="right-side">
                    <ul>
                        <li>
                            <a href="${contextPath}/blogs/">All blogs</a>
                        </li>
                        <li>
                            <a href="${contextPath}/blogs/myblogs">My blogs</a>
                        </li>
                    </ul>
                </span>
                <div class="clear"></div>
            </div>
            <div id="blogs">
                <form action="${contextPath}/blogs/add" method="POST">
                    <c:if test="${!empty blog.title}">
                        <input type="hidden" name="id" value="${blog.id}">
                        <input type="text" name="title" class="blog-title-textfield" placeholder="${blog.title}">
                        <textarea name="content" class="blog-content-textfield">${blog.content}</textarea>
                        <input type="submit" value="Edit blog" class="submit-blog-btn">
                    </c:if>
                    <c:if test="${empty blog.title}">
                        <input type="text" name="title" class="blog-title-textfield" placeholder="Title...">
                        <textarea name="content" class="blog-content-textfield" placeholder="Text..."></textarea>
                        <input type="submit" value="Add blog" class="submit-blog-btn">
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
