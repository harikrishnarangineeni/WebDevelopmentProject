package bean;

public class FinalPurchase 
{
 private String name;
 private String SBT_type;
 private String Charging_type;
 private long mac_id;
 private int serial_number;
private  double price;
 
 private double installation_charge;
 private double deposit;
 private double discount;
 private double tax;
 private double amount;
public FinalPurchase() {
	super();
}

public String getCharging_type() {
	return Charging_type;
}

public void setCharging_type(String charging_type) {
	Charging_type = charging_type;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSBT_type() {
	return SBT_type;
}
public void setSBT_type(String sBT_type) {
	SBT_type = sBT_type;
}
public long getMac_id() {
	return mac_id;
}
public void setMac_id(long mac_id) {
	this.mac_id = mac_id;
}
public int getSerial_number() {
	return serial_number;
}
public void setSerial_number(int serial_number) {
	this.serial_number = serial_number;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public double getInstallation_charge() {
	return installation_charge;
}
public void setInstallation_charge(double installation_charge) {
	this.installation_charge = installation_charge;
}
public double getDeposit() {
	return deposit;
}
public void setDeposit(double deposit) {
	this.deposit = deposit;
}
public double getDiscount() {
	return discount;
}
public void setDiscount(double discount) {
	this.discount = discount;
}
public double getTax() {
	return tax;
}
public void setTax(double tax) {
	this.tax = tax;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
 
 
}
