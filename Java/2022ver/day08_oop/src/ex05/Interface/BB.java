package ex05.Interface;

public class BB implements IDraw {

	@Override
	public void draw() {
		System.out.println("BB class에서 iDraw의 메소드를 오버라이드 했습니다.");
	} 
}
