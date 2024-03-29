package ex04;

/*
 * int 타입의 변수 num이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라
 * 만일 변수 num의 값이 12345라면 '1+2+3+4+5'의 결과를 출력해야 한다.
 * 
 * 주의) 문자열로 변환 X -> 숫자로만 처리하라.
 */
public class Practice09 {
	public static void main(String[] args) {
		int num = 12345;
		int sum = 0;
		
		while(num > 0) {
			sum += num%10;
			num /= 10;
		}
		System.out.println(sum);
	}
}
