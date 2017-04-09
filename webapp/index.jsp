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
</head>
<body>
Departments:
<br>
<c:forEach items="${departments}" var="department">
  <form>
      <c:out value = "${department.name}"/>
      <button formaction="/edit-department/<c:out value="${department.id}"/>">Edit name</button>
      <button formaction="/department/<c:out value="${department.id}"/>">View</button>
      <button formaction="/delete-department/${department.id}">Delete</button>
  </form>
</c:forEach>
<form>
    <button formaction="create-department.jsp">Create department</button>
</form>
</body>
</html>
