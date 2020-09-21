<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Welcome</title>
<%--       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/> --%>
   </head>
   <body>
      <h1>Welcome</h1>
      <h2>${message}</h2>
       
     
         
       <a href="${pageContext.request.contextPath}/personList">Person List</a>
       
   </body>
   
</html>