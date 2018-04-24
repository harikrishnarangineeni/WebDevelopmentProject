
<%@page import="bean.Channel"%>
<%@page import="bean.STBPackage"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Customer"%>
<%@page import="bean.Setup"%>
<%@page import="java.util.*" %>
<%@page import="bean.Inventory"%>
<%@page import="service.Service"%>
<%@page import="java.text.*" %>
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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<script type="text/javascript">windows.history.forward()</script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
<script>
function f1()
{ 
	var name=[];
	var flag=0;
	var name=document.getElementsByName("paid"); 
	for(var i=0,length=name.length; i<length; i++)
	{
		if(name[i].checked)
			{
				flag++;
				return true;
	        }
		}
	if(flag==0)
		{
		alert("Please Select Atleast One Package");
		return false;
		}
}


</script>

<title>Purchase Packages</title>
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
	<%
 
		Service ds=new Service();
	    session.getAttribute("Inventory");
		Setup setupbox=(Setup)session.getAttribute("setupbox");
		session.getAttribute("stype");
		session.getAttribute("ctype");
		 session.getAttribute("Custname");
		 session.getAttribute("c");
		 
ArrayList<STBPackage> defaultlist=ds.fetchSTB_Package(setupbox);
ArrayList<STBPackage> paidlist=ds.FetchAdditional(setupbox);

         //String h = (String) session.getAttribute("msg");

%>
	
	  <center><h4 style="color:#ffff99">
	  Set Top Box have been successfully Purchased.Please buy Packages</h4></center>
	
<br>
<br>
<center>
<div align="center">
		<table class="table" style="font-size: 18px; color: white; padding: 15px;width:550px;" align="center" border=1 rules="all">
			<tr style="text-align: center;">
				<th style="text-align: center; color: #ff471a;" colspan="2">Purchase Additional
					Packages</th>
			</tr>
			
			<tr>
				<th style="color:#1a8cff">Default Added Packages</th>
				<td><table rules="all" border=1 style="font-size: 18px; padding: 15px;">
						<tr>
							<th style="color:#1a8cff">Package Name</th>
							<th style="color:#1a8cff">Package cost</th>
						</tr>
						<%for(STBPackage subp: defaultlist){ 
   double channelcost=0;%>
						<tr>

							<td><i><%=subp.getPac().getPackageName() %></i></td>
							<%for(Channel c:subp.getPac().getChannel()) {
	   
	   channelcost=channelcost+c.getCost();
   }%>
							<td><i><%= channelcost%></i></td>
							<%} %>
						</tr>
					</table></td>
			</tr>

			<tr>
				<td style="text-align: center" colspan="2"><form
						action="<%=request.getContextPath()%>/PurchaseSBTController">
						<input type="submit" name ="action" value="Search More Packages" class="btn btn-success">
							<input type="submit" name ="action" value="Purchase Default Packages" class="btn btn-success">
							
					</form></td>
			</tr>

		</table>
		
       
      

    <form name="f2" method="post" action="<%=request.getContextPath()%>/PurchaseSBTController">
	<center>
	
		<%if(request.getAttribute("Ok")!=null){%>
		<table class="table" style="font-size: 18px; color: #1a8cff; padding: 15px;width:1000px;" align="center" border=1 rules="all">
			<tr>
				<td colspan="4" style="color:#79ff4d">
					<% for(STBPackage sbb: paidlist){%> <input type="checkbox"
					name="paid" id="paid1" value="<%=sbb.getPac().getPackageId()%>"
					onclick="checkbox(this)" /><%=sbb.getPac().getPackageName() %> <%} %>
				</td>
			</tr>
			</table>
			
			
			<%  for(STBPackage sbb: paidlist){  double d=0;%>
			<table align="center" id="<%=sbb.getPac().getPackageId()%>" class="table" style="display: none;font-size: 18px; color: white; padding: 15px;width:1033px;" align="center" rules="all">
				       
				<tr>
				<td style="text-align: center;color: #1a8cff;" colspan="4">Add on Package
					Details</td>
			</tr>
			
			<tr>
				<td style="width:20%;color: #1a8cff;">PackageName</td>
				<td style="width:30%;color: #1a8cff;">ChannelDetails</td>
				<td style="width:25%;color: #1a8cff;">PackagePurchaseDate</td>
				<td style="width:25%;color: #1a8cff;">TotalPackageCost</td>
			</tr>
				        
				  <tr><td style="width:20%">
				           
							<i><%=sbb.getPac().getPackageName() %></i>
							</td>
							<td style="width:30%">
								<table id="<%=sbb.getPac().getPackageId()%>" border="2">
									<tr >
										<th>ChannelName</th>
										<th>ChannelCost</th>
									</tr>
									
									<%for(Channel c:sbb.getPac().getChannel()){
	d+=c.getCost();%>
									<tr>
										<td><i><%=c.getChannelName()%></i></td>
										<td><i><%=c.getCost() %></i></td>
									</tr>
								<%} %>
								</table></td>
							
							<td style="width:25%"><i><p  id="<%=sbb.getPac().getPackageName()%>"></p></i> 
                            
                            
                          
<script> 
document.getElementById("<%=sbb.getPac().getPackageName()%>").innerHTML =Date();
</script>
							</td>
							<td style="width:25%"><i><%=d %></i></td>
					
					
					
				
				
			</tr>
			<%} %>
			
			
			
         		
			
		</table>
		
		
		<div class=" form-group col-sm-10">
  <div class="col-sm-offset-5 col-sm-4">
         <input type="submit" name="action" value="Purchase Additional Packages" class="btn btn-success" onclick="return f1()"/></div></div>
	</div>
   
		
	</form>

		<script type="text/javascript">
		
			 function checkbox(a) {
              
				
			   
				if (a.checked) {
					var b = a.value;
					document.getElementById(b).style.display = "block";
					}
				
				
				else{
					var b = a.value;
	                document.getElementById(b).style.display = "none";
				    }
			} 
			
		</script>

		<%}%>

		<%-- <table >
<tr><% for(SetUpBoxPackage sbb: paidlist){%>
<td colspan="1"> <input type="checkbox" name="paid" value="<%=sbb.getPack().getPid()%>"/><%=sbb.getPack().getPackageName() %></td>
<%} %>
</tr>
</table>
<%} %> --%>

	</center>
	</div>
</body>
</html>

