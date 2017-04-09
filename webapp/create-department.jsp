<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mihail
  Date: 02.04.17
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New department</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Input name from new department:</h2>

<c:if test="${not empty dangerMessage}">
  <div class="alert alert-danger">${dangerMessage}</div>
</c:if>
<form action="/create-department" method="post">
  <input type="text" value="${name}" name="departmentName"><br>
  <input type="submit" value="new">
</form>
<a href="/">Back to main page</a>
</body>
</html>
