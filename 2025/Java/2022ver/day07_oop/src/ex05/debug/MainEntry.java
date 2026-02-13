package ex05.debug;

public class MainEntry {
	public static void main(String[] args) {
		int x = 5, y = 0;	//y는 누적할 변수라 0으로 초기화했음
		int i;
		
		for(i=1; i<6; i++) {
			y += x*i;
		} //end of for
		
		for(i=1; i<100; i++) {
			if(i==30) break;
			System.out.println(i);
		} //end of for
		
		System.out.println(x + ", " + y + ", " + i);
	}
}
