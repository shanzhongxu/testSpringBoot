<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>index.jsp</title>
</head>
<body>
${sb}
<p>This Is Index Page! </p>
今天的日期是: <%= (new java.util.Date()).toLocaleString()%>
</body>
</html>