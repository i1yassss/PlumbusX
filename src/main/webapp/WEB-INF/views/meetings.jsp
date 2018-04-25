<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 23.05.2017
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All meetings</title>
    <%@ include file="include/header.jsp" %>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-4">
            <sec:authorize access="hasRole('ROLE_TEACHER')">
                <h3>Add Meeting</h3>

                <c:url var="addAction" value="/meetings/add"/>

                <form:form action="${addAction}" commandName="meetings">
                    <table>
                        <c:if test="${!empty meetings.mname}">
                            <form:label path="id">
                                <spring:message text="id"/>
                            </form:label>
                            <form:input path="id" readonly="true" size="8" disabled="true" class="form-control"/>
                        </c:if>
                        <br>
                        <form:label path="mname">
                            <spring:message text="Event name"/>
                        </form:label>
                        <form:input path="mname" class="form-control"/>
                        <br>

                        <form:select path="typeofmeeting" class="form-control">
                            <option>Select type of meeting</option>
                            <option name="course" value="Lecture">lecture</option>
                            <option name="course" value="Event">event</option>
                            <option name="course" value="Course">course</option>
                            <option name="course" value="Practice">practice</option>
                        </form:select>
                        <br>
                        <form:label path="description">
                            <spring:message text="Description"/>
                        </form:label>
                        <form:input path="description" class="form-control"/>
                        <br>
                        <form:label path="timedate">
                            <spring:message text="Event Date"/>
                        </form:label>
                        <form path="timedate">
                            <input type="datetime-local" step="1"/>
                        </form>
                        <br>
                        <input class="btn btn-link" type="submit" value="<spring:message text="Add meeting"/>"/>
                    </table>
                </form:form>
            </sec:authorize>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-8">

            <h3>All My Meetings</h3>
            <c:if test="${!empty listMeetings}">
                <h3>Meetings List</h3>
                <table class="table table-bordered">
                    <tr>
                        <th>Meeting</th>
                        <th>Type</th>
                        <th>Description</th>
                        <th>Date</th>
                        <th>Delete Meeting</th>
                    </tr>
                    <c:forEach items="${listMeetings}" var="meetings">
                        <tr>
                            <td>${meetings.mname}</td>
                            <td>${meetings.typeofmeeting}</td>
                            <td>${meetings.description}</td>
                            <td>${meetings.timedate}</td>
                            <sec:authorize access="hasRole('ROLE_TEACHER')">
                            <td><a href="<c:url value='/meetings/remove/${meetings.id}'/>">Delete</a></td>
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
