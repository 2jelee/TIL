package ex01.nonDi;

public class MainEntry {

	public static void main(String[] args) {
		
		// is - a : 상속
		// has - a : 포함 관계
		// has-a 관계를 통해서 객체를 다루기
	
		NewRecordView view = new NewRecordView(90, 80, 100, 95);
		
		view.print();
	}
}
