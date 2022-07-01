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
    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>
        <form:form  modelAttribute="form">
            <!-- STEP 5 -->
            <div data-step="5" class="active">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text"
                                ><c:out value="${form.quantity} worków darów"/></span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text"
                                >Dla ${form.institution.name}</span
                                >
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li><c:out value="${form.street}"/></li>
                                <li><c:out value="${form.city}"/></li>
                                <li><c:out value="${form.zipCode}"/></li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li>${form.pickUpDate}</li>
                                <li>${form.pickUpTime}</li>
                                <li>
                                    <c:choose>
                                        <c:when test="${empty form.pickUpComment}">
                                            Brak uwag
                                        </c:when>
                                        <c:otherwise>
                                       <c:out value="${form.pickUpComment}"/>
                                        </c:otherwise>
                                    </c:choose>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <form:button name="form5Back" class="btn next-step">Wstecz</form:button>
                    <form:button name="form5Submit" class="btn next-step">Potwierdź</form:button>
                </div>
            </div>
        </form:form>
    </div>
</section>

<%--include footera --%>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>