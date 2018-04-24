<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <%@ include file="include/header.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-4">
            <h2>Profile ${user.username}</h2>

            <sec:authorize access="hasRole('ROLE_TEACHER')">

                <c:if test="${!empty user.username}">
                    <br>
                    <p> ${user.firstname}</p><br>
                    <p>${user.lastname}</p><br>
                    <p>${user.course} Курс</p><br>
                </c:if>

                <c:if test="${!empty user.competences}">
                    <table class="table table-bordered">
                        <tr>
                            <th>Competences</th>
                        </tr>
                        <c:forEach items="${user.competences}" var="competence">
                            <tr>
                                <td>${competence.skill}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </sec:authorize>


            <sec:authorize access="hasRole('ROLE_STUDENT')">
                <c:if test="${!empty user.username}">
                    <table class="table table-bordered">
                        <tr>
                            <th>User information</th>
                        </tr>
                        <tr>
                            <td>${user.firstname}</td>
                        </tr>
                        <tr>
                            <td>${user.lastname}</td>
                        </tr>
                        <tr>
                            <td>Должность ${user.post} </td>
                        </tr>
                    </table>
                </c:if>
                <c:if test="${!empty user.competences}">
                    <table class="table table-bordered">
                        <tr>
                            <th>Competences</th>
                        </tr>
                        <c:forEach items="${user.competences}" var="competence">
                            <tr>
                                <td>${competence.skill}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </sec:authorize>


        </div>
        <div class="col-xs-12 col-sm-6 col-md-8">
            <c:if test="${!empty meetingsList1}">
                <h3>Meetings List</h3>
                <table class="tg">
                    <tr>
                        <th width="120">Meeting</th>
                        <th width="120">Type</th>
                        <th width="120">Description</th>
                        <th width="120">Date</th>
                    </tr>
                    <c:forEach items="${meetingsList1}" var="meetings">
                        <tr>
                            <td>${meetings.mname}</td>
                            <td>${meetings.typeofmeeting}</td>
                            <td>${meetings.description}</td>
                            <td>${meetings.timedate}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

        </div>
    </div>
</div>


<%@ include file="include/footer.jsp" %>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</html>
