package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Channel;

import bean.Customer;
import bean.Customer_Bill;
import bean.Dateprepaid;
import bean.FinalPurchase;
import bean.Inventory;
import bean.Price;
import bean.STBPackage;
import bean.Setup;
import bean.datecol;
import service.Service;
import bean.Package;
/**
 * Servlet implementation class PurchaseSBTController
 */
public class PurchaseSBTController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PurchaseSBTController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		 Service s = new Service();
		
		
		if(action.equals("login"))
		{
			HttpSession session = request.getSession();
			
			int id = Integer.parseInt(request.getParameter("id"));
			String pwd = request.getParameter("password");
			session.setAttribute("id", id);
			boolean f = s.validatePassword(id, pwd);
			 String cust =  s.cust_type(id);
			 session.setAttribute("c",cust);
			  if(f==true)
			  {
				
				   if(cust.equals("Admin")|| cust.equals("Operator"))
				   {
					   RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
				         rd.forward(request, response);
				   }
				   else
				   {
					   RequestDispatcher rd = request.getRequestDispatcher("Customer.jsp");
				         rd.forward(request, response);
				   }
			  }
			  
			   
			  if(f==false)
			  {
				  String a = "Enter correct credentials";
				  request.setAttribute("message", a);
				  RequestDispatcher rd = request.getRequestDispatcher("LoginError.jsp");
			         rd.forward(request, response);
			  }
			
		}
		else if (action.equals("LogOut"))
		{
			HttpSession session = request.getSession(false);
			//session.invalidate();
			 RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	         rd.forward(request, response);
		}
		else if(action.equals("Buy"))
		{
                HttpSession session = request.getSession(false);
                session.getAttribute("id");
                session.getAttribute("c");
			  RequestDispatcher rd = request.getRequestDispatcher("Search.jsp");
		         rd.forward(request, response);
		  
		}
		else if (action.equals("Generate"))
		{
			
			  RequestDispatcher rd = request.getRequestDispatcher("bill.jsp");
		         rd.forward(request, response);
		  
		}
			
		 else if (action.equals("Submit"))
		{
			HttpSession session = request.getSession(false);
			 String name =  request.getParameter("a");
	      String  SBT_type = (String)session.getAttribute("stype");
	      String Charging_type = (String)session.getAttribute("ctype");
	      session.getAttribute("c");
	      session.getAttribute("stype");
	           session.setAttribute("Custname", name);
	    
	           
	    	int j =  s.RetailId_cust(name);
	    	System.out.println(j);
	    	 
	    	 Inventory i = s.fetchInventory(j, SBT_type);
	    	   
	    	   if(i==null)
	    	   {
	    		  RequestDispatcher rd = request.getRequestDispatcher("NoSBT.jsp");
	  	          rd.forward(request, response);
	    	   }
	    	   FinalPurchase fp = new FinalPurchase();
	    	   fp.setName(name);
	    	   fp.setSBT_type(SBT_type);
	    	   fp.setCharging_type(Charging_type);
	    	   
	    	   fp.setMac_id(i.getMacId());
	    	   fp.setSerial_number(i.getSerialNumber());
	    	
	    	  ArrayList <Setup> stp = s.fetchSBT(SBT_type, Charging_type);
	    	  Setup s3 = null;
				
				
				for(Setup s2 : stp)
				{
					if(s2!=null)
					{
						s3=s2;
					}
					break;
				}
				
				fp.setPrice(s3.getPrice());
				fp.setInstallation_charge(s3.getInstallation_Charge());
	    	 
				fp.setDeposit(s3.getRefundable_Deposit_Amount());
	    	
				fp.setDiscount(s3.getDiscount());
	    	 
	    	  double discountamount = s3.getPrice()-((s3.getDiscount()/100)*s3.getPrice());
	    	  double r = s3.getPrice()+s3.getInstallation_Charge()+s3.getRefundable_Deposit_Amount()-discountamount;
	    	  double Tax = (0.12)*r;
	    	 double r1 = Math.ceil(Tax);
	    	  fp.setTax(r1);
	    	   double TotalAmount = s3.getPrice()+s3.getInstallation_Charge()+s3.getRefundable_Deposit_Amount()+r1;
	    	  
	    	  fp.setAmount(TotalAmount);
	    	  
	    	    request.setAttribute("final", fp);
	    	   session.setAttribute( "Inventory" ,i);//
	    	  
	    	  RequestDispatcher rd = request.getRequestDispatcher("FinalPurchase.jsp");
		         rd.forward(request, response);
		         
	       
	    
	    
		}
		else if (action.equals("SEARCH"))
		{
			HttpSession session = request.getSession(false);
			Setup s3 = null;
			session.getAttribute("id");
			 String Charging_type= request.getParameter("type");
				String SBT_type = request.getParameter("set");
				session.getAttribute("c");
				System.out.println("SBT_type");
			ArrayList<Setup> s1 = s.fetchSBT(SBT_type,Charging_type);
			for(Setup s2 : s1)
			{
				if(s2!=null)
				{
					s3=s2;
				}
				break;
			}
			  
		   int j = s3.getSetupId();
		   System.out.println(j);
			 
			ArrayList<String> features1 = s.fetchSBT_features(j);
			Set<String> features2 = new HashSet<String>();
			for(String f : features1)
			{
				features2.add(f);
			}
			s3.setFeatures(features2);
			request.setAttribute("setup",s3);
		
			session.setAttribute("ctype",Charging_type);
			session.setAttribute("stype",SBT_type);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("DetailsSearch.jsp");
	         rd.forward(request, response);
			
		}
		else if(action.equals("PURCHASE"))
			
		{
			HttpSession session = request.getSession(false);
			session.getAttribute("stype");
			session.getAttribute("ctype");
			String cust=(String)session.getAttribute("c");
			int id = (int) session.getAttribute("id");
			
			   if(cust.equals("Customer"))
			   {
			   Customer Customername = s.fetchCustomerName(id);
			   String name = Customername.getCust_Name();
			   session.setAttribute("Custname", name);
			   RequestDispatcher rd = request.getRequestDispatcher("PurchaseSBT.jsp");
		         rd.forward(request, response);
			   }
			   else{
			ArrayList<Customer> cus = s.fetchallCust_names();
			session.setAttribute("names", cus);
			
			RequestDispatcher rd = request.getRequestDispatcher("PurchaseSBT.jsp");
	         rd.forward(request, response);
	         }
		}
		
		else if(action.equals("purchase"))
		{
			HttpSession session = request.getSession(false);
			  String SBT_TYPE= (String)session.getAttribute("stype");
			  String Charging_Type= (String)session.getAttribute("ctype");
			  session.getAttribute("c");
			  session.getAttribute("Inventory");
			  session.getAttribute("stype");
			  session.getAttribute("ctype");
			  session.getAttribute("Custname");
			  ArrayList<Setup>  f = s.fetchSBT(SBT_TYPE, Charging_Type);
			 Setup g = null;
			 for(Setup s1: f){
				 g=s1;
			    }
			 session.setAttribute("setupbox", g);
			 
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("PurchasePackages.jsp");
	         rd.forward(request, response);
		}
		else if(action.equals("Search More Packages"))
		{
			HttpSession session=request.getSession(false);
	    	String k="d";
	    	

	    	request.setAttribute("Ok", k);
	    
	    	RequestDispatcher rd=request.getRequestDispatcher("PurchasePackages.jsp");
	    	rd.include(request, response);
			
		
			
		}
		
		else if(action.equals("Purchase Additional Packages"))
		{
			HttpSession session = request.getSession(false);
			 
			 String SBT_type = (String)session.getAttribute("stype");
			   String Charging_type=(String) session.getAttribute("ctype");
			   Inventory i = (Inventory)session.getAttribute("Inventory");
			 String name= (String) session.getAttribute("Custname");
			        s.updateInventoryStatus(i);
			   session.getAttribute("c");
			   
			   Date date=new Date();
			  ArrayList<Setup> s1 = s.fetchSBT(SBT_type, Charging_type);
			  Setup s2 = null;
					  for(Setup s3 : s1){
						  s2=s3;
					  }
			   ArrayList<STBPackage> s4= s.fetchSTB_Package(s2);
			   Map<String,Double> t = new HashMap<String,Double>();
			   Package p = null;
			   String nam =null;

			   for(STBPackage s5 :s4)
			   {
				  p  =s5.getPac();
				 nam= p.getPackageName();
				  double w = 0;
				   Set<Channel>  a =  p.getChannel();
				   for(Channel c : a)
				   {
					   w=w+c.getCost();
				   }
				   t.put(nam, w);
			   }
			    String[] a = request.getParameterValues("paid");
			    Package p1 = null;
			  
			    for(int i1 =0;i1<a.length;i1++)
			    {
			    	 p1 = s.getPackage(Integer.parseInt(a[i1]));
			    	  double q =0;
			    	for(Channel c1 : p1.getChannel())
			    	{
			    		q=q+c1.getCost();
			    	}
			    	t.put(p1.getPackageName(), q);
			    }
			    request.setAttribute("pac", t);
			    
			    if(Charging_type.equals("prepaid"))
			    {
			  Customer_Bill b = new  Customer_Bill();
			   b.setCustomerName(name);
			   b.setChargingType(Charging_type);
			   b.setBox(SBT_type);
			   b.setDate(date);
			   b.setPacklist(t);
			   b.setCurrentBalance(100);
			   b.setDeductedBalance(0);
			 
			   s.addBill(b);
			   
			 }
			    else{ 
			    	 Customer_Bill b = new  Customer_Bill();
			    	 b.setCustomerName(name);
					   b.setChargingType(Charging_type);
					   b.setBox(SBT_type);
					   b.setDate(date);
					   b.setPacklist(t);
					   b.setCurrentBalance(0);
					   b.setDeductedBalance(0);
					 
					   s.addBill(b);
			    }
			    
			    
			    
            RequestDispatcher rd=request.getRequestDispatcher("PackageSuccess.jsp");
	    	rd.forward(request, response);
	    	
	    }
		else if(action.equals("Purchase Default Packages")){
			HttpSession session = request.getSession(false);
			 
			 String SBT_type = (String)session.getAttribute("stype");
			   String Charging_type=(String) session.getAttribute("ctype");
			   Inventory i = (Inventory)session.getAttribute("Inventory");
			 String name= (String) session.getAttribute("Custname");
			        s.updateInventoryStatus(i);
			   session.getAttribute("c");
			   
			   Date date=new Date();
			  ArrayList<Setup> s1 = s.fetchSBT(SBT_type, Charging_type);
			  Setup s2 = null;
					  for(Setup s3 : s1){
						  s2=s3;
					  }
			   ArrayList<STBPackage> s4= s.fetchSTB_Package(s2);
			   Map<String,Double> t = new HashMap<String,Double>();
			   Package p = null;
			   String nam =null;
			 
			   for(STBPackage s5 :s4)
			   {
				  p  =s5.getPac();
				 nam= p.getPackageName();
				  double w = 0;
				   Set<Channel>  a =  p.getChannel();
				   for(Channel c : a)
				   {
					   w=w+c.getCost();
				   }
				   t.put(nam, w);
			   }
			   
			    request.setAttribute("pac", t);
			    
			 
			    
			    if(Charging_type.equals("prepaid"))
			    {
			  Customer_Bill b = new  Customer_Bill();
			   b.setCustomerName(name);
			   b.setChargingType(Charging_type);
			   b.setBox(SBT_type);
			   b.setDate(date);
			   b.setPacklist(t);
			   b.setCurrentBalance(100);
			   b.setDeductedBalance(0);
			 
			   s.addBill(b);
			   
			 }
			    else{ 
			    	 Customer_Bill b = new  Customer_Bill();
			    	 b.setCustomerName(name);
					   b.setChargingType(Charging_type);
					   b.setBox(SBT_type);
					   b.setDate(date);
					   b.setPacklist(t);
					   b.setCurrentBalance(0);
					   b.setDeductedBalance(0);
					 
					   s.addBill(b);
			    }
			    
			    
			    
           RequestDispatcher rd=request.getRequestDispatcher("PackageSuccess.jsp");
	    	rd.forward(request, response);
			
		}
		
		else if(action.equals("HOME"))
		{
			  HttpSession session = request.getSession(false);
			 String User= (String) session.getAttribute("c");
			 
						if (User.equals("Admin"))
						{
				RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
		    	rd.forward(request, response);
						}
			
						else{
							
								RequestDispatcher rd=request.getRequestDispatcher("Customer.jsp");
						    	rd.forward(request, response);
						     }
			 
		}
		else if(action.equals("BillGenerate"))
		{
			
			Date d=new Date();
			
			DateFormat dateFormat2 = new SimpleDateFormat("MM-dd-yyyy");
			String f=dateFormat2.format(d);
			
			
			
			try
			{
				ArrayList<Customer_Bill> bl=s.fetchbill();
				
				for(Customer_Bill b:bl)
				{
					System.out.println(b.getId());
					datecol dc=new datecol();
					dc.setCurdate(f);
					dc.setId(b.getId());
					dc.setCustomerName(b.getCustomerName());
					dc.setChargingType(b.getChargingType());
				dc.setBox(b.getBox());
				dc.setCurrentBalance(b.getCurrentBalance());
				dc.setDeductedBalance(b.getDeductedBalance());
				dc.setDate(b.getDate());
				Map<String,Double> mp=new HashMap<String,Double>();
				Map<String,Double> mpp=new HashMap<String,Double>();
				//mp=b.getPacklist();
				//System.out.println(mp);
				for(Map.Entry<String, Double> map:mp.entrySet())
				{
				
				   mpp.put(map.getKey(),map.getValue());
					
					
				}
				dc.setPacklist(mpp);
				 s.adddatecol(dc);
		}
			
			request.setAttribute("bill",bl );
			RequestDispatcher rd=request.getRequestDispatcher("billdetail.jsp");
			rd.forward(request, response);
			
}
			catch(Exception e)
			{
				String d2 = "Already generated for the month";
				 request.setAttribute("msg",d2 );
				 ArrayList<datecol> bl=s.fetchdatepost(f);
				 request.setAttribute("postlist",bl );
				  RequestDispatcher rd=request.getRequestDispatcher("billdetail.jsp");
				 rd.forward(request, response);
			}
			
			
			
		
		}
		

		else if(action.equals("detail"))
		{int a=Integer.parseInt(request.getParameter("id"));
			
			Customer_Bill b=s.Fetch(a);
			request.setAttribute("cust",b );
			RequestDispatcher rd=request.getRequestDispatcher("Customerbill.jsp");
			rd.forward(request, response);
			
			
		}
		else if(action.equals("Deduct"))
		{
			ArrayList<Customer_Bill> bl=s.fetchprepaid();
		for(Customer_Bill c:bl)
		{
			System.out.println(c.getId());
		}
		request.setAttribute("prelist",bl );
			RequestDispatcher rd=request.getRequestDispatcher("prepaid.jsp");
			rd.forward(request, response);
			
		}
		
		
	
		

		else if(action.equals("Deduct Balance"))
		{
			
			Date d=new Date();
			DateFormat dateFormat2 = new SimpleDateFormat("MM-dd-yyyy");
			String f=dateFormat2.format(d);
			
			try{
			ArrayList<Customer_Bill> bl=s.fetchprepaidbill();
		    for(Customer_Bill a : bl)
			{
			
			Dateprepaid d1 = new Dateprepaid();
			d1.setCurdate(f);
			d1.setId(a.getId());
			d1.setCurrentbalance(a.getCurrentBalance());
			d1.setDeductbalance(a.getDeductedBalance());
			s.adddatepre(d1);
			}
			
			
					
			 request.setAttribute("prelist",bl );
			  RequestDispatcher rd=request.getRequestDispatcher("prepaidbill.jsp");
			 rd.forward(request, response);
			}
			catch(Exception e )
			{
				String d2 = "Already deducted for the day";
				 request.setAttribute("msg",d2 );
				 ArrayList<Dateprepaid> bl=s.fetchdatepre(f);
				 request.setAttribute("prelist1",bl );
				  RequestDispatcher rd=request.getRequestDispatcher("prepaidbill.jsp");
				 rd.forward(request, response);
				 
			}
			
		}
      
		
		else if(action.equals("DeductBalance"))
		{
			
			Date d=new Date();
			DateFormat dateFormat2 = new SimpleDateFormat("MM-dd-yyyy");
			String f=dateFormat2.format(d);
			ArrayList<Dateprepaid> d1 = s.fetchdatepre(f);
			 			 request.setAttribute("prelist",d1);
			
			  RequestDispatcher rd=request.getRequestDispatcher("prepaidbill.jsp");
			 rd.forward(request, response);
		
			
			
			
		}
	          
			
	}
}
	     



