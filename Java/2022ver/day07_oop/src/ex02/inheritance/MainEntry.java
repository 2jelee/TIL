package ex02.inheritance;

/*
[inheritance(상속)]
- extends
- ★단일 상속★만 지원(하나만 받아오자)
- super
- 재사용
- 확장

*/
//상속받기
/*
class Circle extends Point {
	private int r;

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	
	//output method
//	/*
	public void display() {
		System.out.print("x : " + x + "\ty : " + y);	//Point클래스의 멤버변수가 private으로 되어있으면 error
	} 
}
//	*/

public class MainEntry {
	public static void main(String[] args) {
		//자손(sub)객체 생성 시 부모(super) 생성자 함수 메모리 상에 올려져 있다.
		
		Circle cir = new Circle();
		cir.display();
		
		Circle2_constructor c = new Circle2_constructor();
		c.display();
		System.out.println(c);
		
		Point pt = new Point();
		System.out.println(pt);
	}
}