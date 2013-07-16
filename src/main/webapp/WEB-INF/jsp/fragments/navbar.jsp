<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="brand" href="#">The Maddock Marriage</a>
                <div class="nav-collapse collapse">
                    <ul class="nav">
                        <li id="home"><a href="<spring:url value='/'/>"><i class="icon-home icon-white"></i> Home</a></li>
                        <li id="venue"><a href="<spring:url value='/venue'/>"><i class="icon-road icon-white"></i> Venues</a></li>
                        <li id="rsvp"><a href="<spring:url value='/rsvp'/>"><i class="icon-envelope icon-white"></i> RSVP</a></li>
                        <li id="giftlist"><a href="<spring:url value='/giftlist'/>"><i class="icon-gift icon-white"></i> Gift List</a></li>
                        <li id="playlist"><a href="<spring:url value='/playlist'/>"><i class="icon-music icon-white"></i> Play List</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>
    </div>