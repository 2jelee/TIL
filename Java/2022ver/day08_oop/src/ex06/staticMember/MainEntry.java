package ex06.staticMember;

/*
 * static member <--- 공유해서 사용됨
 * 
 */

class Atm{
	//멤버변수 2개
	int count;		  //instance member
	static int total; //static member	<< static은 이탤릭체(누워있는)로 구분 O
	
	//돈이 입금되는 형태로 생성자함수 생성
	public Atm(int amount) {
		count += amount;	//count = count + amount
		total += amount;
	}
	
	public void display() {
		System.out.println("count : " + count);
		System.out.println("total : " + total);
	}
}

public interface MainEntry {
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
