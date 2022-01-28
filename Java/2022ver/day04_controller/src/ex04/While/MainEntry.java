package ex04.While;

public class MainEntry {
	public static void main(String[] args) {
		
		/*
		[while문]
		
		변수의 초기화;
		while(조건식){
			실행부분
		}
		*/
		for(int i=1;i<11;i++) {
			System.out.println(i);
		}
		//해당 블럭이 닫혔으므로 아래(while)에서 i 중복 사용 O
		
		System.out.println("-------while -------");
		
		int i=1;	//변수의 초기화 필수!!!!
		
		while(i<11) {				//조건
			System.out.println(i);
			i++;					//증감식 필요
		}

		System.out.println("-------while 역으로 출력-------");
		
		int j = 10;
		
		while(j>=1) {				//조건
			System.out.println(j);
			j--;					//증감식 필요
		}
		
		System.out.println("-------do~while 출력-------");
	
		/*
		[do~while]
		do {
			수행문;
		} while(조건식)
		*/
		i = 1;
		do {
			System.out.println(i);
			i++;			//증감식
		} while(i<11);
		
		
	}
}
