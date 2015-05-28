<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<c:url value="/j_spring_security_logout" var="logoutUrl" />
<center>




  <h2>User | You are now logged in</h2>
  <h3><a href="${logoutUrl}">Logout</a></h3>
</center>
</body>
</html>
