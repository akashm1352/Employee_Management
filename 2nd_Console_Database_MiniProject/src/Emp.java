
public class Emp {
	int id;
	String name;
	private int sal;
	String loc;
	
	public int getSal() {
		return sal;
	}
	
	public void setSal(int sal) {
		this.sal = sal;
	}

	public Emp(int id, String name, int sal, String loc) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.loc = loc;
	}
	

	public Emp(String name, int sal, String loc) {
		super();
		this.name = name;
		this.sal = sal;
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Emp [id = " + id + ", name = " + name + ", sal = " + sal + ", loc = " + loc + "]";
	}
	
	
	
	
	
}
