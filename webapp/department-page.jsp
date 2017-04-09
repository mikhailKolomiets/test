<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mihail
  Date: 03.04.17
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${department.name} list employs</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h2>${department.name}</h2>
<br>
<c:if test="${empty employs}">
    <div class="alert alert-warning">
    <strong>${department.name}</strong> have n't employs.
        </div>
</c:if>
<br>
<table class="table table-striped">
    <tbody>
    <c:forEach items="${employs}" var="employ">
        <tr>
            <form>
                <td class="col-md-3">${employ.name}</td>
                <td class="col-md-6">
                    <button formaction="/edit-employ/${employ.id}">Edit</button>
                    <button name="idEmploy" value="${employ.id}"
                            formaction="/department/<c:out value="${department.id}"/>">View
                    </button>
                    <button formaction="/delete-employ/${employ.id}" name="action" value="1">Delete from department
                    </button>
                    <button formaction="/delete-employ/${employ.id}" name="action" value="2">Delete</button>
                </td>
                <td class="col-md-3"></td>
            </form>
        </tr>
        <c:if test="${viewEmploy eq employ.id}">
            <tr><td>number: ${employ.number}</td><td>email: ${employ.email}</td><td>
                 date: ${employ.date}</td></tr></tr>
        </c:if>

    </c:forEach>
    </tbody>
</table>
<form>
    <button class="btn-success" formaction="/create-employ/${department.id}">Create employ</button>

</form>
<a href="/">Back to main page</a>
</body>
</html>
