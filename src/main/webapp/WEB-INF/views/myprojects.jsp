<%--
  Created by IntelliJ IDEA.
  User: IliasG
  Date: 25.04.2018
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My projects</title>
    <%@ include file="include/header.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-4">
        </div>
        <div class="col-xs-6 col-md-4">

            <h3>Your Projects</h3>

            <table class="table table-bordered">
                <c:forEach items="${projectsList2}" var="projects">
                    <tr>
                        <td>${projects.project_name}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>
        <div class="col-xs-6 col-md-4"></div>
        <%@ include file="include/footer.jsp" %>
    </div>
</div>
</body>
</html>
