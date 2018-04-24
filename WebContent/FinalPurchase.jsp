<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="bean.FinalPurchase"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

.btn {
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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<link rel="stylesheet" href="menu.css">
<script type="text/javascript">windows.history.forward()</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="StyleSheet" href="NewFile.css">

<title>purchase</title>
	<link rel="stylesheet" href="css/style.css">

</head>
<body>
<%String g=(String) session.getAttribute("c");%>
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
<%session.getAttribute("Inventory");%>
<%session.getAttribute("stype");%>
<%String s = (String)session.getAttribute("ctype");%>
<%session.getAttribute("Custname");%>

<form action="<%=request.getContextPath()%>/PurchaseSBTController" method="post">
<center><h2 style="color:white;">Purchase Set Top Box</h2></center><br>
<center><h3 style="color:white;">All fields are mandatory.Amount is in U.S.dollars</h3></center><br></br>
<center>
<table class="table" style="font-size: 18px; color: white; padding: 15px;width:500px;" align="center" border=1 rules="all">
<%FinalPurchase f = (FinalPurchase)request.getAttribute("final");%>
<tr>
<td>CustomerName:</td>
<td><input class="form-control" type="text" value="<%=f.getName()%>"></td></tr>
<tr>
<td>Set Top Box Type:</td><td><input class="form-control" type="text" value="<%=f.getSBT_type() %>" readonly></td></tr>
<tr>
<td>Set Top Box MAC ID:</td><td><input class="form-control" type="text" value="<%=f.getMac_id() %>" readonly></td></tr>
<tr>
<td>Set Top Box Serial Number: </td><td><input class="form-control" type="text" value="<%=f.getSerial_number() %>" readonly></td></tr>
<tr>
<td>Set Top Box Price: </td><td><input class="form-control" type="text" value="<%=f.getPrice() %>"readonly></td></tr>
<tr>
<td>Installation Charge:</td> <td><input class="form-control" type="text" value="<%=f.getInstallation_charge() %>"readonly></td></tr>
<%if(s.equals("postpaid")){ %>
<tr>
<td>Refundable Deposit Amount: </td><td><input class="form-control" type="text" value="<%=f.getDeposit() %>" readonly></td></tr>
<tr>
<%} %>
<td>Discount: </td><td><input class="form-control" type="text" value="<%=f.getDiscount() %>" readonly></td></tr>
<tr>
<td>Tax: </td><td><input class="form-control" type="text" value="<%=f.getTax() %>" readonly></td></tr>
<tr>
<td>Amount Payable: </td><td><input class="form-control" type="text" value="<%=f.getAmount() %>"></td></tr>
</table></center><br>

<center>
<input  type="submit" class="btn btn-info" name="action" value="purchase"></center>
</form>
</body>
</html>