<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mihail
  Date: 04.04.17
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New employ</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<h2>Create employ</h2>
<br>
<c:if test="${not empty message}">
  <div class="alert alert-danger">
      ${message}
  </div>
</c:if>
<br>
<br>
<form action="/create-employ/${param.idDepartment}" method="post">
  Name:<input type="text" value="${employ.name}" name="name"><br>
  E-mail:<input type="text" value="${employ.email}" name="email"><br>
  Number:<input type="text" value="${employ.number}" name="number"><br>
  Date:<input type="text" value="${employ.date}" name="date"><br>
  <input type="submit" value="Create">
</form>
<br>
<c:if test="${not empty freeEmploys}">
  Or select free employs:
  <form action="/add-free-employ/${param.idDepartment}">
  <c:forEach items="${freeEmploys}" var="employ">
    ${employ.name} ${employ.number} <button name="id" value="${employ.id}">Add</button>
  </c:forEach>
  </form>
</c:if>
<a href="/">Back to main page</a>
</body>
</html>
