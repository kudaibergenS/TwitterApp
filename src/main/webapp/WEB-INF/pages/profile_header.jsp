<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div id="profile-block">
    <div id="profile-title" class="left-side">
        <p>Profile</p>
        <a id="search-link" onclick="onSearchBtnClick()"><img src="<c:url value="/resources/images/search.png"/>"></a>
        <form id="search-form" action="${contextPath}/blogs/search" method="get">
            <input id="searchArea" class="textfield" type="text" name="key" placeholder="...">
            <input id="searchBtn" class="submitBtn" type="submit" value="Search">
        </form>
        <script>
            $("#search-form").hide();
            $("#search-link").click(function () {
                $("#search-link").fadeOut(100);
                $("#search-form").fadeIn(100);
            });
        </script>
    </div>
    <div id="profile-menu" class="right-side">
        <div id="profile-name" class="left-side">
            <p>${user.firstname} ${user.lastname}</p>
            <form action="${contextPath}/logout" method="post">
                <input id="log-out-btn" type="submit" value="Log out">
                <input type="hidden" value="logout" name="action"> </form>
        </div>
        <div id="profile-img" class="right-side">
            <img src="<c:url value="/resources/images/profile.png"/>"> </div>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
</div>
