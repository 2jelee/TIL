package ex04;

import java.util.Scanner;

public class whileBasic2 {
	public static void main(String[] args) {
		int num = 0, sum = 0;
		System.out.print("숫자를 입력하시오.(ex. 12345) : ");
		
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		num = Integer.parseInt(temp);
		
		while (num!=0) {
			sum += num%10;
			System.out.printf("sum=%3d num=%d%n", sum, num);
			
			num /= 10;
		}
		System.out.println("각 자리수의 합 : " +sum);
		
	}
}
