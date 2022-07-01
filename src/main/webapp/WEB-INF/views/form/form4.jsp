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
            <p data-step="4" class="active">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>
        <form:form  modelAttribute="form">
            <!-- STEP 4 -->
            <div data-step="4" class="active">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica 
                                <form:input path="street"/>
                                <form:errors path="street"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Miasto
                                <form:input path="city"/>
                                <form:errors path="city"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>Kod Pocztowy
                                <form:input path="zipCode"/>
                                <form:errors path="zipCode"/>
                            </label>
                        </div>

                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>

                        <div class="form-group form-group--inline">
                            <label> Data
                                <form:input type="date" path="pickUpDate" />
                                <form:errors path="pickUpDate"/>
                            </label>
                        </div>
                        <div class="form-group form-group--inline">
                            <label> Godzina
                                <form:input type="time" path="pickUpTime" />
                                <form:errors path="pickUpTime"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                <form:textarea path="pickUpComment"/>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <form:button name="form4Back" class="btn next-step">Wstecz</form:button>
                    <form:button name="form4Submit" class="btn next-step">Dalej</form:button>
                </div>
            </div>

        </form:form>
    </div>
</section>

<%--include footera --%>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>