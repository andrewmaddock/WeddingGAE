<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- JavaScript
================================================== -->
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/jquery-ui.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>
<script type="text/javascript" src="<spring:url value='/resources/js/wedding.js'/>"></script>

<script type="text/javascript">
    setTimeout(function () {
        $("body").removeClass("preload").addClass('done');
    }, 800);
</script>
