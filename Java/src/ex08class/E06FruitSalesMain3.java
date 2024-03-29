package ex08class;

//과일판매자를 추상화한 클래스
class FruitSeller3{
	
	int numOfApple; //판매자의 사과 보유갯수
	int myMoney;  //판매수익
	final int APPLE_PRICE; //사과의 단가
	/*
	상수는 값의 변경이 불가능하고, 단 한번만 초기화되기 때문에
	일반 멤버메소드에서는 초기화 할수없다. 
	하지만 생성자 메소드는 객체생성시 한번만 호출되고, 개발자가
	마음대로 호출할수 없으므로 한번이상 초기화 되지 않음이 보장된다. 
	따라서 멤버상수는 생성자 메소드에서는 초기화 할수 있다. 
	 */
	public FruitSeller3(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		APPLE_PRICE = price;
	}
		 
	public int saleApple(int money) {				
		int num = money / APPLE_PRICE;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	//판매자의 현재상태를 출력하는 멤버메소드
	public void showSaleResult() {
		System.out.println("[판매자]남은사과갯수:"+ numOfApple);
		System.out.println("[판매자]판매수익:"+ myMoney);
	}
}
 
//구매자를 표현한 클래스
class FruitBuyer3{

	int myMoney ; //보유금액  
	int numOfApple ; //구매한 사과의 갯수
	
	//생성자 메소드
	public FruitBuyer3(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	
	public void buyApple(FruitSeller3 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	//구매자의 현재상태 출력
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+ myMoney);
		System.out.println("[구매자]사과갯수:"+ numOfApple);
	}
}

public class E06FruitSalesMain3 {
	
	public static void main(String[] args) {

		/*
		초기화 메소드를 정의하였으므로, 각각 성격이 다른 객체들을
		생성할 수 있다. 
		 */
		//판매자1 : 사과갯수:100개, 단가:1000원
		FruitSeller3 seller1 = new FruitSeller3(0, 100, 1000);

		//판매자2 : 사과갯수:80개, 단가:500원
		FruitSeller3 seller2 = new FruitSeller3(0, 80, 500);

		//구매자 : 보유금액 10000원
		FruitBuyer3 buyer = new FruitBuyer3(10000, 0);
		
		System.out.println("구매행위가 일어나기전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();

		//판매자1, 2에게 각각 5000원씩 지불한 후 사과 구매
		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);

		System.out.println("구매행위가 일어난 후의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();	 
	}
}

