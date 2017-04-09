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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Select new name to ${department.name}</h2>
<c:if test="${not empty message}">
<div class="alert alert-danger">
  ${message}
</div>
</c:if>
<c:out value="${message}"/>
<form action="edit-department/<c:out value="${department.id}"/>" method="post">
  <input type="text" value="<c:out value="${department.name}"/>" name="name">
  <input type="hidden" value="<c:out value="${department.id}"/>" name="id">
  <input type="submit" value="Edit">
</form>
<a href="/">Back to main page</a>

</body>
</html>
