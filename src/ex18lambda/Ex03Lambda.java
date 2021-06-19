package ex18lambda;

/*
람다식으로 구현하기
	: 객체지향에서는 메소드를 사용하기 위해 반드시 클래스를
	정의한 후 메소드를 선언해야 한다. 이러한 불편한 때문에 최근
	함수형 프로그래밍(Functional Programming)의 장점이 대두되었고
	이런 단점을 보완하기 위해 JDK1.8부터 지원하게 되었다. 
*/
interface IKosmo3 {	
	void studyLambda(String str);
}

public class Ex03Lambda {
	
	public static void main(String[] args) {
		
		//2번 예제의 익명클래스를 람다식으로 표현하면 아래와같다.
		IKosmo3 kosmo1 = (String str) -> {
			System.out.println(str +"을 드디어 써보네요..!!");
		};
		kosmo1.studyLambda("람다식");
		
		IKosmo3 kosmo2 = str -> System.out.println(str +" 완전 간단..!!");
		kosmo2.studyLambda("람다식");
	}
}

