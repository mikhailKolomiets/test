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
</head>
<body>
<% String name = "", massage = "";
if(request.getAttribute("name")!=null)
  name = request.getAttribute("name").toString();
  if(request.getAttribute("dangerMessage")!=null)
    massage = request.getAttribute("dangerMessage").toString();%>
<%= massage %>
<form action="/create-department" method="post">
  <input type="text" value="<%= name %>" name="departmentName"><br>
  <input type="submit" value="new">
</form>
<a href="/">Back to main page</a>
</body>
</html>
