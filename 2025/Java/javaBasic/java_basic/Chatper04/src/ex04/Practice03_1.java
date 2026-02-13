package ex04;

/*
 * 1+(1+2)+(1+2+3)+...+(1+2+3+4+....+10) 의 결과는?
 */
public class Practice03_1 {
	public static void main(String[] args) {
		int sum = 0;
		int total = 0;
		
		for (int i = 1; i <= 10; i++) {
			sum = sum+i;
			total = total+sum;
		}
		System.out.println(total);
	}
}
