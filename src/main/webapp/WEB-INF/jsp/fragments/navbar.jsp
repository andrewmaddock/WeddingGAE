<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="brand" href="<spring:url value='/'/>">The Maddock Marriage</a>
                <div class="nav-collapse collapse">
                    <ul class="nav">
                        <li id="home"><a href="<spring:url value='/'/>"><i class="icon-home icon-white"></i> Home</a></li>
                        <li id="story"><a href="<spring:url value='/story'/>"><i class="icon-heart icon-white"></i> Our Story</a></li>
                        <li id="info" class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-info-sign icon-white"></i> Info<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li id="details"><a href="<spring:url value='/info/details'/>"><i class="icon-time"></i> Details</a></li>
                                <li id="venues"><a href="<spring:url value='/info/venues'/>"><i class="icon-glass"></i> Venues</a></li>
                                <li id="transport"><a href="<spring:url value='/info/transport'/>"><i class="icon-road"></i> Transport</a></li>
                                <li id="accommodation"><a href="<spring:url value='/info/accommodation'/>"><i class="icon-briefcase"></i> Accommodation</a></li>
                            </ul>
                        </li>
                        <li id="rsvp"><a href="<spring:url value='/rsvp'/>"><i class="icon-envelope icon-white"></i> RSVP</a></li>
                        <li id="giftlist"><a href="<spring:url value='/giftlist'/>"><i class="icon-gift icon-white"></i> Gift List</a></li>
                        <li id="playlist"><a href="<spring:url value='/playlist'/>"><i class="icon-music icon-white"></i> Play List</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>
    </div>