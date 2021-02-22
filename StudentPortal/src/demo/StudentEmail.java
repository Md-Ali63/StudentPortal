package demo;

public class StudentEmail {
	public static final String emailStub = "@my.email" ;
	private String name;
	private String id;
	
	public StudentEmail() {
		name = "";
		id = "";
	}
	
	public StudentEmail(String name, String id) {
		//super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + id + emailStub;
	}
	
	
	
}
