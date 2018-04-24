package bean;

public class User 
{
   private int u_Id;
   private String u_Type;
   private String password;
   
public User() {
	super();
}

public User(int u_Id, String u_Type, String password) {
	super();
	this.u_Id = u_Id;
	this.u_Type = u_Type;
	this.password = password;
}

public int getU_Id() {
	return u_Id;
}

public void setU_Id(int u_Id) {
	this.u_Id = u_Id;
}

public String getU_Type() {
	return u_Type;
}

public void setU_Type(String u_Type) {
	this.u_Type = u_Type;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

   
}
