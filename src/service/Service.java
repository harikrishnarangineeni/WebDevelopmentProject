package service;
import bean.Package;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import bean.Customer;
import bean.Customer_Bill;
import bean.Dateprepaid;
import bean.Inventory;
import bean.Price;
import bean.STBPackage;
import bean.Setup;
import bean.User;
import bean.datecol;
import dao.DthDao;

public class Service 
{

	public Service()
	{
		
	}
	
	
	DthDao d = new DthDao();
	public String adddatecol(datecol dz)
	{
		String dd= d.adddatecoll(dz);
		return dd;
	}
	public String adddate(datecol dd)
	{
		
		
	
		
		
		String c=d.adddate(dd);
		System.out.println(dd.getCurdate());
		return c;
	}
	
	public  ArrayList<Setup> fetchSBT(String f,String g)
	{
		return d.fetchSBT(f,g);
	}
	 public ArrayList<String> fetchSBT_features(int i)
	{
		return d.fetchSBT_features(i);
	}
	 public int RetailId_cust(String name)
	 {
		 return d.RetailId_cust(name);
	 }
	 public Inventory fetchInventory(int id ,String settopbox)
	 {
		 ArrayList<Inventory> invs = d.fetchallInventory_ret(id, settopbox);
		 Inventory j = null;
		 
		 for(Inventory i : invs)
		 {
			 
			 if(i.getStatus().equals("assignedtoretailer"))
			 {
			 
			   j=i;
			   break;
			 }
		 }
		 return j;
	 }
	public boolean validatePassword(int id,String pwd)
	{
		User u  = d.validate_login(id);
		//String j = null;
		
		if(u==null)
		{
			return false;
		}
		else if (u.getPassword().equals(pwd)){
			return true;
		}
		return false;
		
	}
	public String cust_type(int id)
	{
		ArrayList<String> cust = d.cust_type(id);
		String j = null;
		for(String p : cust)
		{
			if(p==null)
				break;
			if (p!=null){
				j=p;
				break;
			}
			
		}
		
			return j;
	}
	
	public void updateInventoryStatus(Inventory i)
	{
		d.updateStatusInventory(i);
	}

     public ArrayList<Double> getCostOfDefaultpackage(Setup type) 
	{
    		ArrayList<Double> a = new ArrayList<Double>();
    		ArrayList<Package> p =d.fetchPackage("Y", type);
    		for(Package r : p)
    		{
    			if(r==null){
    				continue;}
    			
    			int j = r.getPackageId();
    		   ArrayList<BigDecimal>  ch =  d.fetchChannels(j);
    		   double sum=0;
    		   for(BigDecimal c:ch)
    		   {
    			   sum=sum+d.costofPackage(c);
    		   }
    		   a.add(sum);
    		}
    		return a;
    		
	}
     public ArrayList<Customer> fetchallCust_names()
 	{
    	return  d.fetchallCust_names();
    	 
   }
/*	public ArrayList<String> defaultPackageName(Setup type)
	{
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<Package> p =d.fetchPackage("Y", type);
		for(Package r : p)
		{
			if(r==null){
				continue;}
			
			int j = r.getPackageId();
		       a.add(d.getPackageName(j));
		}
		return a;
		
	}



	  public ArrayList<Double> getCostOfadditionalpackage(Setup type) 
		{
	    		ArrayList<Double> a = new ArrayList<Double>();
	    		ArrayList<Package> p =d.fetchPackage("N", type);
	    		for(Package r : p)
	    		{
	    			if(r==null){
	    				continue;}
	    			
	    			int j = r.getPackageId();
	    		   ArrayList<BigDecimal>  ch =  d.fetchChannels(j);
	    		   double sum=0;
	    		   for(BigDecimal c:ch)
	    		   {
	    			   sum=sum+d.costofPackage(c);
	    		   }
	    		   a.add(sum);
	    		}
	    		return a;
	    		
		}
		
		public ArrayList<String> AdditionalPackageName(Setup type)
		{
			ArrayList<String> a = new ArrayList<String>();
			ArrayList<Package> p =d.fetchPackage("N", type);
			for(Package r : p)
			{
				if(r==null){
					continue;}
				
				int j = r.getPackageId();
			       a.add(d.getPackageName(j));
			}
			return a;
			
		}
		public  ArrayList<String> getselectedChannelsNames(String name)
		{
			int j = d.getIdOfSelectedPackage(name);
			 ArrayList<String> ch = new ArrayList<String>();
			   ArrayList<BigDecimal> f = d.fetchChannels(j);
			   for(BigDecimal h : f)
			   {
				  
				 ch.add(d.fetchChannelsNames(h)) ;
				   
				   
			   }
			
			return ch;
		}
		
		public ArrayList<Double> getselectedChannelscost(String name)
		{
			int j = d.getIdOfSelectedPackage(name);
			 ArrayList<Double> ch = new ArrayList<Double>();
			   ArrayList<BigDecimal> f = d.fetchChannels(j);
			   for(BigDecimal h : f)
			   {
				  
				 ch.add(d.fetchChannelscost(h)) ;
				   
				   
			   }
			
			return ch;
		}
		public HashMap<String,Double> MapforChannel(String name)
		
		{
			Service s = new Service();
			
			ArrayList<String> yl =s.getselectedChannelsNames(name);
			ArrayList<Double>  zl = s.getselectedChannelscost(name);
			Double[] sl3= new Double[yl.size()];
			 int k=0;
			 for(Double d:zl)
			 {
				 sl3[k]=d;
				 k++;
			 }
			 int g=0;
			 HashMap<String,Double> p = new HashMap<String,Double>() ;
	          for(String a : yl )
			  {
				 p.put(a,  sl3[g]);
				 g++;
					
			  }
	          
	          return p;
		}
		*/
		public ArrayList<STBPackage> fetchSTB_Package(Setup type)
		{
			return d.fetchSTB_Package(type,"Y");
		}
		
		public ArrayList<STBPackage>FetchAdditional(Setup type)
		{
			return d.fetchSTB_Package(type, "N");
		}
		public void addSBT(Setup p ){
			d.addSTB(p);
		}

		public int fetchCust_Id(String name){
			return d.fetchCust_Id(name);
		}
		
		public Package getPackage(int id ){
			return d.getPackage(id);
		}
	
		public void  addBill(Customer_Bill b)
	    {
		  
			d.addBill(b);;
		}
		
		  
		   
		   
		   public Customer fetchCustomerName(int id)
			{
			   
			  return  d.fetchCustomer(id);
			}
		   public ArrayList<Customer_Bill> fetchbill()
		     {
		    	 ArrayList<Customer_Bill> bill=d.fetchbill();
		    	 return bill;
		     }
		     public ArrayList<Customer_Bill> fetchprepaid()
		     {
		    	 ArrayList<Customer_Bill> bill=d.fetchprepaid();
		    	 
		    	 return bill;
		     }
		     public Customer_Bill Fetch(int a) {
					ArrayList<Customer_Bill> bl=d.fetchbill();
					Customer_Bill n=new Customer_Bill();
					for(Customer_Bill b:bl)
					{
						if(b.getId()==a)
						{
							n=b;break;
						}
					}
					return n;
					
				}
				public ArrayList<Customer_Bill> fetchprepaidbill() {
					ArrayList<Customer_Bill> bl=d.fetchprepaid();
					double dz=0;
					
					for(Customer_Bill b:bl)
					{
					for(Map.Entry<String,Double> hm :b.getPacklist().entrySet())
					{System.out.println(hm.getValue());
						dz=dz+hm.getValue();
					}
				
						double db=Math.ceil(dz/30);
						double c=b.getCurrentBalance()-db;
						b.setCurrentBalance(c);
						b.setDeductedBalance(db);
						d.updateprepaid(b);
					}
					return bl;
				}
				
				public String adddatepre(Dateprepaid dd)
				{
					return d.adddatepre(dd);
				}
				
				public ArrayList<Dateprepaid> fetchdatepre(String f)
				{
					return d.fetchdatepre(f);
				}
				public ArrayList<datecol> fetchdatepost(String f)
				{
					return d.fetchdatepost(f);
				}
				
		
	}
	
	

