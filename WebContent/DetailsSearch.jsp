<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.Setup" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

function send() {
	

    var types = document.getElementsByName("type");
    if (types[0].checked == false && types[1].checked == false ) {
    	alert("please select a charging type");
    	return false;
    }
    var e = document.getElementById("select");
    var str = e.options[e.selectedIndex].value;
    if(str=="null")
    {
    alert("Please select a set top box type");
    return false;
    }
}
</script>
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
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">windows.history.forward()</script>
<title>Details Search</title>
</head>
<body>
<%String g = (String)session.getAttribute("c"); %>
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
<form action="<%=request.getContextPath()%>/PurchaseSBTController" method="post">
<%Setup s = (Setup)request.getAttribute("setup"); 
String stype=(String)session.getAttribute("stype");
String ctype=(String)session.getAttribute("ctype");
session.getAttribute("id");%>
<% session.getAttribute("c");%>


<center><h2 style="color:white;">Purchase Set Top Box</h2></center><br>
<center><h3 style="color:white;">All fields are mandatory.Amount is in U.S. dollars.</h3></center><br></br>

<center>
<table width="400" height="80" style="font-size: 18px; color: white">
<tr><td><b>Charging Type</b></td>
<td><%if(ctype.equalsIgnoreCase("prepaid")){ %><input type="radio" name="type" value="prepaid" checked> <i>Prepaid</i>
   <input type="radio" name="type" value="postpaid"> <i>Postpaid</i><%} %>
   <% if(ctype.equalsIgnoreCase("postpaid")) { %><input type="radio" name="type" value="prepaid"> <i>Prepaid</i>
   <input type="radio" name="type" value="postpaid" checked> <i>Postpaid</i><%} %>
   </td></tr>            
<tr style="padding-top: 200px;"><td><b>Set Top Box Type</b></td>
            <td><select name="set" id="select" class="form-control">
                        <option value="<%=stype%>"><%=stype%></option>
                        <option value="Standard">standard</option>
                        <option value="HD">HD</option>
                        <option value="HD+">HD+</option>
                        <option value="IPTV">IPTV</option>
                    
</select></td>
</tr>
</table>
</center>
<div class=" form-group col-sm-12">
  <div class="col-sm-offset-5 col-sm-1"><input type="submit"  name="action" value="SEARCH" class="btn btn-success" onclick="return send()"></div>
  <div class="col-sm-1"><input type="reset" class="btn btn-danger" value="RESET"></div>
</div>

<center>
<table class="table" style="font-size: 18px; color: white; padding: 15px;width:500px;" align="center" border=1 rules="all" >
<tr><td colspan="2"><center><b>Set Top box details <%=stype %></b></center></td></tr>
<tr>
<td style="padding:20px,10px;"><b>Setup box features:</b></td><td><i><%=s.getFeatures() %></i></td></tr>
<tr><td><b>Dimensions in inches:</b></td>
<td><b>Height:</b> <i><%=s.getHeight() %></i><br>
<b>Width:</b> <i><%=s.getWidth() %></i><br>
<b>Length:</b> <i><%=s.getLength() %></i></td></tr>
<tr>
<td><b>Price:</b></td><td><i><%=s.getPrice() %></i></td></tr>
<tr><td><b>InstallationCharge:</b></td><td><i><%=s.getInstallation_Charge() %></i></td></tr>
<%if(stype.equals("HD") || stype.equals("HD+") || stype.equals("IPTV")){ %>
<tr><td><b>UpgradationCharge:</b></td>
<td><i><%=s.getUpgradtion_Charge() %></i></td></tr>
<tr>
<%} %>
<td><b>Discount%:</b></td><td><i><%=s.getDiscount() %></i></td></tr>
<tr><td><b>Billing type:</b></td>
<td><i><%=s.getBilling_Type() %></i></td></tr>
<% if(ctype.equals("postpaid")){%>
<tr><td>
<b> Refundable deposit Amount:</b></td>
<td><i><%=s.getRefundable_Deposit_Amount() %></i></td></tr>
<% } %>
</table>
</center>
<br>
<div class=" form-group col-sm-10">
  <div class="col-sm-offset-7 col-sm-"><input type="submit" name="action" value="PURCHASE" class="btn btn-info"></div></div>

</form>
</body>
</html>