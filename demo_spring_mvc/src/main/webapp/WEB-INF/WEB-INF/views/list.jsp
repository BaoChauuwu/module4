
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>Danh sách sinh viên</h1>
<table>
  <tr>
    <th>STT</th>
    <th>Id</th>
    <th>Name</th>
  </tr>
  <c:forEach items="${students}" var="student" varStatus="status">
    <tr>
      <td>${status.count}</td>
      <td>${student.id}</td>
      <td>${student.name}</td>
    </tr>

  </c:forEach>

</table>
</body>
</html>