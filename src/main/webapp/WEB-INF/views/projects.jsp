<%--
  Created by IntelliJ IDEA.
  User: IliasG
  Date: 25.04.2018
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Projects</title>
</head>
<body>
<%@ include file="include/header.jsp" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-4">
            <sec:authorize access="hasRole('ROLE_TEACHER')">
                <h3>Add Meeting</h3>

                <c:url var="addAction" value="/projects/add"/>

                <form:form action="${addAction}" commandName="projects">
                    <table>
                        <c:if test="${!empty projects.project_name}">
                            <form:label path="id">
                                <spring:message text="id"/>
                            </form:label>
                            <form:input path="id" readonly="true" size="8" disabled="true" class="form-control"/>
                        </c:if>
                        <br>
                        <form:label path="project_name">
                            <spring:message text="Project name"/>
                        </form:label>
                        <form:input path="project_name" class="form-control"/>
                        <br>
                        <input class="btn btn-link" type="submit" value="<spring:message text="Add Project"/>"/>
                    </table>
                </form:form>
            </sec:authorize>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-8">

            <h3>All My Projects</h3>

            <c:if test="${!empty listProjects}">
                <h3>Projects List</h3>
                <table class="table table-bordered">
                    <tr>
                        <th>Project</th>
                    </tr>
                    <c:forEach items="${listProjects}" var="projects">
                        <tr>
                            <td>${projects.project_name}</td>
                            <sec:authorize access="hasRole('ROLE_TEACHER')">
                                <td><a href="<c:url value='/projects/remove/${projects.id}'/>">Delete</a></td>
                            </sec:authorize>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

        </div>
    </div>
</div>


<%@ include file="include/footer.jsp" %>

</body>
</html>
