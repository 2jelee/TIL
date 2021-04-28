package bokang;

import java.util.Scanner;

/*
static으로 선언된 변수/메소드는 컴파일러에 의해 프로그램이
실행될때 이미 초기화되어 메소드 영역에 올라간다. 
메소드 영역에 로드된 static(정적) 메소드/변수는 객체생성없이
클래스명 만으로 접근이 가능하다.
즉, new 연산자를 통해 새로운 객체를 계속 생성하지 않고, 하나의
객체를 프로그램 전체에서 공유하는 공유메모리의 역할을 하게된다. 
 */
public class R06Static {
	
	private String name;
	
	public R06Static() {
		System.out.println("나는 기본생성자");
	}
	public R06Static(String n) {
		System.out.println("나는 인자생성자");
		this.name = n;
	}
	public void showName() {
		System.out.println("내 이름은 "+name+" 입니다");
	}
		
	/*
	메인 메소드는 프로그램 시작과 동시에 메소드 영역에 로드된다. 
	즉 사용할 준비가 이미 끝나므로 메인 메소드 내에서는 어떤 객체든지
	생성할수 있게된다. 
	 */
	public static void main(String[] args) {
		
		System.out.println("==첫번째 객체생성==");
		R06Static stat1 = new R06Static();
		stat1.showName();
		
		System.out.println("==두번째 객체생성==");
		new R06Static("홍길동").showName();
		
		System.out.println("==Scanner로 입력받기1");
		System.out.print("정수를 입력하세요:");
		//static변수이므로 클래스명으로 직접 접근할수 있다.
		int iNum = AddClass.scan.nextInt();
		System.out.println("입력한 정수는:"+ iNum);
		
		System.out.println("==Scanner로 입력받기2");
		new AddClass().inputNum();
	}
}

class AddClass {
	/*
	해당 클래스의 멤버변수인 scan도 프로그램 시작과 동시에
	초기화되어 메소드 영역에 올라간다. 따라서 AddClass 클래스명
	으로 접근하여 scan을 가져다 쓸수있다. 
	 */
	public static Scanner scan = new Scanner(System.in);
	
	public void inputNum() {
		System.out.print("정수를 입력하세요:");
		int num = scan.nextInt();
		System.out.println("입력받은 정수는:"+ num);
	}
}





