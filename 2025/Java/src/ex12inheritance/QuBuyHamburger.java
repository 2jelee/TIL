package ex12inheritance;
/*
문제5) QuBuyHamburger.java
햄버거를 추상화한 클래스와 기본가격, 세트가격을 추상화한 클래스를 정의하여 
햄버거를 주문시 기본가격 혹은 세트가격으로 출력할수 있도록 프로그램을 구현하시오. 
조건은 다음과 같다. 
	햄버거
		멤버변수 : 버거명, 가격, 패티, 소스, 야채
		인자생성자 
		멤버메소드 : 가격반환(getter), 햄버거정보출력
	햄버거 기본가격 : 햄버거 + 음료 + 프렌치프라이의 합계
		멤버변수 : 햄버거종류(객체), 음료가격(1000원으로 고정), 
			프렌치프라이가격(1500원으로 고정)
		인자생성자
		멤버메소드 : 기본가격계산, 결제금액출력
	세트가격 : 기본가격클래스를 상속받음. 기본가격에서 500원 할인된 금액으로 계산
		멤버변수 : 없음
		인자생성자
		멤버메소드 : 세트가격계산(Overriding), 결제금액출력(Overriding)
 */
//햄버거를 추상화
class Burger {
	/*
	멤버변수 : 버거명, 가격, 패티, 소스, 야채
	인자생성자 
	멤버메소드 : 가격반환(getter), 햄버거정보출력
	 */	
	private String burgerName;
	private int price;
	private String patty;
	private String sauce;
	private String vegetable;
	//인자생성자
	public Burger(String burgerName, int price, String patty, String sauce, String vegetable) {
		super();
		this.burgerName = burgerName;
		this.price = price;
		this.patty = patty;
		this.sauce = sauce;
		this.vegetable = vegetable;
	}
	//getter/setter : 문제에서는 price만 요구했음. 
	public int getPrice() {
		return price;
	}	 
	
	//햄버거 정보 출력
	public void showBurger() {
		System.out.println(burgerName);
		System.out.println("가격:"+ price);
		System.out.printf("식재료:%s, %s, %s\n", 
				patty, sauce, vegetable);
	}	
}

//햄버거의 기본가격 추상화
class HamburgerPrice {
	//멤버변수
	Burger burger;// 디폴트(default) 접근지정자로 설정
	final int COKE = 1000;
	final int POTATO = 1500;
	
	//인자생성자 : 상수는 이미 초기화되어 있으므로 햄버거 객체만 초기화한다.
	public HamburgerPrice(Burger burger) {
		this.burger = burger;
	}
	
	//기본가격계산 : 햄버거 + 콜라 + 프렌치프라이 가격의 합 
	public int price() {
		//햄버거의 price는 private 이므로 getter를 통해 가져와야 함.
		int total = burger.getPrice() + COKE + POTATO;
		return total;
	}
	
	//햄버거와 결제금액 출력
	public void showPrice() {
		burger.showBurger();//햄버거의 정보 출력
		System.out.println("결제금액:"+ price());
		System.out.println("==========================");
	}
}

//햄버거의 세트가격 (기본가격을 상속)
class SetPrice extends HamburgerPrice {
	
	//인자생성자
	public SetPrice(Burger burger) {
		//부모클래스에 정의된 인자생성자 호출
		super(burger);
	}
	
	//세트가격계산(오버라이딩) : 500원 할인된 가격으로 계산함.
	@Override
	public int price() {
		//부모의 기본가격 계산식에서 500원 차감
		return super.price() - 500;
	}
	
	//햄버거와 세트가격을 출력(오버라이딩)
	@Override
	public void showPrice() {
		//디폴트 접근지정자는 동일 패키지에서는 접근을 허용함.
		burger.showBurger();
		System.out.println("세트결제금액:"+ price());
		System.out.println("============================");
	}
}

public class QuBuyHamburger {

	public static void main(String[] args) {
		
		//치즈버거 객체 생성
		Burger burger1 = new Burger("치즈버거", 2000, "쇠고기패티", "케챱", "피클");
		//치킨버거 객체 생성
		Burger burger2 = new Burger("치킨버거", 3000, "닭고기패티", "마요네즈", "양상치");
		
		//치즈버거를 기본가격으로 구매
		HamburgerPrice price1 = new HamburgerPrice(burger1); 
		price1.showPrice();	// 4500원	
		
		SetPrice setprice1 = new SetPrice(burger1); 
		setprice1.showPrice();	// 할인된 4000원
		
		//치킨버거를 세트가격으로 구매
		HamburgerPrice price2 = new HamburgerPrice(burger2); 
		price2.showPrice();	// 5500원 
		
		HamburgerPrice setprice2 = new SetPrice(burger2); 
		setprice2.showPrice();	// 할인된 5000원
	}
}

