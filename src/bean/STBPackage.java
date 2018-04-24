package bean;

public class STBPackage 
{

	private int sno;
	private String packageName;
	private Setup setup;
	private Package pac ;
	
	public STBPackage(int sno, String packageName, Setup setup, Package pac) {
		super();
		this.sno = sno;
		this.setPackageName(packageName);
		this.setup = setup;
		this.pac = pac;
	}
	public STBPackage() 
	{
		super();
	}
		
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	
	public Setup getSetup() {
		return setup;
	}
	public void setSetup(Setup setup) {
		this.setup = setup;
	}
	public Package getPac() {
		return pac;
	}
	public void setPac(Package pac) {
		this.pac = pac;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	
	
}
