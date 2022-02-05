package ex01.oop;

public class MainEntry {
	public static void main(String[] args) {
		Point pt = new Point(); //객체 생성 및 메모리 할당 + 생성자함수 자동호출
		pt.display();	//이렇게 출력 시 int는 0으로, String은 null로 초기화되어 있다.
		pt.setX(5); pt.setY(10);
		pt.display();
		
		Circle cir = new Circle();
		cir.setX(100); cir.setY(200); cir.setR(50);
		cir.display();

		Rect rec = new Rect();
		rec.setX(100); rec.setY(200); rec.setX2(111); rec.setY2(222);
		rec.display();
	}
}
