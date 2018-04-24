package bean;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public class Customer_Bill 
{
	private int Id;
	private String customerName;
	private String chargingType;
	private String box;
	private Date date;
	private double currentBalance;
	private double deductedBalance;
	private Map<String,Double> packlist;
	
	
	public Customer_Bill(int id, String customerName, String chargingType,
			String box, Date date, double currentBalance,
			double deductedBalance, Map<String, Double> packlist) {
		super();
		Id = id;
		this.customerName = customerName;
		this.chargingType = chargingType;
		this.box = box;
		this.date = date;
		this.currentBalance = currentBalance;
		this.deductedBalance = deductedBalance;
		this.packlist = packlist;
	}

	
	public Customer_Bill() {
		super();
	}





	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getChargingType() {
		return chargingType;
	}
	public void setChargingType(String chargingType) {
		this.chargingType = chargingType;
	}
	public String getBox() {
		return box;
	}
	public void setBox(String box) {
		this.box = box;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public double getDeductedBalance() {
		return deductedBalance;
	}
	public void setDeductedBalance(double deductedBalance) {
		this.deductedBalance = deductedBalance;
	}
	public Map<String, Double> getPacklist() {
		return packlist;
	}
	public void setPacklist(Map<String, Double> packlist) {
		this.packlist = packlist;
	}
	
	
	
}