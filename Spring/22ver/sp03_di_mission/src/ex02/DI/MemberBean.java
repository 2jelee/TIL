package ex02.DI;

// Bean : data를 가진.. 으로 생각 (Model단으로 생각)
public class MemberBean {
	private String name, message;
	private int age;
	
	// Constructor 
	public MemberBean() {
		System.out.println("MemberBean 기본 생성자 ");
	}

	public MemberBean(String name, String message, int age) {
		super();
		this.name = name;
		this.message = message;
		this.age = age;
	}

	// getter setter method 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
