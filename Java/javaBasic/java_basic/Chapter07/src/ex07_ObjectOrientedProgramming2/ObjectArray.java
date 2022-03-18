package ex07_ObjectOrientedProgramming2;

class Product2 {
	int price;
	int bonusPoint;
	
	Product2 (int price){
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	
	// 기본 constructor : 생성자
	Product2 () { }
}

// 조상클래스의 생성자 Product2(int price)를 호출
class Tv2 extends Product{
	Tv2() {
		super(100); //Tv의 가격을 100만원으로 한다.
	}
	
	// Object 클래스의 toString() 을 오버라이딩
	public String toString() {
		return "Tv";
	}
}

class Computer2 extends Product {
	Computer2() {
		super(200);
	}
	public String toString() {
		return "Computer";
	}
}

class Audio2 extends Product {
	Audio2() {
		super(200);
	}
	public String toString() {
		return "Audio";
	}
}

class Buyer2{
	int money = 1000;
	int bonusPoint = 0;
	Product2[] cart = new Product2[10]; //구입한 제품을 저장하기 위한 배열
	int i = 0; // Product 배열에 사용될 counter
	
	//method
	void buy2(Product2 p) {
		if(money < p.price) {
			System.out.println("잔액 부족으로 물건 구매 불가");
			return;
		}
		
		money -= p.price;
		bonusPoint += p.bonusPoint;
		cart[i++] = p;	// 제품을 Product[] cart에 저장
		
		System.out.println(p +"을/를 구매했습니다.");
	}
	
	void summary() {
		int sum = 0;
		String itemList = "";
		
		for (int i = 0; i < cart.length; i++) {
			if(cart[i]==null) {
				break;
			}
			sum += cart[i].price;
			
			//아래와 같다.
//			itemList += cart[i] +", ";
			itemList += (i==0) ? "" + cart[i]:"," + cart[i];
		}
		System.out.println("구입한 물품의 총 금액은 " +sum +"만원");
		System.out.println("구입한 제품은 " + itemList +"입니다.");
	}
}

public class ObjectArray {
	public static void main(String[] args) {
		Buyer2 b = new Buyer2();
		
		b.buy2(new Tv2());
		b.buy2(new Computer2());
		b.buy2(new Audio2());
		b.summary();
	}
}
