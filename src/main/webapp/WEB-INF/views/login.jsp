<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%--include head--%>
<%@include file="fragments/head.jsp"%>

<body>
<header>
    <%--include nav--%>
    <%@include file="fragments/nav.jsp"%>
</header>

<section class="login-page">
    <h2>Zaloguj się</h2>
    <form method="post">
        <div class="form-group">
            <input type="email" name="email" placeholder="Email" />
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zaloguj się</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <a href="/register" class="btn btn--without-border">Załóż konto</a>
        </div>
    </form>
</section>

<%--include footera --%>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>