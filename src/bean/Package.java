package bean;

import java.util.Set;

public class Package {

	private int packageId;
	private String packageName;
	private Set<Channel> channel;
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public Set<Channel> getChannel() {
		return channel;
	}
	public void setChannel(Set<Channel> channel) {
		this.channel = channel;
	}
	public Package() {
		super();
		
	}
	public Package(int packageId, String packageName, Set<Channel> channel) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.channel = channel;
	}
	
	
}
