package bean;

public class Inventory
{
  private int InventoryId;
   private String setTopBox;
   private int serialNumber;
   private long macId;
   private int controlId;
   private int dishId;
   private String status;
   private Retailer retailer;
public int getInventoryId() {
	return InventoryId;
}
public void setInventoryId(int inventoryId) {
	InventoryId = inventoryId;
}
public String getSetTopBox() {
	return setTopBox;
}
public void setSetTopBox(String setTopBox) {
	this.setTopBox = setTopBox;
}
public int getSerialNumber() {
	return serialNumber;
}
public void setSerialNumber(int serialNumber) {
	this.serialNumber = serialNumber;
}
public long getMacId() {
	return macId;
}
public void setMacId(long macId) {
	this.macId = macId;
}
public int getControlId() {
	return controlId;
}
public void setControlId(int controlId) {
	this.controlId = controlId;
}
public int getDishId() {
	return dishId;
}
public void setDishId(int dishId) {
	this.dishId = dishId;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Retailer getRetailer() {
	return retailer;
}
public void setRetailer(Retailer retailer) {
	this.retailer = retailer;
}
public Inventory(String setTopBox, int serialNumber, long macId, int controlId,
		int dishId, String status, Retailer retailer) {
	super();
	this.setTopBox = setTopBox;
	this.serialNumber = serialNumber;
	this.macId = macId;
	this.controlId = controlId;
	this.dishId = dishId;
	this.status = status;
	this.retailer = retailer;
}
public Inventory() {
	super();
}


	
}
