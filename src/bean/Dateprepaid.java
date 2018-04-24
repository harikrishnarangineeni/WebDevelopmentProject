package bean;

import java.util.ArrayList;
import java.util.Set;

public class Dateprepaid 
{
private String curdate;
private int id;
private double currentbalance;
private double deductbalance;
public Dateprepaid(String curdate, int id, double currentbalance,
		double deductbalance) {
	super();
	this.curdate = curdate;
	this.id = id;
	this.currentbalance = currentbalance;
	this.deductbalance = deductbalance;
}
public String getCurdate() {
	return curdate;
}
public void setCurdate(String curdate) {
	this.curdate = curdate;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getCurrentbalance() {
	return currentbalance;
}
public void setCurrentbalance(double currentbalance) {
	this.currentbalance = currentbalance;
}
public double getDeductbalance() {
	return deductbalance;
}
public void setDeductbalance(double deductbalance) {
	this.deductbalance = deductbalance;
}
public Dateprepaid() {
	super();
}


	
}
