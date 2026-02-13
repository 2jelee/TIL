package ex03.Interface;

//상속 : extends
//인터페이스 생성 : interface

//interface : abstract method와 final field만 갖는다.
interface A {
	int x = 9;	//이는 final static int x = 90;과 같다		s는 static(이탤릭체)의 약자 | f는 final의 약자	
	final int y = 7777;
	char ch = 'A';
	
	//body가지면 X >> 이는 abstract가 생략된 것과 같다. 무조건 추상메소드임		-추상메소드, abstract 생략가능함
	public void show();
	public abstract void disp();
}

interface B {
	void bView();
}

interface C {
	String name = "happy";
	public void draw();		//이는 추상메소드
}

//B를 상속받는 인터페이스	>> interface간 상속에서도 extends 키워드를 사용
interface D extends B {
	void dView();	
}	

class Rect implements D{ 	//D는 추상메소드만 가지므로(몸체가 완성되지 않은) 이를 override해야만 된다.

	@Override
	public void bView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dView() {
		// TODO Auto-generated method stub
		
	}	
	
	public int plus(int x, int y) {
		return x+y;
	}
}

//Shape (일반)클래스
class Shape {
	
}


//다중으로 상속받겠다
class Multi extends Shape implements B,C,A{  //B,C,A는 추상메소드만 가지므로(몸체가 완성되지 않은) 이를 override해야만 된다.
//class Multi implements B,C,A extends Shape {  //java complier 인식순서 : 바로 옆에는 Class가 상속되어야 하고 그뒤에 impl와야한다!!!
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bView() {
		// TODO Auto-generated method stub
		
	}
	
}

public class MainEntry {
	
}
