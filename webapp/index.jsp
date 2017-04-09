<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mihail
  Date: 01.04.17
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Departments:</h2>
<br>
<table class="table table-striped">
    <tbody>
<c:forEach items="${departments}" var="department">
<tr>
  <form>
      <td>${department.name}</td>
      <td>
      <button formaction="/edit-department/${department.id}">Edit name</button>
      <button formaction="/department/${department.id}/>">View</button>
      <button formaction="/delete-department/${department.id}">Delete</button>
      </td>
  </form>
    </tr>
</c:forEach>
    </tbody>
</table>
<form>
    <button class="btn-success" formaction="create-department.jsp">Create department</button>
</form>
</body>
</html>
