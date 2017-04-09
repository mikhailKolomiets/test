<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mihail
  Date: 08.04.17
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit ${employ.name}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<h2>Edit ${employ.name}</h2>
<c:if test="${not empty message}">
    <div class="alert alert-danger">
            ${message}
    </div>
</c:if>
<br>
<c:if test="${empty inputData}">
    <form action="/edit-employ/${employ.id}" method="post">
        <input type="text" value="${employ.name}" name="name"><br>
        <input type="text" value="${employ.email}" name="email"><br>
        <input type="text" value="${employ.number}" name="number"><br>
        <input type="text" value="<fmt:formatDate value="${employ.date}" pattern="dd-MM-yyyy"/>" name="date"><br>
        <input type="submit" value="Edit">
    </form>
</c:if>
<c:if test="${not empty message}">
    <form action="/edit-employ/${employ.id}" method="post">
        <input type="text" value="${inputData.name}" name="name"><br>
        <input type="text" value="${inputData.email}" name="email"><br>
        <input type="text" value="${inputData.number}" name="number"><br>
        <input type="text" value="${inputData.date}" name="date"><br>
        <input type="submit" value="Edit">
    </form>
</c:if>
<br>
<a href="/department/${employ.idDepartment}">Back to ${employ.name} department</a>

</body>
</html>
