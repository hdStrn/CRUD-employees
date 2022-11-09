<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/view/css/info-style.css"%></style>
<html>
<head>
    <title>Add new department</title>
</head>
<body>
<h2>Please add department:</h2>
<br><br>
<form:form action="save-department" modelAttribute="department">

    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
