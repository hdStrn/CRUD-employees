<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<style><%@include file="/WEB-INF/view/css/tables-style.css"%></style>
<html>
<head>
    <title>Departments</title>
</head>
<body>
<h2>Departments</h2>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="dept" items="${departments}">

        <c:url var="deleteButton" value="/delete-department">
            <c:param name="deptId" value="${dept.id}"/>
        </c:url>

        <tr>
            <td>${dept.name}</td>
            <td>
                <input type="button" value="Delete"
                       onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add"
       onclick="window.location.href='add-new-department'"/>
<input type="button" value="Back to main page"
       onclick="window.location.href='to-main-page'"/>
</body>
</html>
