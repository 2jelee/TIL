package ex06.oop;

/*
[클래스 설계]
1. class Circle {x, y, r}
2. class Rect {x, y, x2, y2}

[문제1] class Sawn {
			이름, 직급, 부서, 급여, 연락처
			setter / getter method
			output method
*/

class Sawn { 
	//멤버변수
	String name, jikgub, dep, phoneNum;	//이름, 직급, 부서, 연락처
	int pay;							//급여 
	
	//멤버함수 : setter/getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJikgub() {
		return jikgub;
	}
	public void setJikgub(String jikgub) {
		this.jikgub = jikgub;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	} 
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	//output 메소드
	public void output() {
		System.out.println("이름 : "+ name + " / 직급 : "+ jikgub + " / 부서 : " + dep + " / 급여 : "+ pay + " / 연락처 : " + phoneNum);
//		System.out.println(getName() + ", " + getJikgub() + ", " +getDep() + ", " +getPay() + ", " +getPhoneNum());
	}
} //end of Sawn

public class Quiz_Sawn {
	public static void main(String[] args) { 
		Sawn sa = new Sawn();
		
		sa.setName("이지은");
		sa.setJikgub("사원");
		sa.setDep("개발부");
		sa.setPay(1234);
		sa.setPhoneNum("01012345678");
		sa.output();
	}
}  

