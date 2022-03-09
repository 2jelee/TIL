package ex04;

/*
 * 1+(1+2)+(1+2+3)+...+(1+2+3+4+....+10) 의 결과는?
 */
public class Practice03 {
	public static void main(String[] args) {
		int sum = 0;
		int totalSum = 0;
		
		for(int num=1; num<=10; num++) {
			sum += num;
			totalSum += sum;
		}
		System.out.println("totalSum = "+totalSum);
	}
}
