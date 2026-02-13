package ex02.Synchronized;

class Atm {
	private int money;

	//생성자 함수
	public Atm(int money) {
		this.money = money;
	}
	
	//2개의 함수 생성
	//1. 입금 함수
	public synchronized void deposit(int amount, String name) { //얼마를, 누가 입금
		money += amount;
		System.out.println(name + "님의 입금 금액 : "+ amount);
	}
	
	//2. 출금 함수
	public void withdraw(int amount, String name) { //얼마를, 누가 출금 
		synchronized (this) { 
			//잔액이 0보다 커야한다.
			if((money-amount) > 0) {
				
				Thread.yield();		//양보하는..	>> 엉키는 상황 추가
				
				money -= amount;
				System.out.println(name +"님의 출금 금액 : "+amount);
			}
			else {
				System.out.println(name+"님의 잔액이 부족하여 출금이 불가능합니다.");
			}
		
		}
	}
	
	//얼마 남았는지(잔액) 보여주는
	public void getMoney(){
		System.out.println("	잔액은 " + money + "원입니다.");
	}
} //end of Atm class

//통장 개설할 class
class UserAtm extends Thread {		// Thread를 상속 받
	Atm obj;
	boolean flag = false;
	
//	public UserAtm(int money) {
	public UserAtm(Atm obj, String name) {
		super(name);
		this.obj = obj;

	}

	//thread 구현부 run
	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(flag) {
				obj.deposit((int)(Math.random() * 10 + 2)*100, getName());
				obj.getMoney(); //잔금
				
			} else {		// random은 double 타입이므로 int로 형변환	>> withdraw의 매개변수는 int와 string이므로
				obj.withdraw((int)(Math.random() * 10 + 2)*100, getName());
				obj.getMoney(); //잔금
			}
			//끝나면 flag변수를 true로 바꿈
			flag = true;
		}
	} 
} //End of UserAtm

public class MainEntry {
	public static void main(String[] args) {
		Atm at = new Atm(1000); 	//1000원을 넣고 계좌 개설
		
		UserAtm user1 = new UserAtm(at, "가나다");
		UserAtm user2 = new UserAtm(at, "2jelee");
		UserAtm user3 = new UserAtm(at, "홍길동");
		
		user1.start();
		user2.start();
		user3.start();
	}
}
