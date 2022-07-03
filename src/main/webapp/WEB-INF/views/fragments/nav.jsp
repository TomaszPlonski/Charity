<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<nav class="container container--70">
    <ul class="nav--actions">
<sec:authorize access="isAuthenticated()">
        <form action="<c:url value="/logout"/>" method="post">

            <input class="btn btn--small btn--without-border" type="submit" value="<spring:message code="fragments.nav.logout"/>">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
</sec:authorize>
<sec:authorize access="isAnonymous()">
        <li><a href="/login" class="btn btn--small btn--without-border"><spring:message code="fragments.nav.login"/></a></li>
        <li><a href="/register" class="btn btn--small btn--highlighted"><spring:message code="fragments.nav.signIn"/></a></li>
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
        <li><a href="/#contact" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>
