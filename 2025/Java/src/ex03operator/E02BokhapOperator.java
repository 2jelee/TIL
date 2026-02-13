package ex03operator;

public class E02BokhapOperator {

	public static void main(String[] args) {
		/*
		복합대입연산자
			: 산술연산자와 대입연산자를 연결해놓은 형태로 좌우측의 값을
			연산하여 좌측의 변수에 대입하는 형태의 구조를 가진다. 
			문법구조상 항상 현재 타입을 유지하는 특성을 가지고있다. 
		 */
		double e = 3.1;
		e += 2.1; //3.1+2.1=5.2
		e *= 2;	//5.2*2=10.4		 
		e += e ; //10.4+10.4
		System.out.println("e의 결과값:"+ e);//20.8


		int n = 5;		
		//n = n * 2.7; => 에러발생. 연산의 결과가 double인데 
		//					좌측항이 int이므로 대입불가함. 		
		n = (int)(n * 2.7); //명시적 형변환 후 int형 변수에 대입함. 
		System.out.println("n의 결과값:"+ n); 
				
		n *= 2.7;/*
			정상실행된다. 복합대입연산자의 문법 구조상 기존 자료형을
			그대로 유지하는 특성을 가지고 있다. 따라서 결과는 정수인
			35가 되고, 소수이하는 자동으로 버려진다. 
		*/ 	
		System.out.println("n의 결과값:"+ n);

	}

}
