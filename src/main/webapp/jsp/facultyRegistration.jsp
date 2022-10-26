<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Periodicals</title>
     <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="container">

    <!-- Sidebar -->
    <div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
        <h3 class="w3-bar-item">Menu</h3>
        <a href="/home" class="w3-bar-item w3-button">Home</a>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <a href="/faculty-registration" class="w3-bar-item w3-button">Faculty registration</a>
        </security:authorize>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <a href="/informations" class="w3-bar-item w3-button">Rating</a>
        </security:authorize>
    </div>


    <!-- Page Content -->
    <div style="margin-left: 10%">
        <div class="w3-container w3-teal">
            <h1>Faculty registration</h1>
        </div>
        <div class="w3-container">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />
                </form>
                <h2>
                    Welcome ${pageContext.request.userPrincipal.name} | <a
                        onclick="document.forms['logoutForm'].submit()">Logout</a>
                </h2>
            </c:if>




            <form:form method="POST" action="${contextPath}/FacultyRegister" modelAttribute="faculty" >
                <table>
                    <tr>
                        <td><form:label path="name">Name</form:label></td>
                        <td><form:select path="name">
                            <form:option value="KN-faculty">Комп'ютерні науки</form:option>
                            <form:option value="IST-faculty">Інформаційні системи та технології</form:option>
                            <form:option value="TRE-faculty">Телекомунікації та радіотехніка</form:option>
                        </form:select></td>
                    </tr>
                    <tr>
                        <td><form:label path="gpa">Середній бал для вступу</form:label></td>
                        <td><form:input path="gpa" /></td>
                    </tr>

                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                    </tr>
                </table>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
            </form:form>


        </div>

    </div>


</div>
<!-- /container -->
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<!-- JavaScript Bundle with Popper -->
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>--%>
</body>
</html>