<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/view/css/info-style.css"%></style>
<html>
<head>
    <title>Add new employee</title>
</head>
<body>
<h2>Please add employee:</h2>
<br><br>
<form:form action="save-employee" modelAttribute="employee">

    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Department
    <form:select path="department">
        <form:options items="${departments}" itemLabel="name" itemValue="id"/>
    </form:select>
    <br><br>
    Languages
    <form:checkboxes path="languages" items="${languages}" itemValue="id" itemLabel="name" delimiter=" "/>
    <br><br>
    Salary <form:input path="salary"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
