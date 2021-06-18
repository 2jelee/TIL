package ex18lambda;
/*
 람다식으로 구현하기 ~ 주석 re
	함수형 프로그래밍의 장점이 대두되었고
	이러한 단점을 보완하기 위해 JDK 1.8부터 지원하게 됨.
 */
interface IKosmo3 {
	void studyLamdbda(String str);
}

public class Ex03Lambda { 

	public static void main(String[] args) {

		IKosmo3 kosmo1 = (String str) -> {
			System.out.println(str + "을 드디어 써보네요!");
		};
		kosmo1.studyLamdbda("람다식");
		
		IKosmo3 kosmo2 = str -> System.out.println(str +" 완전 간단..!");
		kosmo2.studyLamdbda("람다식");
	}
}
