
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="">

    <title>Periodicals</title>
    <!-- CSS only -->
    <link href="${contextPath}/resources/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script
            src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function() {
            var selItem = localStorage.getItem("locales");
            $('#locales').val(selItem ? selItem : 'en');
            $("#locales").change(function() {
                var selectedOption = $('#locales').val();
                if (selectedOption) {
                    window.location.replace('?lang=' + selectedOption);
                    localStorage.setItem("locales", selectedOption);
                }
            });
        });
    </script>
</head>
<body>
<div class="container">


    <!-- Sidebar -->
    <div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
        <h3 class="w3-bar-item"> <spring:message code="home.menu" /></h3>

        <a href="/home" class="w3-bar-item w3-button"><spring:message code="home.home" /></a>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <a href="/faculty-registration" class="w3-bar-item w3-button"><spring:message code="home.facultyReg" /></a>
        </security:authorize>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <a href="/informations" class="w3-bar-item w3-button"><spring:message code="home.rating" /></a>
        </security:authorize>
        <fieldset>
            <label><spring:message code="login.choose_language" /></label> <select
                id="locales">
            <option value="en"><spring:message code='login.english'/></option>
            <option value="ua"><spring:message code='login.ukrainian'/></option>

        </select>
        </fieldset>
    </div>


    <div style="margin-left: 10%">

        <div class="w3-container w3-teal">
            <h1></h1>
        </div>

        <div class="w3-container">

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </form>
                <h2>
                    <spring:message code="home.welcome" /> ${pageContext.request.userPrincipal.name} | <a
                        onclick="document.forms['logoutForm'].submit()">Logout</a>
                </h2>
            </c:if>


            <section class="ftco-section">
                <div class="container">
                    <c:if test="${not empty user}">
                        <img src="data:image/jpg;base64, ${user.encodedImage}" alt=""
                             style="width: 150px; height: 150px; background-position-x: center; background-position-y: center;">
                    </c:if>

                    <c:if test="${not empty faculties}">
                        <c:forEach items="${faculties}" var="currentFaculty">
                            <div class="w3-card-4" style="width: 20%; margin: 2%">
                            <tr var="iteration">
                                <th scope="row">${iteration+1}</th>
                                <td>${currentFaculty.name}</td>
                                <td>${currentFaculty.gpa}</td>

                            </tr>
                            <security:authorize access="hasRole('ROLE_ADMIN')">
                                <form:form action="${contextPath}/informationReg" method="POST" enctype="multipart/form-data">
                                    <input type="hidden" value="${currentFaculty.id}"
                                           class="form-control" name="facultyId">
                                    <input type="submit" value="Submit" />
                                </form:form>
                            </security:authorize>
                        </c:forEach>
                        </div>
                    </c:if>

                </div>
            </section>
        </div>

    </div>


</div>
<!-- /container -->
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>
