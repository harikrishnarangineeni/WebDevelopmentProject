<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Montserrat+Subrayada" rel="stylesheet">
<link rel="stylesheet" href="menu.css">
<style>
  body{
   background-image:url('black.jpg');
   background-size:cover;
  }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NoSBT</title>
</head>
<body>
<%String g = (String)session.getAttribute("c") ;%>
<center><h1 style="font-family: 'Monoton', cursive; color:#FFEBCD; font-size:70px;" >INFINITY&nbsp;&nbsp;&nbsp;DTH&nbsp;&nbsp;&nbsp;SERVICES</h1></center>
<div id='cssmenu'>
<ul>
   
   <li><a href="<%=request.getContextPath()%>/PurchaseSBTController?action=Buy"><span>Buy STB for customer</span></a></li>
   <li><a href="<%=request.getContextPath()%>/PurchaseSBTController?action=Generate"><span>Generate Bills(POSTPAID)</span></a></li>
   <li><a href="<%=request.getContextPath()%>/PurchaseSBTController?action=Deduct"><span>Deduct Bills(PREPAID)</span></a></li>
   <li style="float: right;"><a href="<%=request.getContextPath()%>/PurchaseSBTController?action=LogOut"><span style="color:#ff4d4d;">LogOut</span></a></li>
   <li style="float: right;"><a href="#"><span style="color:#66ffb3;">Logged in as: <%=g %></span></a></li>
</ul>
</div>
<br>
<br>
<br>
<p align="center" style="color:#ff704d; font-size:20px;">Desired setup box not present with your Retailer</p>
</body>
</html>