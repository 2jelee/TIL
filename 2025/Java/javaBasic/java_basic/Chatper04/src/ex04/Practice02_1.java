package ex04;

/*
 * 1 ~ 20까지의 정수 중에서 2 또는 3의배수가 아닌 수의 총합
 */

public class Practice02_1 {
	public static void main(String[] args) { 
		int sum = 0;
		
		for (int i = 1; i <=20; i++) {
			if(i%2!=0 || i%3!=0) {
//				System.out.println("i = "+i);
				sum += i;
			} 
		}
		System.out.println(sum);
	}
}
