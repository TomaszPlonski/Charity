<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%--include head--%>
<%@include file="fragments/head.jsp"%>
<body>
<header class="header--form-page">

    <%--include nav--%>
    <%@include file="fragments/nav.jsp"%>

    <div class="slogan container container--90">
        <h2>
            Udało się założyć nowe konto. Możesz się zalogować.
        </h2>
    </div>
</header>


<%--include footera --%>
<jsp:include page="fragments/footer.jsp"/>

</body>
</html>