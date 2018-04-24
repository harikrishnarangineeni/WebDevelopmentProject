package bean;

import java.util.Set;

public class Setup 
{
	private int setupId;
   private String Type;
   private Set<String> Features;
   private double Height;
   private double Width;
   private double Length;
   private double Price;
   private double Installation_Charge;
   private double Upgradtion_Charge;
   private double Discount;
   private String Billing_Type;
   private double  Refundable_Deposit_Amount;
public Setup(String type, Set<String> features, double height, double width,
		double length, double price, double installation_Charge,
		double upgradtion_Charge, double discount, String billing_Type,
		double refundable_Deposit_Amount) {
	super();
	Type = type;
	Features = features;
	Height = height;
	Width = width;
	Length = length;
	Price = price;
	Installation_Charge = installation_Charge;
	Upgradtion_Charge = upgradtion_Charge;
	Discount = discount;
	Billing_Type = billing_Type;
	Refundable_Deposit_Amount = refundable_Deposit_Amount;
}


public int getSetupId() {
	return setupId;
}


public void setSetupId(int setupId) {
	this.setupId = setupId;
}


public Setup() {
	super();
}

public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}
public Set<String> getFeatures() {
	return Features;
}
public void setFeatures(Set<String> features) {
	Features = features;
}
public double getHeight() {
	return Height;
}
public void setHeight(double height) {
	Height = height;
}
public double getWidth() {
	return Width;
}
public void setWidth(double width) {
	Width = width;
}
public double getLength() {
	return Length;
}
public void setLength(double length) {
	Length = length;
}
public double getPrice() {
	return Price;
}
public void setPrice(double price) {
	Price = price;
}
public double getInstallation_Charge() {
	return Installation_Charge;
}
public void setInstallation_Charge(double installation_Charge) {
	Installation_Charge = installation_Charge;
}
public double getUpgradtion_Charge() {
	return Upgradtion_Charge;
}
public void setUpgradtion_Charge(double upgradtion_Charge) {
	Upgradtion_Charge = upgradtion_Charge;
}
public double getDiscount() {
	return Discount;
}
public void setDiscount(double discount) {
	Discount = discount;
}
public String getBilling_Type() {
	return Billing_Type;
}
public void setBilling_Type(String billing_Type) {
	Billing_Type = billing_Type;
}
public double getRefundable_Deposit_Amount() {
	return Refundable_Deposit_Amount;
}
public void setRefundable_Deposit_Amount(double refundable_Deposit_Amount) {
	Refundable_Deposit_Amount = refundable_Deposit_Amount;
}
   

   
	
	
}
