package ex05.Interface;

public interface MainEntry {
	public static void main(String[] args) {
		
		BB b = new BB();
		b.draw();
		System.out.println(b.su);
		
		/*********************************************/
		
		//2. super 클래스(iDraw)로 가져오기
		IDraw bb = new BB();		//위와 같은 상황임
		bb.draw();
		System.out.println(bb.su);
	}
}
