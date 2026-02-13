package ex06.staticMember;

/*
 * static member <--- 공유해서 사용됨
 * 
 * 
 * enum 열거형 : 새로운 클래스 타입을 정의하는 것
 * - 특정한 값만을 가질 수 있는 데이터 타입을 정의할 때 필요함
 * 
 * 형식 :
 * [접근지정자] enum 열거형이름 {필요한 상수들 나열, ...}
 */

class Atm2{
	//멤버변수 2개
	int count;		  //instance member
	static int total; //static member	<< static은 이탤릭체(누워있는)로 구분 O
	
	//돈이 입금되는 형태로 생성자함수 생성
	public Atm2(int amount) {
		count += amount;	//count = count + amount
		total += amount;
	}
	
	/***********************[주의]**************************/
	
	//static member에서 일반멤버변수 사용 X(불가)
	public static void view() {
		total = total + 100;
//		count = count+100;
	}
	
	//static member에서 this 사용할 수 X(불가)
	public static void view2() {
//		this.count = count;
//		this.total = total;
	}

	/*******************************************************/
	
	public void display() {
		System.out.println("count : " + count);
		System.out.println("total : " + total);
	}
}

public interface MainEntry2 {
	public static void main(String[] args) {
		System.out.println(Atm.total);		//0
		
		//객체생성
		Atm at = new Atm(1000);		//Atm at = new Atm(); <<불가
		at.display();		// c : 1000, t : 1000
		System.out.println("------------------------------");
		
		Atm at2 = new Atm(1000);		
		at2.display();		
		System.out.println("------------------------------");
		
		Atm at3 = new Atm(1000);	
		at3.display();		
		System.out.println("------------------------------");
		
		
		/* 출력결과 확인하자! */
	}
}
