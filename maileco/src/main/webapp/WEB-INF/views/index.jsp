<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mail Settings</title>
</head>
<body>
    <h1>Settings</h1>
    
    <c:if test="${not empty success}">
        <div>${success}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div>${error}</div>
    </c:if>
    
    <form:form action="/save" method="post" modelAttribute="mail">
        Language:
        <form:select path="language">
            <form:option value="English">English</form:option>
            <form:option value="VietNamese">Vietnamese</form:option>
            <form:option value="Japanese">Japanese</form:option>
            <form:option value="Chinese">Chinese</form:option>
        </form:select>
        <br>
        
        Page Size:
        Show 
        <form:select path="size">
            <form:option value="5">5</form:option>
            <form:option value="10">10</form:option>
            <form:option value="15">15</form:option>
            <form:option value="25">25</form:option>
            <form:option value="50">50</form:option>
            <form:option value="100">100</form:option>
        </form:select>
        emails per page
        <br>

        Spam Filter:
        <form:radiobutton path="trash" value="1"/> Enable spam filter
        <form:radiobutton path="trash" value="0"/> Disable spam filter
        <br>
        
        Signature:
        <form:input path="signature"/>
        <br>
        
        <form:button>Update</form:button>
        <form:button type="button" onclick="window.location.href='/'">Cancel</form:button>
    </form:form>
</body>
</html>