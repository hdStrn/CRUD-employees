<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<style><%@include file="/WEB-INF/view/css/tables-style.css"%></style>
<html>
<head>
    <title>Languages</title>
</head>
<body>
<h2>Languages</h2>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="lang" items="${languages}">

        <c:url var="deleteButton" value="/delete-language">
            <c:param name="langId" value="${lang.id}"/>
        </c:url>

        <tr>
            <td>${lang.name}</td>
            <td>
                <input type="button" value="Delete"
                       onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add"
       onclick="window.location.href='add-new-language'"/>
<input type="button" value="Back to main page"
       onclick="window.location.href='to-main-page'"/>
</body>
</html>
