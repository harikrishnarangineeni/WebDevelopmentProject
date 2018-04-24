package bean;

//import java.io.File;
//import java.util.List;
import java.util.Set;

public class Retailer 
{
 
	private int retailerId;
	private String Name;
	public Retailer(int retailerId, String name) {
		super();
		this.retailerId = retailerId;
		Name = name;
	}
	public int getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Retailer() {
		super();
	}
	
	
	
	
}
