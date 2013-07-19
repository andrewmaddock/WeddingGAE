<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>

<body>

    <jsp:include page="/WEB-INF/jsp/fragments/navbar.jsp"/>

    <div class="container">
    
        <h1>Play List</h1>
        
        <form:form id="playlistForm" modelAttribute="playlist" cssClass="form-horizontal">
            <fieldset>
                <legend>Add a playlist entry for our DJ</legend>
                <div class="control-group">
                    <form:label for="requester" path="requester" cssClass="control-label">Requester:</form:label>
                    <div class="controls">
                        <form:input path="requester" cssErrorClass="error" placeholder="Requester"/>
                        <form:errors path="requester" cssClass="error"/>
                    </div>
                 </div>
    
                <div class="control-group">     
                    <form:label for="artist" path="artist" cssClass="control-label">Artist:</form:label>
                    <div class="controls">
                        <form:input path="artist" cssErrorClass="error" placeholder="Artist"/>
                        <form:errors path="artist" cssClass="error"/>
                    </div>
                </div>
    
                <div class="control-group">
                    <form:label for="track" path="track" cssClass="control-label">Track:</form:label>
                    <div class="controls">
                        <form:input path="track" cssErrorClass="error" placeholder="Track"/>
                        <form:errors path="track" cssClass="error"/>
                    </div>    
                </div>
    
                <div class="control-group">
                    <form:label for="why" path="why" cssClass="control-label">Why:</form:label>
                    <div class="controls">
                        <form:textarea path="why" cssErrorClass="error" placeholder="Why" rows="3"/>
                        <form:errors path="why" cssClass="error"/>
                    </div>    
                </div>
    
                <div class="control-group">
                    <div class="controls">
                        <button type="submit" class="btn">Submit</button>
                    </div>    
                </div>
            </fieldset>
        </form:form>
    
        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>
    
    </div> <!-- /container -->
    
    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript" src="<spring:url value='/resources/js/playlist/playlist.js'/>"></script>

</body>
</html>