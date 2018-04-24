package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import service.Service;
import bean.Channel;

import bean.Customer;
import bean.Customer_Bill;
import bean.Dateprepaid;
import bean.Inventory;
import bean.Price;
import bean.STBPackage;
import bean.User;
import bean.Package;
import bean.Retailer;
import bean.Setup;
import bean.datecol;

public class DthDao {
	public DthDao() {

	}

	public int addSBT(Setup s) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		int i = (Integer) session.save(s);
		tr.commit();
		session.close();
		return i;

	}

	public ArrayList<Customer> fetchallCust_names() {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		String hql = "select c from Customer c ";
		Query query = session.createQuery(hql);
		ArrayList<Customer> cust_names = (ArrayList<Customer>) query.list();
		session.close();
		return cust_names;
	}

	public int fetchCust_Id(String name) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		String hql = "select c.custId from Customer c where c.cust_Name=?";
		Query query = session.createQuery(hql);
		query.setString(0, name);
		ArrayList<Integer> cust_names = (ArrayList<Integer>) query.list();
		session.close();
		Integer j = 0;
		for (Integer i : cust_names) {
			j = i;
		}
		return j;
	}

	public int RetailId_cust(String name) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		String sql = "select c.RETAILERID from customer c where c.CUST_NAME=? ";
		Query query = session.createSQLQuery(sql);
		query.setString(0, name);
		ArrayList<BigDecimal> ret = (ArrayList<BigDecimal>) query.list();
		int j = 0;
		for (BigDecimal i : ret) {
			j = i.intValue();
			break;
		}
		session.close();
		return j;

	}

	public ArrayList<Inventory> fetchallInventory_ret(int id, String settopbox) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		String sql = "from  Inventory i where i.retailer=? and i.setTopBox=?";
		Query query = session.createQuery(sql);
		query.setInteger(0, id);
		query.setString(1, settopbox);

		ArrayList<Inventory> inventories = (ArrayList<Inventory>) query.list();
		session.close();
		return inventories;

	}

	public ArrayList<Setup> fetchSBT(String f, String g) {

		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		String hql = "select s from Setup s where s.Type=? and s.Billing_Type=?";
		Query query = session.createQuery(hql);
		query.setString(0, f);
		query.setString(1, g);
		ArrayList<Setup> s = (ArrayList<Setup>) query.list();
		session.close();
		return s;

	}

	public ArrayList<String> fetchSBT_features(int i) {

		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		String sql = "select s.features from setup_Features s where s.setupid=?";
		Query query = session.createSQLQuery(sql);
		query.setInteger(0, i);
		ArrayList<String> features = (ArrayList<String>) query.list();
		session.close();
		return features;

	}

	public int addReatiler(Retailer r) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Integer i = (Integer) session.save(r);
		tr.commit();
		session.close();
		return i;
	}

	public int addCustomer(Customer c) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		int i = (Integer) session.save(c);
		tr.commit();
		session.close();

		return i;

	}

	public void addUser(User u) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		session.persist(u);
		tr.commit();
		session.close();
		// return j;

	}

	public int addInventory(Inventory i) {

		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		int j = (Integer) session.save(i);
		tr.commit();
		session.close();

		return j;
	}

	public User validate_login(int id) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		User u = (User) session.get(User.class, new Integer(id));

		session.close();
		return u;

	}

	public ArrayList<String> cust_type(int id) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		String hql = "select u.u_Type from User u where u.u_Id=?";

		Query query = session.createQuery(hql);
		query.setInteger(0, id);
		ArrayList<String> types = (ArrayList<String>) query.list();
		session.close();
		return types;
	}

	public void updateStatusInventory(Inventory i) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		Inventory j = (Inventory) session.get(Inventory.class,
				i.getInventoryId());
		j.setStatus("unassigned");
		session.update(j);
		;
		tr.commit();
		session.close();

	}

	public void addPackage(Package p) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tran = ses.beginTransaction();
		ses.save(p);
		tran.commit();
		ses.close();
	}

	public boolean addSTBPackage(STBPackage p) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tran = ses.beginTransaction();
		ses.save(p);
		tran.commit();
		ses.close();
		return true;
	}

	public boolean addSTB(Setup p) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tran = ses.beginTransaction();
		ses.save(p);
		tran.commit();
		ses.close();
		return true;
	}

	public ArrayList<Package> fetchPackage(String ptype, Setup type) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tran = ses.beginTransaction();
		String hql = "select s.pac from STBPackage s where s.packageName=? and s.setup=?";
		Query query = ses.createQuery(hql);
		query.setString(0, ptype);
		query.setEntity(1, type);
		// ArrayList<Package> ch =(ArrayList<Package>)query.list();
		ArrayList<Package> ch = (ArrayList<Package>) query.list();

		tran.commit();
		ses.close();
		return ch;

	}

	public Package getPackage(int id) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		String hql = "select p from Package p where p.packageId=?";
		Query query = ses.createQuery(hql);
		query.setInteger(0, id);
		query.list();
		ArrayList<Package> s = (ArrayList<Package>) query.list();
		Package s1 = null;
		for (Package s2 : s) {
			if (s2 == null) {
				continue;
			}
			s1 = s2;
			break;

		}
		ses.close();
		return s1;
	}

	public int getIdOfSelectedPackage(String Package_Name) {
		Configuration cfg = new Configuration();

		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		String hql = "select p.packageId from Package p where p.packageName=?";
		Query query = ses.createQuery(hql);
		ArrayList<Integer> packages = (ArrayList<Integer>) query.list();
		Integer s1 = 0;
		for (Integer s2 : packages) {
			if (s2 == null) {
				continue;
			}
			s1 = s2;
			break;

		}
		return s1;

	}

	public double costofPackage(BigDecimal i) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();

		String hql = "select c.cost from Channel c  where c.channelId =?";
		Query query = ses.createQuery(hql);
		query.setBigDecimal(0, i);
		ArrayList<Double> cost = (ArrayList<Double>) query.list();
		ses.close();
		Double j = null;
		for (Double d : cost) {
			if (d == null) {
				continue;
			}
			j = d;
			break;
		}
		return j;
	}

	public ArrayList<BigDecimal> fetchChannels(int id) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tran = ses.beginTransaction();
		String hql = "select s.channelId from package_channel_E s where s.packageId=?";
		Query query = ses.createSQLQuery(hql);
		query.setInteger(0, id);
		ArrayList<BigDecimal> cids = (ArrayList<BigDecimal>) query.list();
		tran.commit();
		ses.close();
		return cids;

	}

	public String fetchChannelsNames(BigDecimal id) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tran = ses.beginTransaction();
		String hql = "select c.channelName from Channel c where c.channelId=? ";
		Query query = ses.createSQLQuery(hql);
		query.setBigDecimal(0, id);
		ArrayList<String> names = (ArrayList<String>) query.list();
		String c1 = null;
		for (String c : names) {
			if (c == null) {
				continue;
			}
			c1 = c;
			break;
		}
		tran.commit();
		ses.close();
		return c1;
	}

	public Double fetchChannelscost(BigDecimal id) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tran = ses.beginTransaction();
		String hql = "select c.cost from Channel c where c.channelId=? ";
		Query query = ses.createSQLQuery(hql);
		query.setBigDecimal(0, id);
		ArrayList<Double> costs = (ArrayList<Double>) query.list();
		Double c1 = null;
		for (Double c : costs) {
			if (c == null) {
				continue;
			}
			c1 = c;
			break;
		}
		tran.commit();
		ses.close();
		return c1;
	}

	public ArrayList<STBPackage> fetchSTB_Package(Setup type, String t) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();

		String hql = "select s from STBPackage s where s.packageName=? and s.setup=?";
		Query query = ses.createQuery(hql);
		query.setString(0, t);
		query.setEntity(1, type);
		ArrayList<STBPackage> packages = (ArrayList<STBPackage>) query.list();
		ses.close();
		return packages;

	}

	public void addBill(Customer_Bill b) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.save(b);
		tr.commit();
		ses.close();
	}

	public Customer fetchCustomer(int id) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		String hql = "select b from Customer b where b.custId=?";
		Query query = ses.createQuery(hql);
		query.setInteger(0, id);

		ArrayList<Customer> bil = (ArrayList<Customer>) query.list();
		ses.close();
		Customer s1 = null;
		for (Customer s : bil) {
			s1 = s;
		}

		return s1;

	}

	public void addCustomer_Bill(Customer_Bill b) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.save(b);
		tr.commit();
		ses.close();
	}

	public ArrayList<Customer_Bill> fetchbill() {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();

		String hql = "select b from Customer_Bill b where b.chargingType=?";
		Query query = ses.createQuery(hql);
		query.setString(0, "postpaid");

		ArrayList<Customer_Bill> bil = (ArrayList<Customer_Bill>) query.list();
		ses.close();
		return bil;

	}

	public ArrayList<Customer_Bill> fetchprepaid() {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();

		String hql = "select b from Customer_Bill b where b.chargingType=?";
		Query query = ses.createQuery(hql);
		query.setString(0, "prepaid");

		ArrayList<Customer_Bill> bil = (ArrayList<Customer_Bill>) query.list();

		ses.close();
		return bil;

	}

	public void updateprepaid(Customer_Bill bill) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction t = ses.beginTransaction();
		/*
		 * Customer_Bill c=( Customer_Bill)ses.load(Customer_Bill.class,new
		 * Integer(b));
		 */

		ses.update(bill);
		t.commit();
		ses.close();
		sf.close();
	}
	
	
	public String adddate(datecol dd) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction t=ses.beginTransaction();
		String dc=(String) ses.save(dd);
		t.commit();
		ses.close();
		sf.close();
	
		System.out.println("daop"+dd.getCurdate());
		return dc;
		
		
		
	
	}
	public String adddatepre(Dateprepaid dd)
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
	     Transaction t = ses.beginTransaction();
		String dc=(String) ses.save(dd);
		
		t.commit();
		ses.close();
		
	
	
		return dc;
		
	}
	public ArrayList<Dateprepaid>fetchdatepre(String f)
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction t=ses.beginTransaction();
		
		String hql ="select f from Dateprepaid f ";
		Query query = ses.createQuery(hql);
		ArrayList<Dateprepaid> ds = (ArrayList<Dateprepaid> )  query.list();
		
		 
		t.commit();
		ses.close();
		return ds;
		
		
		
		
	}
	public ArrayList<datecol> fetchdatepost(String f)
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction t=ses.beginTransaction();
		
		String hql ="select f from datecol f ";
		Query query = ses.createQuery(hql);
		ArrayList<datecol> ds =(ArrayList<datecol>) query.list();
		
		 
		t.commit();
		ses.close();
		return ds;
		
		
		
		
	}
	public String adddatecoll(datecol d)
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/hbm.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
	     Transaction t = ses.beginTransaction();
		String dc=(String) ses.save(d);
		
		t.commit();
		ses.close();
		
	
	
		return dc;
	}
	
	

	public static void main(String[] args) {

		DthDao d = new DthDao();
		
		/*Channel c1 = new Channel();
		c1.setChannelId(107);
		c1.setChannelName("ISAIARUVI");
		c1.setCost(100);
		Channel c2 = new Channel();
		c2.setChannelId(108);
		c2.setChannelName("SUN TV");
		c2.setCost(100);
		Channel c3 = new Channel();
		c3.setChannelId(109);
		c3.setChannelName("JAYA TV");
		c3.setCost(100);
		Package p1 = new Package();
		p1.setPackageId(104);
		p1.setPackageName("TAMIL");
		Set<Channel> s = new HashSet<Channel>();
		s.add(c1);
		s.add(c2);
		s.add(c3);
		p1.setChannel(s);
		d.addPackage(p1);*/
		Retailer r = new Retailer();
		r.setName("rocky");

		Customer c1 = new Customer();
		c1.setCust_Name("Nitish");
		
		c1.setOperator("dipesh");
		c1.setRetailer(r);
		//d.addCustomer(c1);
		
		
		
		

		/*
		 * Channel c1 = new Channel(); c1.setChannelId(100);
		 * c1.setChannelName("Cartoon"); c1.setCost(20); Channel c2 = new
		 * Channel(); c2.setChannelId(101); c2.setChannelName("POGO");
		 * c2.setCost(20); Set <Channel> s = new HashSet <Channel>(); s.add(c1);
		 * s.add(c2); Package p1 = new Package(); p1.setPackageId(1000);
		 * p1.setChannel(s); p1.setPackageName("KIDS"); // d.addPackage(p1);
		 */

		/*
		 * Setup s = new Setup(); s.setType("Standard");
		 * s.setBilling_Type("postpaid"); s.setDiscount(100); s.setHeight(10);
		 * s.setLength(10); s.setWidth(30); s.setRefundable_Deposit_Amount(10);
		 * s.setUpgradtion_Charge(0); Set<String> s1 = new HashSet<String>();
		 * s1.add("Live");
		 * 
		 * s.setFeatures(s1);
		 * 
		 * //d.addSTB(s);
		 * 
		 * Retailer r = new Retailer(); r.setName("Gaurav"); Customer c = new
		 * Customer(); c.setCust_Name("manoj"); c.setOperator("Vijay");
		 * c.setRetailer(r); d.addCustomer(c);
		 * 
		 * Inventory i = new Inventory(); i.setRetailer(r);
		 * i.setStatus("assignedtoretailer"); i.setSetTopBox("HD+");
		 * i.setControlId(10); i.setMacId(1000000010); i.setDishId(100);
		 * i.setSerialNumber(1000); d.addInventory(i);
		 */

		/*
		 * Channel c1 = new Channel(); c1.setChannelId(10);
		 * c1.setChannelName("maatv"); c1.setCost(20); Channel c2 = new
		 * Channel(); c2.setChannelId(11); c2.setChannelName("ETV");
		 * c2.setCost(20); Channel c3 = new Channel(); c3.setChannelId(12);
		 * c3.setChannelName("zee"); c3.setCost(20); Channel c4 = new Channel();
		 * c4.setChannelId(13); c4.setChannelName("gemini"); c4.setCost(20);
		 * Package p1 = new Package(); p1.setPackageId(100); Set<Channel> f =
		 * new HashSet<Channel>(); f.add(c1); f.add(c2);
		 * p1.setPackageName("TELUGU1"); p1.setChannel(f); Package p2 = new
		 * Package(); p2.setPackageId(101); Set<Channel> g = new
		 * HashSet<Channel>(); g.add(c3); g.add(c4);
		 * p2.setPackageName("TELUGU2"); p2.setChannel(g); d.addPackage(p1);
		 * d.addPackage(p2);
		 */

		Customer_Bill custbill = new Customer_Bill();
		custbill.setCustomerName("vikram");
		custbill.setChargingType("postpaid");
		custbill.setBox("HD+");
		custbill.setCurrentBalance(0);
		custbill.setDeductedBalance(0);
		Date dd = new Date();
		
		//String str[]=Date.parse(dd);
         System.out.println(dd);
		//custbill.setDate(dd);
		Map<String, Double> mp = new HashMap<String, Double>();
		mp.put("kidskart", 10.0);
		//custbill.setPacklist(mp);*/
		ArrayList<Customer_Bill> b=d.fetchbill();
		for(Customer_Bill d1 : b)
		{
			System.out.println(d1.getId());
		}

	}



}
