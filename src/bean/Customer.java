package bean;

public class Customer 
{
    private int custId;
    private String cust_Name;
    private String operator;
    private Retailer retailer;
    
	public Customer() {
		super();
	}
	public Customer(int custId, String cust_Name, String operator,
			Retailer retailer) {
		super();
		this.custId = custId;
		this.cust_Name = cust_Name;
		this.operator = operator;
		this.retailer = retailer;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCust_Name() {
		return cust_Name;
	}
	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Retailer getRetailer() {
		return retailer;
	}
	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}
	
	
	
	
	
}
