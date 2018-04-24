<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.Customer_Bill" %>
    <%@page import="java.util.*" %>
    <%@page import="java.lang.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
btn {
    padding: 60px 80px;
    border: 2 none;
    font-weight: 1400;
    letter-spacing: 1px;
    text-transform: uppercase;
}

  body{
   background-image:url('black.jpg');
   background-size:cover;
  }
</style>
<link rel="stylesheet" href="menu.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Billing</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Bill</title>
</head>
<body>
<center><h1 style="font-family: 'Monoton', cursive; color:#FFEBCD; font-size:70px;" >INFINITY&nbsp;&nbsp;&nbsp;DTH&nbsp;&nbsp;&nbsp;SERVICES</h1></center>

<div id='cssmenu'>
<ul>
   
   <li><a href="<%=request.getContextPath()%>/PurchaseSBTController?action=Buy"><span>Buy STB for customer</span></a></li>
   <li><a href="<%=request.getContextPath()%>/PurchaseSBTController?action=Generate"><span>Generate Bills(POSTPAID)</span></a></li>
   <li><a href="<%=request.getContextPath()%>/PurchaseSBTController?action=Deduct"><span>Deduct Bills(PREPAID)</span></a></li>
   <li style="float: right;"><a href="<%=request.getContextPath()%>/PurchaseSBTController?action=LogOut"><span style="color:#ff4d4d;">LogOut</span></a></li>
   <li style="float: right;"><a href="#"><span style="color:#66ffb3;">Logged in as: Admin</span></a></li>
</ul>
</div>
<br>
<br>
<br>
<%Customer_Bill b=(Customer_Bill)request.getAttribute("cust"); %>
<form>
<table class="table" style="font-size: 18px; color: white; padding: 15px;width:500px;" align="center" border=1 rules="all">
<tr>
<td colspan="2" align="center"> Welcome Admin </td>
</tr>

<tr>
<td colspan="2" align="center">
View Bill for Post Paid Customer</td>
</tr>

<tr>
<td>
Bill Number</td>
<td>INFCST003BILL00<%=b.getId() %></td>
</tr>

<tr>
<td>
Customer Name</td>
<td><%=b.getCustomerName() %></td>
</tr>

<tr>
<td>
Set Top Box Type</td>
<td>
<%=b.getBox()%></td>
</tr>

<tr>
<td colspan="2">
<table style="font-size: 18px; padding: 15px;width:500px;" align="center" border=1>
<tr><td style="text-align: center;" colspan="2">
Package Details</td></tr>
<tr>
<td>Package Name</td>
<td>Package Cost</td>
</tr>
<%for(Map.Entry<String,Double> hm :b.getPacklist().entrySet())
	{%>
	<tr>
	<td>
	<%=hm.getKey() %>
	</td>
	<td>
	<%=hm.getValue() %>
	</td>
	</tr>
	<%} %>
	</table>
	</td>
	</tr>
	
	<tr>
	<td>
	Other Charges</td>
	<td>0.00</td>
	</tr>
	<%double d=0;%>
	<%for(Map.Entry<String,Double> hm :b.getPacklist().entrySet())
	{%>
	<%Date date=new Date(); %>

<%if(date.getMonth()==b.getDate().getMonth() && date.getYear()==b.getDate().getYear()) {%>
<%d=d+ (( (date.getDay()-b.getDate().getDay())*hm.getValue())/30);}%>
<%} %>
<%double t=d*12/100; %>

	<tr>
	<td>Tax</td>
	<td><%=t %></td>
	</tr>
	
	<tr>
	<td>
	Total Amount</td>
	<td>
	
<%=d+t%>

</td>
</tr>
<tr>
<td>
Bill Generation Date</td>
<td><%Date date=new Date(); %>
<%=date %>
</td>
</tr>

<tr>
<td>
Bill Payment Date</td>
<td>
<%Date today = new Date();    
Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24*15)); %>
<%=tomorrow %>
</td>
</tr>


</table>

</form>


</body>
</html>
