<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 29.05.2017
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My meetings</title>
    <%@ include file="include/header.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-4">
        </div>
        <div class="col-xs-6 col-md-4">

            <h3>Your Meetings</h3>

            <table class="table table-bordered">
            <c:forEach items="${meetingsList2}" var="meetings">
                <tr>
                    <td>${meetings.mname}</td>
                    <td>${meetings.typeofmeeting}</td>
                    <td>${meetings.description}</td>
                    <td>${meetings.timedate}</td>
                </tr>
            </c:forEach>
            </table>

        </div>
        <div class="col-xs-6 col-md-4"></div>
        <%@ include file="include/footer.jsp" %>
</body>
</html>
