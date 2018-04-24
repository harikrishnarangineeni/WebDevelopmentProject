<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<script type="text/javascript">windows.history.forward()</script>
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<br>
<br>
<form action="<%=request.getContextPath() %>/PurchaseSBTController" method="post">
<table class="table" style="font-size: 18px; color: white; padding: 15px;width:500px;" align="center" border=1 rules="all">


<tr><td style="text-align: center;">
Generate Bill for Post Paid Customers
</td>
</tr>

<tr>
<td style="text-align: center;">
<input type="submit" name="action" value="BillGenerate" class="btn btn-info">
</td>
</tr>


</table>

</form>

</body>
</html>