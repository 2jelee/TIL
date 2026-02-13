package ex02.inheritance;

public class Circle extends Point{
//	private int x, y;	//자기 class 내부에서만 사용 가능
	protected int x, y;	//위의 사항을 보완

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	//output method
	public void display() {
		super.display();	//상속받은(extends Point) display메소드를 가져온다.
		System.out.print("Circle의 출력문 > x : " + x + "\ty : " + y);
	}
}
