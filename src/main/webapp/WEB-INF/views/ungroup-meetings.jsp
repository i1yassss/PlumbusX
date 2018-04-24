<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 27.05.2017
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ungroup meetings</title>
</head>
<body>

<%@ include file="include/header.jsp"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-4">

            <c:if test="${!empty ungroupMeetings}">
                <h3>Meetings List</h3>
                <table class="table table-bordered">
                    <tr>
                        <th width="120">Meeting</th>
                        <th width="120">Type</th>
                        <th width="120">Description</th>
                        <th width="120">Date</th>
                        <th width="120">Join Meeting</th>
                    </tr>
                    <c:forEach items="${ungroupMeetings}" var="meetings">
                        <tr>
                            <td>${meetings.mname}</td>
                            <td>${meetings.typeofmeeting}</td>
                            <td>${meetings.description}</td>
                            <td>${meetings.timedate}</td>
                            <c:url var="addAction" value="/ungroup-meetings/${meetings.id}/join"/>

                            <form:form action="${addAction}">
                                <td><input class="btn btn-link" type="submit" value="<spring:message text="Join meeting"/>"/></td>
                            </form:form>

                        </tr>
                    </c:forEach>
                </table>
            </c:if>


        </div>
        <div class="col-xs-6 col-md-4">

        </div>
        <div class="col-xs-6 col-md-4">
        </div>
    </div>
</div>

<%@ include file="include/footer.jsp"%>
</body>
</html>
