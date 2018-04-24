<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>


    <%@ include file="include/header.jsp"%>

</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

            <div class="form-group">
                <form:input type="text" path="firstname" class="form-control" placeholder="Firstname"></form:input>
                <form:errors path="firstname"></form:errors>
            </div>
            <div class="form-group">
                <form:input type="text" path="lastname" class="form-control" placeholder="Lastname"></form:input>
                <form:errors path="lastname"></form:errors>
            </div>
<!--
        <select name="role">
            <option>Select your role</option>
            <option name="role" value="ROLE_TEACHER">Teacher</option>
            <option name="role" value="ROLE_STUDENT">Student</option>
        </select>
-->
            <div class="form-group">
                <form:input type="text" path="group" class="form-control" placeholder="Group" ></form:input>
                <form:errors path="group"></form:errors>
            </div>

            <form:select path="course">
                <option>Select your course</option>
                <option selected="selected">0</option>
                <option name="course" value="1">1</option>
                <option name="course" value="2">2</option>
                <option name="course" value="3">3</option>
                <option name="course" value="4">4</option>
                <option name="course" value="5">5</option>
                <option name="course" value="6">6</option>
            </form:select>


            <div class="form-group">
                <form:input type="text" path="post" class="form-control" placeholder="Post"></form:input>
                <form:errors path="post"></form:errors>
            </div>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="confirmPassword" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="confirmPassword"></form:errors>
            </div>
        </spring:bind>

        <div class="checkbox" id="teacherId">
            <label><input type="radio"  name="role" value="ROLE_TEACHER" >Teacher</label>
        </div>

        <div class="checkbox" id="studentId">
            <label><input type="radio"  name="role" value="ROLE_STUDENT" >Student</label>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<%@ include file="include/footer.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>