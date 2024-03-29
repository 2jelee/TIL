package ex04;

/*
 * 숫자로 이루어진 문자열 str이 존재할 때,
 * 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라.
 * 만일 문자열이 "12345"라면 "1+2+3+4+5"인 결과를 출력해야 한다.
 * 
 * Hint) String 클래스의 charAt(int i) 사용
 */

public class Practice07 {
	public static void main(String[] args) {
		String str = "12345";
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0'; //charAt(int i)메서드는 문자열에서 i번째 문자를 반환한다.
		}
		System.out.println("sum = " +sum);
	}
}

/*
charAt(int i)을 이용해서 반복문으로 각 문자열의 문자를 하나씩 읽어서 숫자로 변환한 다음,
sum에 계속 더하면 된다. 문자'3'을 숫자 3로 바꾸는 방법은 문자'3'에서 문자'0'을 빼주는 것이다. 
알파벳이나 숫자는 문자코드가 연속적으로 할당되었기 때문에 이런 방법이 가능하다.

뺄셈과 같은 이항연산자는 int타입보다 작은 타입은 피연산자(byte, short, char)은 int로 변환한다. 
그래서 '3'-'0'은 51 - 48으로 변환되고 그 결과는 숫자 3이 된다.
*/
