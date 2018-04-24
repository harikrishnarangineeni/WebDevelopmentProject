<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
  body{
   background-image:url('black.jpg');
   background-size:cover;
  }
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="color:white;">

<center><h1 style="font-family: 'Monoton', cursive; color:#FFEBCD; font-size:70px;" >INFINITY&nbsp;&nbsp;&nbsp;DTH&nbsp;&nbsp;&nbsp;SERVICES</h1></center>

<form action="<%=request.getContextPath()%>/PurchaseSBTController">
<br>
<br>
<br>
<% String g = (String)session.getAttribute("c");%>
<p align="center" style="color:#ffff80; font-size:20px;">Welcome  <%=g %></p>
<div class=" form-group col-sm-10">
  <div class="col-sm-offset-6 col-sm-5"><h3>Validate customer</h3></div></div>
  <br>
<div class=" form-group col-sm-10">
  <div class="col-sm-offset-5 col-sm-2"><h4>Customer Name:</h4></div>
<div class="col-sm-3">  
<input class="form-control" type="text" name="cust"></div></div>
<%session.getAttribute("stype");%>
<div class=" form-group col-sm-10">
  <div class="col-sm-offset-6 col-sm-4"><input type="submit"  name="action"  value="VerifyCustomer" class="btn btn-success"></div></div>
<%String s = (String)request.getAttribute("pop2");%>
<div class=" form-group col-sm-10">
  <div class="col-sm-offset-5 col-sm-4"><p align="center" style="color:red; font-size:20px;"><%=s%></p></div></div>
</form>
</body>
</html>