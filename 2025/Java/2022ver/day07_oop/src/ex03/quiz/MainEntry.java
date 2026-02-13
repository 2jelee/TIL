package ex03.quiz;

public class MainEntry {
	public static void main(String[] args) {
		Quiz_Triangle t = new Quiz_Triangle();
		System.out.println(t);
		
		t.setH(100);
		t.setW(200);
		System.out.println(t);
		
		//result 0.0 나오는 이유?
	}
}
