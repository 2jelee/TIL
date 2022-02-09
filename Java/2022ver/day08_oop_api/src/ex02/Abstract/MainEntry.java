package ex02.Abstract;

public class MainEntry {
	public static void main(String[] args) {
		
		//3.
		Shape[] ss = new Shape[3];	//이는 배열 생성 및 선언
//		Shape ss = new Shape();	//자체적으로 객체 생성하지 못함!!
		ss[0] = new Circle();	//0번째에 Circle 선언하겠다.
		ss[1] = new Rect();
		ss[2] = new Triangle();
		
		Object[] shape = {new Circle(), new Rect(), new Triangle()};	//object 타입으로 직접 생성해도 가능!
		for (int i = 0; i < ss.length; i++) {
			ss[i] = (Shape)shape[i];		//명시적 형변환
			ss[i].show(name[i]);
		}
		
		
		String[] name = {"Circle", "Rect", "Triangle"};
		
		for(int i=0; i<ss.length; i++) {
			ss[i].show(name[i]);
		}
		
		System.out.println("-----------------------------------------------");
		
		//2. 부모인 Shape로 추상클래스를 이용해서 객체 생성
		Shape sh = new Circle();
		sh.show("Circle Circle");
		
		sh = new Rect();
		sh.show("Rect Rect");
		sh = new Triangle();
		sh.show("Triangle Triangle");
		
		
		System.out.println("-----------------------------------------------");
		//1. 각자의 클래스로 객체 생성 형태
//		Circle c = new Circle();
//		c.show("원");
		
//		Rect r = new Rect();
//		r.show("Ractangle");
		
		Triangle t = new Triangle();
		t.show("삼각형");
		
//		Shape s = new Circle(); 		//다형성 구현 가능하다!	>>한번의 호출로 여러 모양새 만들 수 있다.
//		s.show("Circle");
	}
}
