package ex04;

/*
 * 1 ~ 20까지의 정수 중에서 2 또는 3의배수가 아닌 수의 총합
 */

public class Practice02 {
	public static void main(String[] args) {
		int sum = 0;
		
		for(int num=1;num<=20;num++) {
			if(num%2!=0 || num%3!=0) {
				sum += num;
			}
		}
		System.out.println(sum);
	}
}
