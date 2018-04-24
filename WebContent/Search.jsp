<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

  body{
   background-image:url('black.jpg');
   background-size:cover;
   color:white;
  }
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript">windows.history.forward()</script>
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="menu.css">
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body style="color:white;">

<form action="<%=request.getContextPath()%>/PurchaseSBTController" method="post">
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
<center><h2>Purchase Set Top Box</h2></center><br>
<center><h3>All fields are mandatory.Amount is in U.S. dollars.</h3></center><br></br>


<center>
<table width="400" height="80" style="font-size: 18px; color: white">
<tr><td><b>Charging Type</b></td>
<td><input type="radio" name="type" value="prepaid"> <i>Prepaid</i>
<input type="radio" name="type" value="postpaid"> <i>Postpaid</i></td></tr>            
<tr style="padding-top: 200px;"><td><b>Set Top Box Type</b></td>
            <td><select name="set" id="select" class="form-control" required>
                        <option value="null">--Box Type--</option>
                        <option value="Standard">standard</option>
                        <option value="HD">HD</option>
                        <option value="HD+">HD+</option>
                        <option value="IPTV">IPTV</option>
                    
</select></td>
</tr>
</table>
</center>
<br>
<br>

<div class=" form-group col-sm-12">
  <div class="col-sm-offset-5 col-sm-1"><input type="submit"  name="action" value="SEARCH" class="btn btn-success" onclick="return send()"></div>
  <div class="col-sm-1"><input type="reset" class="btn btn-danger" value="RESET"></div>
</div>
<%session.getAttribute("c") ;
session.getAttribute("id");
%>
<br>
<br>
<br>
<br>
<br>
<br>
<center><h4>Copyright@TJA392_Group-E</h4></center>
</form>
</body>
</html>