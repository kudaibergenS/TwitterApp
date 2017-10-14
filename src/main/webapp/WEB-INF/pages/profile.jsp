<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.0.0.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/script.js"/>"></script>
</head>
<body>
<div id="page-wrapper">
    <div class="container">

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
            <div id="blogs" class="blogs">
                <c:forEach items="${blogs}" var="blog">
                    <div class="single-blog">
                        <div class="blog-header">
                            <span class="left-side">
                                <p class="title">${blog.title}</p>
                            </span>
                            <span class="right-side">
                                <p class="author">${blog.user.login}</p>
                                <p class="data">${dateFormat.format(blog.post_date)}</p>
                            </span>
                            <div class="clear"></div>
                        </div>
                        <div class="blog-content">${blog.content}</div>
                        <div class="blog-footer">
                            <span class="right-side">
                                <c:if test="${blog.user.id == user.id}" >
                                    <a id="edit-btn" href="<c:url value="/blogs/edit/${blog.id}"/>">Edit</a>
                                    <a  href="<c:url value="/blogs/remove/${blog.id}"/>">Delete</a>
                                </c:if>
                            </span>
                            <div class="clear"></div>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>

    </div>
</div>
</body>
</html>
