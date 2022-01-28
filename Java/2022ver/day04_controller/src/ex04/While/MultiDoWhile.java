package ex04.While;

public class MultiDoWhile {
	public static void main(String[] args) {
		int a=1, b=1; //변수초기화
		do {
			do {
				System.out.print(b+"\t");
				b++;	   //증감식
			} while(b<=3); //조건
			a++;
			System.out.println();
		} while(a<=2);		//조건
		
		/*************************************/
		//[주의] 변수 초기화 위치
		int x=1, y=1;			//변수초기화
		do {
			y=1;				//초기화		//while, do~while문에서는
			do {
				System.out.print(b+"\t");
				y++;
			} while(b<=3);		//조건
			x++;				//증감
			System.out.println();
		} while(x<=2);			//조건
	}
}
