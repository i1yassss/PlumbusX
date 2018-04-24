<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 27.05.2017
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All meetings</title>
</head>
<body>
<%@ include file="include/header.jsp"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-4"></div>
        <div class="col-xs-6 col-md-4">

            <c:if test="${!empty allMeetings}">
                <h3>Meetings List</h3>
                <table class="tg">
                    <tr>
                        <th width="120">Meeting</th>
                        <th width="120">Type</th>
                        <th width="120">Description</th>
                        <th width="120">Date</th>
                    </tr>
                    <c:forEach items="${allMeetings}" var="meetings">
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
        <div class="col-xs-6 col-md-4">


        </div>
    </div>
</div>

<%@ include file="include/footer.jsp"%>
</body>
</html>
