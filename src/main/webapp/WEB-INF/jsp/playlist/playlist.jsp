<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="en">

    <jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>

    <body class="preload">

    <!-- main body -->
    <div id="main_container">

        <jsp:include page="/WEB-INF/jsp/fragments/navbar.jsp"/>

        <section style="min-height: 820px !important;" class="bottomrow">
            <div style="text-align:center;padding-top:75px;" id="bottomelements">
                <img src="<spring:url value='/resources/images/Playlist/wedding-playlist-title.jpg'/>" alt="wedding-playlist-title" width="129" height="44"/>
            </div>
        </section>

    </div>

    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript">activateNavItem("navPlaylist");</script>

</body>
</html>