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
                <img src="<spring:url value='/resources/images/rsvp/wedding-RSVP-title.jpg'/>" alt="wedding-RSVP-title" width="129" height="44">

                <div class="formo">
                    <div class="form-header2"><p>Please Let Us Know Your Plans</p></div>
                    <form class="form" method="post" action="http://www.overtongraphics.com/wedding/php/rsvp.php">
                        <div class="heado"></div>
                        <div class="divider"></div>

                        <input class="fname" type="text" name="name" placeholder="  All Names Attending:" required>
                        <div class="divider2"></div>

                        <input type="radio" name="attendance" value="Yes, I am happily attending." checked><span>&nbsp;&nbsp;I am happily attending</span>
                        <input type="radio" name="attendance" value="No, I am sadly not attending."><span>&nbsp;&nbsp;I am sadly not attending</span><br />

                        <select class="choice" name="adults">
                            <option value="0" selected="selected">How Many Adults Attending?</option>
                            <option value="1">How Many Adults Attending? 1</option>
                            <option value="2">How Many Adults Attending? 2</option>
                            <option value="3">How Many Adults Attending? 3</option>
                            <option value="4">How Many Adults Attending? 4</option>
                        </select>
                        <br />

                        <select class="choice2" name="children">
                            <option value="0" selected="selected">How Many Children Attending?</option>
                            <option value="1">How Many Children Attending? 1</option>
                            <option value="2">How Many Children Attending? 2</option>
                            <option value="3">How Many Children Attending? 3</option>
                            <option value="4">How Many Children Attending? 4</option>
                        </select>

                        <div>
                            <input type="checkbox" name="bus" value="Yes, I would like to get the bus." /> <span class="checky">We'd like to get the bus ?</span>
                        </div>

                        <textarea placeholder="Messages" name="message" cols="47" rows="8" required></textarea>

                        <div class="divider"></div>
                        <input type="submit" name="submit" value="SUBMIT" />
                    </form>
                    <div class="form-footer"></div>
                </div>

            </div>
        </section>

    </div>

    <jsp:include page="/WEB-INF/jsp/fragments/scripts.jsp"/>
    <script type="text/javascript">activateNavItem("navRsvp");</script>

</body>
</html>