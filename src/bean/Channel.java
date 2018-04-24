package bean;

public class Channel {

	private int channelId;
	private String channelName;
	private double cost;
	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Channel(int channelId, String channelName, double cost) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.cost = cost;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
