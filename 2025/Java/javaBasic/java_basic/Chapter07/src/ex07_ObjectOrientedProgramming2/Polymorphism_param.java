package ex07_ObjectOrientedProgramming2;

// '참조변수+문자열'은 '참조변수.toString()+문자열'로 처리됨

class Product{
	int price;
	int bonusPoint;
	
	Product(int price){
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}

class Tv1 extends Product{
	Tv1(){
		super(100); //Tv의 가격을 100만원으로 한다.
	}
	
	// Object 클래스의 toString() 을 오버라이딩
	public String toString() {
		return "Tv";
	}
}

class Computer extends Product {
	Computer() {
		super(200);
	}
	public String toString() {
		return "Computer";
	}
}

class Buyer{
	int money = 1000;
	int bonusPoint = 0;
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 구매할 수 없습니다.");
			return;
		}
		
		money -= p.price;	//가진 돈에서 구입한 제품의 가격을 minus
		bonusPoint += p.bonusPoint; //제품의 보너스 점수를 추가
		System.out.println(p+"을/를 구입했습니다.");
	}
}

class Polymorphism_param {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new Tv1());
		b.buy(new Computer());
		
		System.out.println("현재 남은 돈은 " +b.money +"만원입니다.");
		System.out.println("현재 보너스 점수는 "+b.bonusPoint+"점입니다.");
	}
}
