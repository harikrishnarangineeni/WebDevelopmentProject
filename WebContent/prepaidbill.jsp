<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="bean.Customer_Bill" %>
    <%@page import="bean.Dateprepaid" %>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Deduct bal</title>
<script>
function deduct() {
	var x=document.getElementById("msg");
	x.style.display="block";
	return true;
}
</script>
<body>
<center><h1 style="font-family: 'Monoton', cursive; color:#FFEBCD; font-size:70px;" >INFINITY&nbsp;&nbsp;&nbsp;DTH&nbsp;&nbsp;&nbsp;SERVICES</h1></center>
<br>
<div class=" form-group col-sm-12">
  <div class="col-sm-offset-11"><a href="<%=request.getContextPath()%>/PurchaseSBTController?action=LogOut"><button class="btn btn-danger">LogOut</button></a></div></div>
<br>
<br>
<br>
<br>
<form>
<h4><p id="msg" style="display:none;"><%=request.getAttribute("ad") %></p></h4>
<table class="table" style="font-size: 18px; color: white; padding: 15px;width:500px;" align="center" border=1 rules="all">
<tr>
<td colspan="3" align="center">
Welcome Admin 
</td>
</tr>
<tr>
<td colspan="3" align="center">
Deduct Daily Balance for Pre-Paid Customers</td>
</tr>
<tr>
<td colspan="3" align="center">

</td>
</tr>
<tr>
<td>CustomerID</td>
<td>Current Balance</td>
<td>Deducted Balance</td>
</tr>
<%ArrayList<Customer_Bill> ll=(ArrayList<Customer_Bill>)request.getAttribute("prelist");
		
	String f = (String)request.getAttribute("msg");	
		
		%>
	<% if(f!=null)	{%>
	<%=f %>
	
	<%ArrayList<Dateprepaid> l2=(ArrayList<Dateprepaid>)request.getAttribute("prelist1");%>
	  <%for(Dateprepaid b:l2)
	{%>
<tr>
<td>
CST<%=b.getId() %></td>
<td><%=Math.ceil(b.getCurrentbalance()) %></td>
<td><%=Math.ceil(b.getDeductbalance()) %></td>
</tr>
<%} %>


	  
	
	<%} %>
	<%if(f==null) { %>
<%for(Customer_Bill b:ll)
	{%>
<tr>
<td>
CST<%=b.getId() %></td>
<td><%=Math.ceil(b.getCurrentBalance()) %></td>
<td><%=Math.ceil(b.getDeductedBalance()) %></td>
</tr>
<%} %>

<%} %>

</table>


</form>
</body>
</html>