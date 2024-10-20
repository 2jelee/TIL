package common;

public class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//객체의 정보 반환용 메소드
	public String getInfo() {
		return String.format("이름:%s, 나이:%d", name, age);
	}
	//객체의 정보 출력용 메소드
	public void showInfo() {
		System.out.println(getInfo());
	}
	
	
	
	
	/*
	Set컬렉션에서 객체 저장시 동일한 객체인지 확인하기 위해
	아래 2개의 메소드를 자동으로 호출하여 확인한다. 
	따라서 개발자가 정의한 객체인 경우 중복제거를 위해 반드시
	오버라이딩 해야한다. 
	 */
	@Override
	public int hashCode() {
		System.out.println("hashCode메소드 호출됨:"+name.hashCode());
		return (name.hashCode()+age);//이름과 나이 둘다 비교
		//return age; //나이만 비교
		//return name.hashCode(); //이름만 비교
	}
	/*
	오버라이딩 한 두개의 메소드는 항상 동일한 멤버변수간의 
	비교를 해야한다. hashCode()에서는 나이를 반환하고, 
	equals()에서는 이름만 비교하는 형태라면 이상한 결과가
	나올수도 있다. 
	 */
	@Override
	public boolean equals(Object obj) {
		Person person = (Person)obj;
		System.out.println("equals메소드 호출됨");
		if(person.age==this.age && 
				person.name.equals(this.name)) {//둘다 비교
		//if(person.age==this.age) {//나이만 비교
		//if(person.name.equals(this.name)) {//이름만 비교
			return true;
		}
		else {
			return false;
		}
	}
}