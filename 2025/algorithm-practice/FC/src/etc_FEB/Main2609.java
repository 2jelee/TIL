package etc_FEB;

/*
[최대공약수와 최소공배수]
Q. 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.


입력 : 첫째 줄에는 두 개의 자연수가 주어진다. 
		이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
출력 : 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 				// %
		둘째 줄에는 입력으로 주어진 두 수의 최소공배수를 출력한다.		// *

예제입력 : 24 18
예제출력 :
			6
			72
*/

/*
 * <유클리드 호제법>
 * 어떤 수 num1과 num2의 최대공약수 = num2, num1 % num2 의 최대공약수
 */

import java.util.Scanner;

public class Main2609 {
	
	//최대공약수
	static int gcd(int num1, int num2) {
		if(num2==0) {
			return num1;
		}
		return gcd(num2, num1 % num2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int gcd = gcd(num1,num2);	//최대공약수
		int lcm = (num1*num2/gcd);	//최소공배수
		
		System.out.println(gcd);
		System.out.println(lcm);
	}
}
