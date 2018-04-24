<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@page import="bean.Customer_Bill" %>
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Billing</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">windows.history.forward()</script>
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<title>Bill Details</title>
</head>
<body>
<center><h1 style="font-family: 'Monoton', cursive; color:#FFEBCD; font-size:70px;" >INFINITY&nbsp;&nbsp;&nbsp;DTH&nbsp;&nbsp;&nbsp;SERVICES</h1></center>
<br>
<div class=" form-group col-sm-12">
  <div class="col-sm-offset-11"><a href="<%=request.getContextPath()%>/PurchaseSBTController?action=LogOut"><button class="btn btn-danger">LogOut</button></a></div></div>
<br>
<br>
<br>
<br>

<table class="table" style="font-size: 18px; color: white; padding: 15px;width:500px;" align="center" border=1 rules="all">
<tr>
<td>
<h4>Bill Generated as on <%Date d=new Date(); %><%=d %></h4>
</td>
</tr>
<%ArrayList<Customer_Bill> l=(ArrayList<Customer_Bill>)request.getAttribute("bill");%>
<%String str=(String)request.getAttribute("str"); %>
<%=str %>
<%for(Customer_Bill b:l)
	{%>
	<tr><td>
	<a  href="<%=request.getContextPath()%>/PurchaseSBTController?action=detail&id=<%=b.getId() %>">INFCST001BILL00<%=b.getId() %>(<%=b.getCustomerName() %>)</a>
	

</td>
	</tr>
	<%} %>

</table>


</body>
</html>