package ex02.jdbc_mvc;

// Model
public class Customer {
	 
	public final String ClassName = "Customers";
	 
	private int code;
	private String name;
	private int email;
	private int phone;
	 
	public String getClassName() { //getter만
		return ClassName;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmail() {
		return email;
	}

	public void setEmail(int email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
}
