<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Caculator</h1>
<form action="/caculate" method="post">
    <input type="text" name="param1">
    <input type="text" name="param2">
    <button type="submit" name="button" value="Addition"> Addition(+)</button>
    <button type="submit" name="button" value="Subtraction"> Subtraction(-)</button>
    <button type="submit" name="button" value="Multiplication"> Multiplication(x)</button>
    <button type="submit" name="button" value="Division"> Division(/)</button>
</form>
${mess}
<h1>Result: ${result}</h1>
</body>
</html>