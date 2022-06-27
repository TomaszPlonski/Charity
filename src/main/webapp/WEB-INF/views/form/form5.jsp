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

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Oddaj rzeczy, których już nie chcesz<br />
                <span class="uppercase">potrzebującym</span>
            </h1>

            <div class="slogan--steps">
                <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
                <ul class="slogan--steps-boxes">
                    <li>
                        <div><em>1</em><span>Wybierz rzeczy</span></div>
                    </li>
                    <li>
                        <div><em>2</em><span>Spakuj je w worki</span></div>
                    </li>
                    <li>
                        <div><em>3</em><span>Wybierz fundację</span></div>
                    </li>
                    <li>
                        <div><em>4</em><span>Zamów kuriera</span></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
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
                                >${form.quantity} worków darów</span>
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
                                <li>${form.street}</li>
                                <li>${form.city}</li>
                                <li>${form.zipCode}</li>
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
                                            ${form.pickUpComment}
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