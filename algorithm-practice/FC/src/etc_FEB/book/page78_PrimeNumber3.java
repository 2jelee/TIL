package etc_FEB.book;

/*
 * [1000이하의 소수를 열거 ver03] _알고리즘 개선
 * 
 * 소수의 나열
 * 어떤 정수 이하의 소수를 모두 나열하는 알고리즘
 * 소수는 자신과 1이외의 정수로 나누어 떨어지지 않는 정수.
 * 그러므로 2 ~ n-1까지의 어떤 정수로도 나누어 떨어지지 X
 * 
 * 만약 나누어떨어지는 정수가 하나 이상 존재하면 그 수는 합성수(Composite number).
 * 
 * n이 소수인 경우 : n과 같은 값  		>> for문이 끝까지 실행됨
 * n이 합성수인 경우 : n보다 작은 값   >>for문이 중단됨
 * 
실행 결과 :
			2
			3
			5
			7
			11
			13
			17
			(중략)
			983
			991
			997
			곱셈과 나눗셈을 수행한 횟수 : 3774

 */

public class page78_PrimeNumber3 {
	public static void main(String[] args) { 
		int counter = 0;			//곱셈과 나눗셈의 횟수
		int ptr = 0;				//찾은 소수의 갯수
		int[] prime = new int[500]; //소수를 저장하는 배열
		
		prime[ptr++] = 2; //2는 소수
		prime[ptr++] = 3; //3는 소수
		
		for(int n=5; n<=1000; n+=2) { //대상은 홀수만
			boolean flag = false;
			for(int i=1; prime[i]*prime[i]<=n; i++) {  
				/*
				 * 두 연산(곱셈, 나눗셈)의 수행 횟수를 계산 
				 * => 곱셈 : prime[i] * prime[i]
				 * 	  나눗셈 : n % prime[i]
				 */
				counter+=2;	

				if(n%prime[i]==0) { //나누어 떨어지면 소수가 X
					flag=true;
					break; 			//더 이상 반복 불필요
				}
			}
			if(!flag) { 			//마지막까지 나누어 떨어지지 X
				prime[ptr++] =n; 	//소수라고 배열에 저장
				counter++;
			}
		}
		//찾은 ptr개의 소수를 출력
		for(int i=0; i<ptr; i++) {
			System.out.println(prime[i]);
		}
		System.out.println("곱셈과 나눗셈을 수행한 횟수 : " + counter);
	}
}