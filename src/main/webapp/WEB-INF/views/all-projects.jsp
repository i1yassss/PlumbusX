<%--
  Created by IntelliJ IDEA.
  User: IliasG
  Date: 25.04.2018
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Projects</title>
</head>
<body>
<%@ include file="include/header.jsp"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-4"></div>
        <div class="col-xs-6 col-md-4">

            <c:if test="${!empty allProjects}">
                <h3>Meetings List</h3>
                <table class="tg">
                    <tr>
                        <th width="120">Projects</th>
                        <th width="120">join</th>
                    </tr>
                    <c:forEach items="${allProjects}" var="projects">
                        <tr>
                            <td>${projects.project_name}</td>
                            <c:url var="addAction" value="/all-projects/${projects.id}/join"/>

                            <form:form action="${addAction}">
                                <td><input class="btn btn-link" type="submit" value="<spring:message text="Join projects"/>"/></td>
                            </form:form>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

        </div>
        <div class="col-xs-6 col-md-4">


        </div>
    </div>
</div>

<%@ include file="include/footer.jsp"%>
</body>
</html>
