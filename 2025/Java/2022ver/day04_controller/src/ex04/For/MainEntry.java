package ex04.For;

public class MainEntry {
	public static void main(String[] args) {
		
		/*
		for(int i=1; i<=10; i++) {
			System.out.print(i + "\t");
		}
		*/
		
		/*
		for(int i=1; i<100; i++) {
			if(i%11==0) System.out.println();
			System.out.print((i+1)+"\t");
		} //end of for
		*/
		
		/*
		//[문제] 1~100까지 중에서 3의배수의 갯수와 합을 구하는 프로그램 작성 
		
		// ★★누적(할) 변수는 초기화하자!
		int sum = 0;
		//1. for문 이용
		//2. 1~100까지의 정수
		for(int i=1; i<=100; i++) {
			//3. 3의배수 ~
			if(i%3==0) {
				// ~를 찾아 모두 더한다.
				sum+=i;	//sum = sum+i;
			}
		}
		//4. 더한 값을 출력
		System.out.println("3의배수의 총합 : "+sum);
		
		int count = 0;
		for(int j=1; j<=100; j++) {
			if(j%3==0) {
				count = j;
			}
		} //end of for
		System.out.println("3의배수의 갯수 : " + count);
		*/
		
		/********************************************/
		
		int sum2, count2; 
		sum2 = count2 = 0;
		
		for(int z=1; z<101; z++){
			if(z%3==0) {
				count2++;	// 동일 : count2 += 1; 	// 동일 : count2 = count2 + 1;
				sum2 += z;
			}
		} //end of for
		System.out.println("1~100까지 중에서 3의 배수의 갯수와 합 : " + count2 + "개, 합 "+ sum2);
	}
}
