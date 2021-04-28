package ex09package;

/*
Buyer, Seller클래스를 외부 패키지에 묶어 정의하였으므로
아래와 같이 import처리 후 사용할 수 있다. 
 */
import ex09package.kosmo.buyer.FruitBuyer4;
import ex09package.kosmo.seller.FruitSeller4;

/*
연습문제] 해당 프로그램을 아래의 지시에 따라 패키지로 
구분하여 정상 실행되도록 변경하시오.

FruitSeller4 클래스 -> ex09package.kosmo.seller 패키지에 묶는다.
FruitBuyer4 클래스 -> ex09package.kosmo.buyer 패키지에 묶는다.

두 클래스를 적당히 import하여 정상동작할수 있도록 
FruitSalesMain4 클래스를 구성한다.
 */

public class FruitSalesMain4 {
	
	public static void main(String[] args) {

		/*
		초기화 메소드를 정의하였으므로, 각각 성격이 다른 객체들을
		생성할 수 있다. 
		 */
		//판매자1 : 사과갯수:100개, 단가:1000원
		FruitSeller4 seller1 = new FruitSeller4(0, 100, 1000);

		//판매자2 : 사과갯수:80개, 단가:500원
		FruitSeller4 seller2 = new FruitSeller4(0, 80, 500);

		//구매자 : 보유금액 10000원
		FruitBuyer4 buyer = new FruitBuyer4(10000, 0);

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

