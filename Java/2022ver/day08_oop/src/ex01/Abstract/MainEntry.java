package ex01.Abstract;

abstract class Shape{	//추상클래스, Super class
	double result = 0; //대상 결과를 저장할 변수
	public abstract double calc(); //추상메소드 -몸체가 없음
	public abstract void draw();
	
	public void show() {	//일반메소드
		System.out.println("Super class Shape입니다.");
	}
}	//Shape end

class Circle extends Shape { //Sub class(상속받은 애)
	//위 모드만 작성하고 ovrride(재정의)
	
	double r = 5.0; //추가 1
	
	@Override
	public double calc() {
		//추가
		result = r* r*Math.PI;
		return result;
//		return 0;		//기존 삭제
	}

	@Override
	public void draw() {
		calc();		//2. 또는 계산이 필요하면 여기서 불러주기
		System.out.println("원의 넓이 : "+result +"인 원을 그렸습니다.");
	}
	
	//새 메소드 생성	-아무것도 없는.
	public void disp() { }
}
public class MainEntry {
	public static void main(String[] args) {
//		Shape sh = new Shape();	  //자체적으로 객체 생성 X			>> 부모는 자손에 접근하는 방법이 X
		Shape sh = new Circle();  //상속받은 자손은 객체 생성 O		//부모(Shape)가 만들어두면 협소하게 접근한다.
//		sh.		//부모것만 가능
		Circle c = new Circle();  //자손 자체 것, 부모 것 모두 사용가능
//		c.
		
		c.calc();	
		c.draw();	//1. 위 코드(c.calc();)가 없으면 0.0으로(계산안되어) 나옴
	}
}
