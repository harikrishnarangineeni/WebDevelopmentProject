package bean;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public class datecol 
{
	private String curdate;
	private int Id;
	private String customerName;
	private String chargingType;
	private String box;
	private Date datee;
	private double currentBalance;
	private double deductedBalance;
	private Map<String,Double> packlist1;
	public datecol() {
		super();
	}
	public datecol(String curdate, int id, String customerName,
			String chargingType, String box, Date datee, double currentBalance,
			double deductedBalance, Map<String, Double> packlist1) {
		super();
		this.curdate = curdate;
		Id = id;
		this.customerName = customerName;
		this.chargingType = chargingType;
		this.box = box;
		this.datee = datee;
		this.currentBalance = currentBalance;
		this.deductedBalance = deductedBalance;
		this.packlist1 = packlist1;
	}
	public String getCurdate() {
		return curdate;
	}
	public void setCurdate(String curdate) {
		this.curdate = curdate;
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
		return datee;
	}
	public void setDate(Date date) {
		this.datee = datee;
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
		return packlist1;
	}
	public void setPacklist(Map<String, Double> packlist) {
		this.packlist1 = packlist;
	}
	
	
	
	
}