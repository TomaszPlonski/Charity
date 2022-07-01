<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--include head--%>
<%@include file="../fragments/head.jsp"%>

<body>
<header class="header--form-page">

    <%--include nav--%>
    <%@include file="../fragments/nav.jsp"%>

        <%--include slogan--%>
        <%@include file="../fragments/form-slogan.jsp"%>

</header>

<section class="form--steps" id="step">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>
        <form:form  modelAttribute="form">
            <!-- STEP 1: -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>
                <c:forEach items="${form.availableCategories}" var="category">
                <div class="form-group form-group--checkbox">
                    <label>
                        <form:checkbox path="categories" value="${category}"/>
                        <span class="checkbox"></span>
                        <span class="description">${category.name}</span>
                    </label>
                </div>
                </c:forEach>
                <form:errors path="categories"/>

                <div class="form-group form-group--buttons">
                    <form:button name="form1Submit" class="btn next-step">Dalej</form:button>
                </div>
            </div>

        </form:form>
    </div>
</section>

<%--include footera --%>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>