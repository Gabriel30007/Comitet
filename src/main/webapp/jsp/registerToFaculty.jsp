<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
    <h3 class="w3-bar-item">Menu</h3>
    <a href="/home" class="w3-bar-item w3-button">Home</a>

    <security:authorize access="hasRole('ROLE_ADMIN')">
        <a href="/faculty-registration" class="w3-bar-item w3-button">Faculty registration</a>
    </security:authorize>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <a href="/informations" class="w3-bar-item w3-button">Rating</a>
    </security:authorize>

    <form:form method="POST" action="${contextPath}/InformationRegister" enctype="multipart/form-data" modelAttribute="info" >
        <table>

            <p>${facultyId}</p>
            <tr>
                <td><form:label path="mathScore">Бал з математики</form:label></td>
                <td><form:input path="mathScore"/></td>
            </tr>
            <tr>
                <td><form:label path="historyScore">Бал з історії України</form:label></td>
                <td><form:input path="historyScore"/></td>
            </tr>
            <tr>
                <td><form:label path="englishScore">Бал з Англійської мови</form:label></td>
                <td><form:input path="englishScore"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form:form>
</div>
</body>
</html>
