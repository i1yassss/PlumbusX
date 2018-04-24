<%@ include file="include/header.jsp" %>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.w3.org/1999/xhtml">
<head>
    <title>CDIO Project</title>
    <meta charset="UTF-8">

</head>
<body>
<%@ include file="include/header.jsp"%>
<h3> Main page</h3>

<sec:authorize access="hasRole('ROLE_TEACHER')">
    <h3>Teacher see it</h3>

</sec:authorize>

<sec:authorize access="hasRole('ROLE_STUDENT')">
    <h3>student see it</h3>

</sec:authorize>

<%@ include file="include/footer.jsp"%>
</body>

</html>
