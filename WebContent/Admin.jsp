<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
     .btn {
    padding: 60px 80px;
    border: 2 none;
    font-weight: 1400;
    letter-spacing: 2px;
    text-transform: uppercase;
}
  body{
   background-image:url('black.jpg');
   background-size:cover;
  }
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Montserrat+Subrayada" rel="stylesheet">
<link rel="stylesheet" href="menu.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search</title>
<script type="text/javascript">windows.history.forward()</script>
</head>
<body>
<% String g = (String)session.getAttribute("c");%>
<center><h1 style="font-family: 'Monoton', cursive; color:#FFEBCD; font-size:70px;" >INFINITY&nbsp;&nbsp;&nbsp;DTH&nbsp;&nbsp;&nbsp;SERVICES</h1></center>
<div id='cssmenu'>
<ul>
   <li style="float: right;"><a href="<%=request.getContextPath()%>/PurchaseSBTController?action=LogOut"><span style="color:#ff4d4d;">LogOut</span></a></li>
   <li style="float: right;"><a href="#"><span style="color:#66ffb3;">Logged in as: <%=g %></span></a></li>
</ul>
</div>
<br>
<br>
<br>
<br>


<br>
<br>
<div class=" form-group col-sm-10">
  <div class="col-sm-offset-5 col-sm-5"> 
<a href="<%=request.getContextPath()%>/PurchaseSBTController?action=Buy"><button class="btn btn-primary btn-lg">Buy STB for customer</button></a></div></div>
<br>
<br>
<div class=" form-group col-sm-10">
  <div class="col-sm-offset-5 col-sm-5">
<a href="<%=request.getContextPath()%>/PurchaseSBTController?action=Generate"><button class="btn btn-primary btn-lg">Generate Bills(POSTPAID)</button></a></div></div>
<div class=" form-group col-sm-10">
  <div class="col-sm-offset-5 col-sm-5">
<a href="<%=request.getContextPath()%>/PurchaseSBTController?action=Deduct"><button class="btn btn-primary btn-lg">Deduct Bills(PREPAID)</button></a></div></div>
<% session.getAttribute("c");%>
</body>
</html>