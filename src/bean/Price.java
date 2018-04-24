package bean;

import java.util.Date;

public class Price {
	
	private long billNo;
	private String billingType;
	private int pack;
	
	public Price() {
		super();
	}

	
	public int  getPack() {
		return pack;
	}


	public void setPack(int pack) {
		this.pack = pack;
	}


	public long getBillNo() {
		return billNo;
	}

	public void setBillNo(long billNo) {
		this.billNo = billNo;
	}

	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	
	public Price(long billNo, String billingType) {
		super();
		this.billNo = billNo;
		this.billingType = billingType;
		
	}

	
	
}
