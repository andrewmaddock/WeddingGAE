<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="en">

<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>

<body>

    <jsp:include page="/WEB-INF/jsp/fragments/navbar.jsp"/>
    
    <div class="container">
    
        <h1>Transport</h1>
    
        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>
    
    </div> <!-- /container -->
    
    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript">activateNavItem("info");</script>
    <script type="text/javascript">activateNavItem("transport");</script>

</body>
</html>
