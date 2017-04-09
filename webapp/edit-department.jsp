<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mihail
  Date: 03.04.17
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit department</title>
</head>
<body>
<c:out value="${message}"/>
<form action="edit-department/<c:out value="${department.id}"/>" method="post">
  <input type="text" value="<c:out value="${department.name}"/>" name="name">
  <input type="hidden" value="<c:out value="${department.id}"/>" name="id">
  <input type="submit" value="Edit">
</form>
<a href="/">Back to main page</a>

</body>
</html>
