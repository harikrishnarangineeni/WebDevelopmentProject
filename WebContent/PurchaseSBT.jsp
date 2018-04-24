<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="service.Service" %>   
 <%@ page import="java.util.*" %>
  <%@page import="bean.Customer" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
  body{
   background-image:url('black.jpg');
   background-size:cover;
  }
</style>
 <link rel="stylesheet" href="menu.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">windows.history.forward()</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="color:white;">
<% String g = (String)session.getAttribute("c");
  String name = (String) session.getAttribute("Custname");
%>
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

<form action="<%=request.getContextPath()%>/PurchaseSBTController">
<br>
<br>
<br>


<div class=" form-group col-sm-10">
  <div class="col-sm-offset-6 col-sm-5"><h3></h3></div></div>
  <br>

    <%if(g.equalsIgnoreCase("Admin")||g.equalsIgnoreCase("Operator")){ %> 
<% ArrayList<Customer> n= (ArrayList<Customer>) session.getAttribute("names");%>
   <div class=" form-group col-sm-10">
    <div class="col-sm-offset-5 col-sm-2"><h4>Select Customer</h4></div>
     <div class="col-sm-3"><select  name="a" class="form-control">
    <%for(Customer q : n) {%>
                   <option value="<%=q.getCust_Name()%>"> <%=q.getCust_Name()%>(<%=q.getCustId() %>)</option>
                 <%} %>
         </select></div></div> <% } %>
         
     <%if(g.equalsIgnoreCase("Customer")){ %>
     <div class=" form-group col-sm-10">
      <div class="col-sm-offset-5 col-sm-2"><h4>Customer Name:</h4></div>
      <div class="col-sm-3"><input class="form-control" type="text" name="a" value="<%=name%>" readonly></div></div>
     <% } %>
<%session.getAttribute("stype");
session.getAttribute("ctype");%>
<br>
<br>
<br>
<br>
<br>

<div class=" form-group col-sm-11">
  <div class="col-sm-offset-6 col-sm-3"><input type="submit"  name="action"  value="Submit" class="btn btn-success"></div></div>

</form>
</body>
</html>