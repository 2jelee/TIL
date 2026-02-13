package ex05method;
/*
문제5-4) 파일명 : QuFindPrimeNumber.java  (난이도:상)
전달된 값이 소수인지 아닌지를 판단하여 소수인 경우 true를 아니면 false를
반환하는 메소드를 정의하고, 이를 이용해서 1부터 100사이의 소수를 전부 출력하는 
main메소드를 정의하자.
 */
public class QuFindPrimeNumber {

	public static boolean isPrimeNumber(int num) {
		
		if(num==1) {
			//1은 소수가 아니므로 무조건 false 반환
			return false;
		}
		else {
			/*
			모든 자연수는 1과 자신으로 나눠지므로 두 숫자를 제외한
			나머지 수로 나눠서 떨어지는지 판단하면된다. 
			 */
			for(int i=2 ; i<=num-1 ; i++) {
				//만약 i로 나눠서 떨어지면 소수가 아니므로 false반환
				if(num%i==0)
					return false;
			}
		}
		//위 조건을 통과하면 소수이므로 true반환
		return true;
	}
	public static void main(String[] args) {
		//1~100사이의 정수를 정수인지 판단하기 위해...
		for(int i=1 ; i<=100 ; i++) {
			//아래 함수를 호출하여 소수이면 true를 반환한다.
			if(isPrimeNumber(i)==true) {
				//해당 숫자 i가 소수라면 콘솔에 출력한다. 
				System.out.println("소수:"+ i);
			}
		}
	}
}












