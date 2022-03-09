package ex04;

/*
 * 1 + (-2) + 3 + (-4) + ... 와 같은 식으로 계속 더할 때 몇까지 더해야 총합이 100이상이 되는가?
 */

public class Practice04 {
	public static void main(String[] args) {
		int sum = 0;
		int s = 1; //값의 부호를 바꾸는데 사용할 변수
		int num = 0;
		
		//조건식의 값이 true이므로 무한 반복문
		for (int i = 1; true; i++, s=-s) {
			num = s * i;	 //i와 부호(s)를 곱해서 더할 값을 구한다.
			sum += num;
			
			if(sum >= 100) {
				break;
			}
		}
		System.out.println("num = " + num);
		System.out.println("sum = " + sum);
	}
}
