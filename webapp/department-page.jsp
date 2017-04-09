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
</head>
<body>
<c:out value="${department.name}"/>
<br>
<c:if test="${empty employs}">
    ${department.name} have n't employs.
</c:if>
<br>

<c:forEach items="${employs}" var="employ">
    <form>
            ${employ.name}
        <button formaction="/edit-employ/${employ.id}">Edit</button>
        <button name="idEmploy" value="${employ.id}" formaction="/department/<c:out value="${department.id}"/>">View
        </button>
        <button formaction="/delete-employ/${employ.id}" name="action" value="1">Delete from department</button>
        <button formaction="/delete-employ/${employ.id}" name="action" value="2">Delete</button>
    </form>
    <c:if test="${viewEmploy eq employ.id}">
        ${employ.name} ${employ.email} ${employ.number} ${employ.date}
    </c:if>
</c:forEach>
<form>
    <button formaction="/create-employ/${department.id}">Create employ</button>

</form>
<a href="/">Back to main page</a>
</body>
</html>
