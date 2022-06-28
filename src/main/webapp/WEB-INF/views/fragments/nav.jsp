<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="container container--70">
    <ul class="nav--actions">
<sec:authorize access="isAuthenticated()">
        <form action="<c:url value="/logout"/>" method="post">
            <input class="btn btn--small btn--without-border" type="submit" value="Logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
</sec:authorize>
<sec:authorize access="isAnonymous()">
        <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
        <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
</sec:authorize>
    </ul>

    <ul>
        <li><a href="/" class="btn btn--without-border active">Start</a></li>
        <li><a href="/#steps" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="/#about-us" class="btn btn--without-border">O nas</a></li>
        <li><a href="/#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
<sec:authorize access="isAuthenticated()">
        <li><a href="/form" class="btn btn--without-border">Przekaż dary</a></li>
</sec:authorize>
        <li><a href="/#contant" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>
