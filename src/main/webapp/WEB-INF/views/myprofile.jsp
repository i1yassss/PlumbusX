<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyProfile</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <%@ include file="include/header.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row">

        <div class="col-xs-6 col-md-4">
            <sec:authorize access="hasRole('ROLE_STUDENT')">
                <table class="table table-bordered">
                    <tr>
                        <th>User information</th>
                    </tr>
                    <tr>
                        <td>${user_info.firstname}</td>
                    </tr>
                    <tr>
                        <td>${user_info.lastname}</td>
                    </tr>
                    <tr>
                        <td>${user_info.course} Курс</td>
                    </tr>
                    <tr>
                        <td>Группа ${user_info.group}</td>
                    </tr>
                    <tr>
                        <td><p><a href="<c:url value='/mymeetings/${user_info.id}'/>">Мои Встречи </a><p></td>
                    </tr>
                    <tr>
                        <td><p><a href="<c:url value='/myprojects/${user_info.id}'/>">Мои Проекты </a><p></td>
                    </tr>
                </table>
            </sec:authorize>

            <sec:authorize access="hasRole('ROLE_TEACHER')">
                <h3>Teacher page</h3>
                <table class="table table-bordered">
                    <tr>
                        <th>Teacher information</th>
                    </tr>
                    <tr>
                        <td>${user_info.firstname}</td>
                    </tr>
                    <tr>
                        <td>${user_info.lastname}</td>
                    </tr>
                    <tr>
                        <td>${user_info.post} </td>
                    </tr>
                </table>
            </sec:authorize>

        </div>
        <div class="col-xs-6 col-md-4">
            <sec:authorize access="hasRole('ROLE_STUDENT')">
                <h2>Your profile ${pageContext.request.userPrincipal.name}</h2>
                <h3>Competence List</h3>

                <c:if test="${!empty listCompetence}">
                    <table class="table table-bordered">
                        <tr>
                            <th>Competences</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach items="${listCompetence}" var="competence">
                            <tr>
                                <td>${competence.skill}</td>
                                <td><a href="<c:url value='/remove/${competence.id}'/>">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <h3>Add Competences</h3>

                <c:url var="addAction" value="/myprofile/add"/>

                <form:form action="${addAction}" commandName="competence">
                    <table class="table table-bordered">
                        <c:if test="${!empty competence.skill}">
                            <tr>
                                <td>
                                    <form:label path="id">
                                        <spring:message text="ID"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                                </td>
                            </tr>
                        </c:if>
                        <tr>
                            <td>
                                <form:label path="skill">
                                    <spring:message text="Skill"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="skill"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <c:if test="${empty competence.skill}">
                                    <input type="submit"
                                           value="<spring:message text="Add competence"/>"/>
                                </c:if>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </sec:authorize>
        </div>
        <div class="col-xs-6 col-md-4">

        </div>
    </div>
</div>

<%@ include file="include/footer.jsp" %>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</html>
