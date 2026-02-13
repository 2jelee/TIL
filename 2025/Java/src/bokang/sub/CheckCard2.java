package bokang.sub;
/*
체크카드 클래스 Ver.02

버전02에서 추가부분
	1. 멤버변수 초기화 메소드 정의 
		메소드명 : initMembers()
	2. 기본생성자, 인자생성자 정의
	3. 멤버변수 정보은닉
	4. getter/setter 메소드 추가
 */
public class CheckCard2 {
	
	//멤버변수 : 주어진 조건에 따라 적절히 정의한다.
	private long cardNumber;
	private String owner;
	private int balace;
	private int point;
	/*
	정보은닉이란 멤버변수를 private으로 만들어서 클래스 외부에서는
	접근하지 못하게 하는것이다.  
	*/
	
	
	//초기화메소드
	/*
	생성자가 아닌 일반적인 멤버메소드를 만들때에는 
	무조건 public void를 붙여놓고 시작한다. 차후 반환타입이 있는경우
	void를 해당 반환타입으로 변경하면된다. 
	 */
	public void initMembers(long cardNumber, String owner, 
			int balace, int point) {
		/*
		멤버변수를 멤버메소드에서 사용할때는 무조건 this를 붙인다.
		 */
		this.cardNumber = cardNumber; 
		this.owner = owner;
		this.balace = balace;
		this.point = point;
	}
	
	/*
	멤버변수가 private으로 선언되면 클래스내부에서만 접근가능하므로
	외부에서의 접근을 위해 getters/setters를 무조건 생성해야한다. 
	 */
	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalace() {
		return balace;
	}

	public void setBalace(int balace) {
		this.balace = balace;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	/*
	멤버변수를 정의하였다면 생성자는 무조건 자동생성 메뉴를 사용한다. 
	source -> generate constructor
	※생성자는 멤버메소드와는 다르게 반환형이 없고 클래스와 이름이 동일하다.
	 */
	//기본생성자
	public CheckCard2() {}
	//인자생성자
	public CheckCard2(long cardNumber, String owner, int balace, int point) {
		super();
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balace = balace;
		this.point = point;
	}



	//멤버메소드	
	//충전(입금) 
	public void charge(int amount) {
		//현재 잔고에 충전할 금액을 더해준다.
		this.balace += amount;
	}
	
	//결제 
	public void payment(int amount) {
		//잔고에서 결제할 금액만큼 차감한다.
		this.balace -= amount;
		//카드를 사용할때 적립금이 발생되므로 여기서 호출한다.
		savingPoint(amount);
	}	
	
	//적립 : 사용금액의 0.1%를 적립해야된다.
	public void savingPoint(int amount) {		
		double plusPoint = (amount*0.1);		
		this.point += plusPoint;
		/*
			복합대입 연산자의 특성상 형은 항상 좌측항을 따라간다. 
			따라서 형변환에 대한 에러가 발생하지 않는다. 
			하지만 아래처럼 풀어서 쓰면 에러가 발생한다. 
		 */
		//this.point = this.point + plusPoint;
	}
		
	//현재상태출력
	public void showState() {
		System.out.println("카드번호:"+ this.cardNumber);
		System.out.println("소유자:"+ this.owner);
		System.out.println("잔고:"+ this.balace);
		System.out.println("포인트:"+ this.point);
	}
	
}
