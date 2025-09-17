<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1> Sandwich Condiments</h1>
<form action="/sandwich" method="post">
    <input type="checkbox" name="condiment" value="lettuce"> Lettuce
    <input type="checkbox" name="condiment" value="tomato"> Tomato
    <input type="checkbox" name="condiment" value="mustard"> Mustard
    <input type="checkbox" name="condiment" value="sprouts" Sprouts>
    <br>
    <button type="submit"> Save</button>
</form>

<h1>All the condiments we have</h1>
<c:forEach var="c" items="${condiment}">
    <p>${c}</p>
</c:forEach>
</body>
</html>