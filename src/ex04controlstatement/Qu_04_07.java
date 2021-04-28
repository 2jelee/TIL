package ex04controlstatement;
/*
문제2) 1~100까지의 숫자중 3의배수 이거나 7의배수인 숫자의 합을 구하는 프로그램을 작성하시오.
단, 3과 7의 공배수인 경우 합에서 제외해야 한다. 
출력의결과는 누적되는 모든 수를 콘솔에 print한다.
 */
public class Qu_04_07 {

	public static void main(String[] args) {
		
		int sum = 0;//누적합을 위한 변수
		//1~100까지 반복
		for(int i=1 ; i<=100 ; i++) {
			//3의배수이거나 7의배수
			if(i%3==0 || i%7==0) {
				//3과7의 공배수가 아닌 경우
				if(i%(3*7)!=0) {
					sum += i;
					System.out.print(i+"+");
				}
			}			
		}
		System.out.println("\n결과:"+ sum);
	}
}
