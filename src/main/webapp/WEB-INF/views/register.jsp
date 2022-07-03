<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--include head--%>
<%@include file="fragments/head.jsp"%>
<body>
<header>
    <%--include nav--%>
    <%@include file="fragments/nav.jsp"%>
</header>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form  modelAttribute="register">
        <div class="form-group">
            <form:input path="email" type="email" placeholder="Email"/>
            <form:errors path="email"/>
            <form:errors path="email"/>
        </div>
        <div class="form-group">
            <form:input path="password" type="password" placeholder="Hasło"/>
            <form:errors path="password"/>
        </div>
        <div class="form-group">
            <form:input path="password2" type="password" placeholder="Powtórz hasło"/>
            <form:errors path=""/>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Załóż konto</button>
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
        </div>
    </form:form>
</section>

<%--include footera --%>
<jsp:include page="fragments/footer.jsp"/>

</body>
</html>