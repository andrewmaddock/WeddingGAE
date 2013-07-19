<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>

<body>

    <jsp:include page="/WEB-INF/jsp/fragments/navbar.jsp"/>
    
    <div class="container">
    
        <h1>RSVP</h1>

        <form:form id="rsvpForm" modelAttribute="rsvp" cssClass="form-horizontal">
            <fieldset>
                <legend>Répondez S'il Vous Plaît</legend>
                <div class="control-group">
                    <form:label for="names" path="names" cssClass="control-label">Name(s):</form:label>
                    <div class="controls">
                        <form:input path="names" cssClass="span4" cssErrorClass="error" placeholder="who's coming?"/>
                        <form:errors path="names" cssClass="error"/>
                    </div>
                </div>

                <div class="control-group">
                    <%--<form:label for="attending" path="attending" cssClass="control-label">RSVP:</form:label>--%>
                    <div class="controls">
                        <form:label for="attending" path="attending" cssClass="radio inline">
                            <form:radiobutton id="attendingTrue"  path="attending" value="true" />
                            Yes I'm Attending
                        </form:label>
                        <form:label for="attending" path="attending" cssClass="radio inline">
                            <form:radiobutton id="attendingFalse"  path="attending" value="false" />
                            No i'm not Attending
                        </form:label>
                        <form:errors path="attending" cssClass="error"/>
                    </div>
                </div>
                
                <div id="attendingGroup">
                    
                    <div class="control-group">
                        <form:label for="adults" path="adults" cssClass="control-label">Adults Attending:</form:label>
                        <div class="controls">
                            <form:select path="adults" cssClass="span1" cssErrorClass="error">
                                <form:option value="1"/> 
                                <form:option value="2"/> 
                                <form:option value="3"/> 
                                <form:option value="4"/> 
                            </form:select>
                            <form:errors path="adults" cssClass="error"/>
                        </div>
                    </div>
    
                    <div class="control-group">
                        <form:label for="children" path="children" cssClass="control-label">Children Attending:</form:label>
                        <div class="controls">
                            <form:select path="children" cssClass="span1" cssErrorClass="error">
                                <form:option value="0"/>
                                <form:option value="1"/>
                                <form:option value="2"/>
                                <form:option value="3"/>
                                <form:option value="4"/>
                            </form:select>
                            <form:errors path="children" cssClass="error"/>
                        </div>
                    </div>
    
                    <div class="control-group">
                        <%--<form:label for="transport" path="transport" cssClass="control-label">Transport:</form:label>--%>
                        <div class="controls">
                            <form:label path="transport" cssClass="checkbox">
                                <form:checkbox path="transport"/>
                                We'd like to get the bus
                            </form:label>
                            <form:errors path="transport" cssClass="error"/>
                        </div>
                    </div>
    
                    <div class="control-group">
                        <form:label for="messages" path="messages" cssClass="control-label">Messages:</form:label>
                        <div class="controls">
                            <form:textarea path="messages" cssClass="span4" cssErrorClass="error" placeholder="Any thing you'd like to tell us?" rows="3"/>
                            <form:errors path="messages" cssClass="error"/>
                        </div>
                    </div>
                
                </div>
                
                <div class="control-group">
                    <div class="controls">
                        <button type="submit" class="btn">Respond</button>
                    </div>
                </div>
            </fieldset>
        </form:form>
    
        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>
    
    </div> <!-- /container -->
    
    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript" src="<spring:url value='/resources/js/rsvp/rsvp.js'/>"></script>

</body>
</html>