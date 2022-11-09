<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<style><%@include file="/WEB-INF/view/css/tables-style.css"%></style>
<html>
<head>
    <title>All Employees</title>
</head>
<body>
<h2>All Employees</h2>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Languages</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="emp" items="${allEmps}">

        <c:url var="updateButton" value="/update-info">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/delete-employee">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department.name}</td>
            <td>${emp.salary}</td>
            <td>${emp.languages}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href='${updateButton}'"/>
                <input type="button" value="Delete"
                       onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add employee"
       onclick="window.location.href='add-new-employee'"/>
<br><br>
<input type="button" value="Languages data"
       onclick="window.location.href='languages-data'"/>

<input type="button" value="Departments data"
       onclick="window.location.href='departments-data'"/>
</body>
</html>
