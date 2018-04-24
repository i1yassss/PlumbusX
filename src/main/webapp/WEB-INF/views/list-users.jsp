
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <%@ include file="include/header.jsp" %>
</head>
<body>
<h3> Main page</h3>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-4"></div>
        <div class="col-xs-6 col-md-4">
            <sec:authorize access="hasRole('ROLE_TEACHER')">
                <h3>Teacher see it</h3>
                <c:forEach items="${listStudents}" var="users">
                    <table class="table table-bordered">
                        <tr>
                            <td><a href="<c:url value='/profile/${users.id}'/>">${users.username}</a></td>
                        </tr>
                    </table>
                </c:forEach>
            </sec:authorize>

            <sec:authorize access="hasRole('ROLE_STUDENT')">
                <h3>student see it</h3>
                <c:forEach items="${listTeachers}" var="users">
                    <table class="table table-bordered">
                        <tr>
                            <td><a href="<c:url value='/profile/${users.id}'/>">${users.username}</a></td>

                        </tr>

                    </table>

                </c:forEach>
            </sec:authorize>
        </div>
        <div class="col-xs-6 col-md-4"></div>
    </div>
</div>


<%@ include file="include/footer.jsp" %>
</body>
</html>
