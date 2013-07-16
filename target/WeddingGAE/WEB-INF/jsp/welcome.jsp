<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="en">

<jsp:include page="fragments/header.jsp"/>

<body>

    <jsp:include page="fragments/navbar.jsp"/>
    
    <div class="container">
    
        <!-- Use the save the date image until the invitation is completed -->
        <ul class="thumbnails">
            <li class="span12">
                <div class="thumbnail">
                    <img src="<spring:url value="/resources/images/save-the-date.jpg"/>" alt="save the date" />
                </div>
            </li>
        </ul>
    
        <!-- Example row of columns -->
        <div class="row">
            <div class="span4">
                <h2>The Ceremony</h2>
                <p>Nestled between the Privy and Pond Gardens, overlooking the river Thames, Hampton Court Palace's <a href="http://www.hrp.org.uk/Hireavenue/venuesandsuppliers/HamptonCourtPalace/venues/thebanquetinghouse">Little Banqueting House</a> will be the home to our wedding ceremony.</p>
                <p><a class="btn" href="#">View details &raquo;</a></p>
            </div>
            <div class="span4">
                <h2>The Transport</h2>
                <p>Transport from Hampton Court to the Richmond Gate Hotel will be on a classic London <a href="http://routemaster.org.uk/pages/history">Routemaster</a> bus. A few glasses of bubbly will be served to keep you as refreshed as possible for the evening ahead.</p>
                <p><a class="btn" href="#">View details &raquo;</a></p>
            </div>
            <div class="span4">
                <h2>The Celebration</h2>
                <p>The evening reception will take place in the Conservatory of the 18th century <a href="http://www.akkeronhotels.com/Hotels/Southern-England/The-Richmond-Gate-Hotel">Richmond Gate Hotel</a> which sits at the top of Richmond Hill overlooking the Thames river.</p>
                <p><a class="btn" href="#">View details &raquo;</a></p>
            </div>
        </div>

        <jsp:include page="fragments/footer.jsp"/>
    
    </div> <!-- /container -->

    <jsp:include page="fragments/scripts.jsp"/>
    <script type="text/javascript">activateNavItem("home");</script>

</body>
</html>
