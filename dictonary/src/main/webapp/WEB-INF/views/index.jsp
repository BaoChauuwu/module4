<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Từ điển Anh – Việt</title>
</head>
<body>
<h2>Tra cứu từ điển Anh – Việt</h2>

<form action="search" method="post">
  Nhập từ tiếng Anh: <input type="text" name="word"/>
  <button type="submit">Tra cứu</button>
</form>

<p style="color:blue">
  ${result}
</p>
</body>
</html>
